import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {ServerApiService} from "../../services/server-api/server-api.service";
import {FormControl, FormGroup} from "@angular/forms";


@Component({
  selector: 'app-page-login',
  templateUrl: './page-login.component.html',
  styleUrls: ['./page-login.component.scss']
})
export class PageLoginComponent {

  Username : String = '';

  form = new FormGroup({
    email: new FormControl("email"),
    password: new FormControl("password"),
  });

  constructor(private router: Router, private serverApi: ServerApiService) {
  }

  public OnInputChanged (e : Event){
    console.log(e);
    this.Username = (<HTMLInputElement>e.target).value;
  }

  userValidation() {
    this.serverApi.login(this.form.value.email ?? '', this.form.value.password ?? '');
 }
}
