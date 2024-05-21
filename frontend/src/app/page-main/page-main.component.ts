import {Component, ElementRef, ViewChild, WritableSignal} from '@angular/core';
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
export class PageMainComponent {
  @ViewChild('isinInput') isinInput!: ElementRef;

  displayedColumns: String[] = ["ISIN", "Name", "Amount", "Absolute", "Relative"];
  dataSource: Company[] = [
    {isin : 182312838, name : "Apple", amount : "3030$", absolute : "483428", relative : "283282%"},
    {isin : 182312838, name : "Google", amount : "3843724$", absolute : "398248", relative : "956%"},
    {isin : 182312838, name : "Nvidia", amount : "12313$", absolute : "1273", relative : "127321%"},
  ]

  constructor(private router: Router, private auth : AuthService) {
  }

  getUsername() : String {
    return this.auth.currentUserSig()?.username ?? '';
  }

  protected readonly onsubmit = onsubmit;

  onSubmit() {
    this.router.navigate( ['/stock'], { queryParams: { isin: this.isinInput.nativeElement.value} } );
  }
}
