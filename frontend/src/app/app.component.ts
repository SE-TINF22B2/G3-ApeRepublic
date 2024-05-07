import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {ServerApiService} from "../services/server-api/server-api.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'traderTrainer';

  constructor(private router : Router, private server : ServerApiService) {}

  logOut() {
    this.server.logout(localStorage.getItem('token')??'');
    this.router.navigate(['/login'], {});
  }

  loggedOut() {
    return !this.server.validate(localStorage.getItem('token')??'');
  }
}
