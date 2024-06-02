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
  hide = true;

  form = new FormGroup({
    name: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private router: Router, private serverApi: ServerApiService) {
  }

  public OnInputChanged (e : Event){
    this.Username = (<HTMLInputElement>e.target).value;
  }

  login() {
    for (const controlName in this.form.controls) {
      const control = this.form.get(controlName);
      if (control?.value === '') {
        return;
      }
    }
    /*
    let email = '';
    let username = '';
    if (this.form.getRawValue().name?.includes('@')) {
      email = this.form.getRawValue().name?? '';
    } else {
      username = this.form.getRawValue().name?? '';
    }
    this.serverApi.login(email, this.form.value.password ?? '', username).subscribe((loginSuccessful) => {
      if (loginSuccessful) {
        this.router.navigate(['/main']);
      }
    });
    */
    this.serverApi.login(this.form.value.name ?? '', this.form.value.password ?? '', 'enexhd').subscribe((loginSuccessful) => {
      if (loginSuccessful) {
        this.router.navigate(['/main']);
      }
    });
 }
}
