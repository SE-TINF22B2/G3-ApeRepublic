import { Component } from '@angular/core';
import { Router } from '@angular/router'
import { UsernameService } from '../username.service';

export interface Company {
  isin: number;
  name: String;
  amount: String;
  absolute: String;
  relative: String
}

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent {
  displayedColumns: String[] = ["ISIN", "Name", "Amount", "Absolute", "Relative"];
  dataSource: Company[] = [
    {isin : 182312838, name : "Apple", amount : "3030$", absolute : "483428", relative : "283282%"},
    {isin : 182312838, name : "Google", amount : "3843724$", absolute : "398248", relative : "956%"},
    {isin : 182312838, name : "Nvidia", amount : "12313$", absolute : "1273", relative : "127321%"},
  ]


  constructor(private router: Router, public un: UsernameService) {
  }

  logOut() {
    
    this.router.navigate(['/login'], {});
  }
}
