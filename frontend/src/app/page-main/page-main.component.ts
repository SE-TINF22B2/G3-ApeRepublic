import {Component, ElementRef, OnInit, ViewChild, WritableSignal} from '@angular/core';
import { Router } from '@angular/router'
import {AuthService} from "../../services/auth/auth.service";
import {FormControl, Validators} from "@angular/forms";
import {map, Observable, startWith} from "rxjs";

export interface Company {
  symbol: String;
  name: String;
  amount: String;
  absolute: String;
  relative: String
}

@Component({
  selector: 'app-page-main',
  templateUrl: './page-main.component.html',
  styleUrls: ['./page-main.component.scss']
})
export class PageMainComponent implements OnInit {
  @ViewChild('symbolInput') symbolInput!: ElementRef;

  error = false;

  displayedColumns: String[] = ["Symbol", "Name", "Amount", "Absolute", "Relative"];
  dataSource: Company[] = [
    {symbol : "182312838", name : "Apple", amount : "3030$", absolute : "483428", relative : "283282%"},
    {symbol : "182312838", name : "Google", amount : "3843724$", absolute : "398248", relative : "956%"},
    {symbol : "182312838", name : "Nvidia", amount : "12313$", absolute : "1273", relative : "127321%"},
  ]

  myControl = new FormControl('');
  options: string[] = [];
  filteredOptions: Observable<string[]> = new Observable<string[]>();

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    this.loadPastSearches();
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map((value: any) => this._filter(value || '')),
    );
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
