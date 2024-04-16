import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsernameService } from '../username.service';


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
  constructor(private router: Router, private un: UsernameService) {
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
    this.un.username = " ";
    this.router.navigate(['/main'], {});
  }
}
