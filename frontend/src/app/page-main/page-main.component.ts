import {Component, ElementRef, OnInit, ViewChild, WritableSignal} from '@angular/core';
import { Router } from '@angular/router'
import {AuthService} from "../../services/auth/auth.service";
import {UserInterface} from "../../models/user/userIntf";

export interface Company {
  isin: number;
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
  @ViewChild('isinInput') isinInput!: ElementRef;

  displayedColumns: String[] = ["ISIN", "Name", "Amount", "Absolute", "Relative"];
  dataSource: Company[] = [
    {isin : 182312838, name : "Apple", amount : "3030$", absolute : "483428", relative : "283282%"},
    {isin : 182312838, name : "Google", amount : "3843724$", absolute : "398248", relative : "956%"},
    {isin : 182312838, name : "Nvidia", amount : "12313$", absolute : "1273", relative : "127321%"},
  ]

  pastSearches: string[] = [];
  filteredSearches: string[] = [];
  showDropdown: boolean = false;
  constructor(private router: Router, private auth : AuthService) {
  }

  ngOnInit(): void {
    this.loadPastSearches();
  }

  saveSearchTerm(term: string) {
    if (!this.pastSearches.includes(term)) {
      this.pastSearches.push(term);
      if (this.pastSearches.length >= 6) {
        this.pastSearches.reverse();
        this.pastSearches.pop();
        this.pastSearches.reverse();
      }
      localStorage.setItem('pastSearches', JSON.stringify(this.pastSearches));
    }
  }

  loadPastSearches() {
    const searches = localStorage.getItem('pastSearches');
    if (searches) {
      this.pastSearches = JSON.parse(searches);
    }
  }

  selectTerm(term: string) {
    this.showDropdown = false;
    this.isinInput.nativeElement.value = term;
  }

  showSuggestions() {
    this.filteredSearches = [];
    for (const entry of this.pastSearches) {
      if (entry.toLowerCase().startsWith(this.isinInput.nativeElement.value.toLowerCase())) {
        this.filteredSearches.push(entry);
      }
    }
    this.showDropdown = true;
  }

  getUsername() : String {
    return this.auth.currentUserSig()?.username ?? '';
  }

  protected readonly onsubmit = onsubmit;

  onSubmit() {
    let isinValue = this.isinInput.nativeElement.value;
    this.router.navigate(['/stock'], { queryParams: { isin: isinValue } }).then(success => {
      if (success) {
        this.saveSearchTerm(this.isinInput.nativeElement.value);
      }
    });
  }
}
