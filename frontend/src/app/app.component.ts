import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {ServerApiService} from "../services/server-api/server-api.service";
import {AuthService} from "../services/auth/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'traderTrainer';

  constructor(protected router : Router, private server : ServerApiService, private auth : AuthService) {}

  logOut() {
    this.server.logout(localStorage.getItem('token')??'');
    this.router.navigate(['/login'], {});
  }

  loggedIn(): boolean {
    return this.auth.isValid;
  }
}
