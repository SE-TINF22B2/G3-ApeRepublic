import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-page-login',
  templateUrl: './page-login.component.html',
  styleUrls: ['./page-login.component.scss']
})
export class PageLoginComponent {

  Username : String = '';
  constructor(private router: Router) {
  }

  public OnInputChanged (e : Event){
    console.log(e);
    this.Username = (<HTMLInputElement>e.target).value;
  }

  userValidation() {
    this.router.navigate(['/main'], {});
 }
}
