import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: '[app-page-sign-up]',
  templateUrl: './page-sign-up.component.html',
  styleUrls: ['./page-sign-up.component.scss']
})
export class PageSignUpComponent {
  Username : String = '';
  password : string = '';
  retypePassword :string = '';
  isPasswordsmatch : boolean = false;
  isEnabled : boolean = false;
  constructor(private router: Router) {
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
     if(this.password !== this.retypePassword){
      this.isPasswordsmatch = false;
     }else{
      this.isPasswordsmatch = true;
     }
  }
  public userValidation(){
    this.router.navigate(['/main'], {});
  }
}
