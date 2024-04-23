import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsernameService } from '../username.service';


@Component({
  selector: 'app-login',
  templateUrl: './page-login.component.html',
  styleUrls: ['./page-login.component.scss']
})
export class LoginComponent {


  Username : String = '';
  constructor(private router: Router, private un: UsernameService) {
  }

  public OnInputChanged (e : Event){
    console.log(e);
    this.Username = (<HTMLInputElement>e.target).value;
  }

  userValidation() {
    this.un.username = "Simon";
    this.router.navigate(['/main'], {});
 }
}
