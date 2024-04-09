import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsernameService } from '../username.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(private router: Router, private un: UsernameService) {
  }

  userValidation() {
    this.un.username = "Simon";
    this.router.navigate(['/main'], {});
 }
}
