import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsernameService } from '../../services/username-example/username.service';


@Component({
  selector: 'app-page-login',
  templateUrl: './page-login.component.html',
  styleUrls: ['./page-login.component.scss']
})
export class PageLoginComponent {

  constructor(private router: Router, private un: UsernameService) {
  }

  userValidation() {
    this.un.username = "Simon";
    this.router.navigate(['/main'], {});
 }
}
