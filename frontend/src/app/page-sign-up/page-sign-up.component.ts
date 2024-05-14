import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {FormControl, FormGroup} from "@angular/forms";
import {ServerApiService} from "../../services/server-api/server-api.service";


@Component({
  selector: 'app-page-sign-up',
  templateUrl: './page-sign-up.component.html',
  styleUrls: ['./page-sign-up.component.scss']
})
export class PageSignUpComponent {
  Username : String = '';
  password : string = '';
  retypePassword :string = '';
  isPasswordsmatch : boolean = false;
  isEnabled : boolean = false;

  form = new FormGroup({
    email: new FormControl(''),
    username: new FormControl(''),
    firstname: new FormControl(''),
    lastname: new FormControl(''),
    password: new FormControl(''),
    birthday: new FormControl(''),
  });

  constructor(private router: Router, private serverApi : ServerApiService) {
  }

  public OnInputChanged (e : Event){
    console.log(e);
    this.Username = (<HTMLInputElement>e.target).value;
  }
  public passwordOnChange(e: Event){
this.password = (<HTMLInputElement>e.target).value;
  }
  public retypepasswordOnChange(e : Event){
    this.retypePassword = (<HTMLInputElement>e.target).value;
     this.isPasswordsmatch = this.password === this.retypePassword;
  }
  public userValidation(){
  }
}
