import {Component, ElementRef, OnDestroy, OnInit, ViewChild, WritableSignal} from '@angular/core';
import { Router } from '@angular/router'
import {AuthService} from "../../services/auth/auth.service";
import {FormControl, Validators} from "@angular/forms";
import {interval, map, Observable, startWith, Subscription} from "rxjs";
import {ServerApiService} from "../../services/server-api/server-api.service";
import {MatTable} from "@angular/material/table";

export interface Company {
  symbol: string;
  name: string;
  amount: string;
  absolute: string;
  relative: string
}

export interface PriceData {
  price: number;
  timestamp: number;
}

@Component({
  selector: 'app-page-main',
  templateUrl: './page-main.component.html',
  styleUrls: ['./page-main.component.scss']
})

export class PageMainComponent implements OnInit, OnDestroy {
  @ViewChild('symbolInput') symbolInput!: ElementRef;
  @ViewChild('myTable') table!: MatTable<Company>;

  error = false;

  displayedColumns: String[] = ["Symbol", "Name", "Amount", "Absolute", "Relative"];
  dataSource: Company[] = [];

  myControl = new FormControl('');
  options: string[] = [];
  filteredOptions: Observable<string[]> = new Observable<string[]>();

  mySub: Subscription | undefined;
  portfolioPriceHistory: [] = [];

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

  constructor(private router: Router, private serverAPI: ServerApiService, public authService: AuthService) {
  }

  ngOnInit(): void {
    this.loadPastSearches();
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map((value: any) => this._filter(value || '')),
    );
    this.serverAPI.getPositions().subscribe((companies) => {
      this.dataSource = companies;
    });
    setTimeout(() => {
      this.dataSource.sort((a, b) => parseFloat(b.amount) - parseFloat(a.amount));
      this.table.renderRows();
      let sum = 0;
      for (const company of this.dataSource) {
        sum += parseFloat(company.amount);
      }
      // @ts-ignore
      this.portfolioPriceHistory.push({price: sum, timestamp: Date.now()});
      this.authService.currentUserSig()!.portfolioPrice = sum;
    }, 1000);
    this.mySub = interval(5000).subscribe((func => {
      this.serverAPI.getPositions().subscribe((companies) => {
        setTimeout(() => {
          let sum = 0;
          for (const company of companies) {
            sum += parseFloat(company.amount);
          }
          // @ts-ignore
          this.portfolioPriceHistory.push({price: sum, timestamp: Date.now()});
          this.authService.currentUserSig()!.portfolioPrice = sum;
        }, 1000)
      });
    }));
  }

  ngOnDestroy(): void {
    this.mySub?.unsubscribe();
  }

  updateTable() {
    this.serverAPI.getPositions().subscribe((companies) => {
      this.dataSource = companies;
    });
    setTimeout(() => {
      this.dataSource.sort((a, b) => parseFloat(b.amount) - parseFloat(a.amount));
      this.table.renderRows();
    }, 1000);
  }

  saveSearchTerm(term: string) {
    if (!this.options.includes(term)) {
      this.options.push(term);
      if (this.options.length >= 6) {
        this.options.reverse();
        this.options.pop();
        this.options.reverse();
      }
      localStorage.setItem('pastSearches', JSON.stringify(this.options));
    }
  }

  loadPastSearches() {
    const searches = localStorage.getItem('pastSearches');
    if (searches) {
      this.options = JSON.parse(searches);
    }
  }

  protected readonly onsubmit = onsubmit;

  onSubmit() {
    let symbolValue = this.symbolInput.nativeElement.value;
    this.router.navigate(['/stock'], { queryParams: { symbol: symbolValue } }).then(success => {
      if (success) {
        this.saveSearchTerm(this.symbolInput.nativeElement.value.toUpperCase());
        this.error = false;
      } else {
        this.error = true;
      }
    });
  }
}
