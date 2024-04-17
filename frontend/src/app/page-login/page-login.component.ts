import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-page-login',
  templateUrl: './page-login.component.html',
  styleUrls: ['./page-login.component.scss']
})
export class PageLoginComponent {

  constructor(private router: Router) {
  }

  userValidation() {
    //this.un.username = "Simon";
    this.router.navigate(['/main'], {});
 }
}
