import {Component, ElementRef, ViewChild, ViewEncapsulation} from '@angular/core';
import { Router } from '@angular/router';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ServerApiService} from "../../services/server-api/server-api.service";


@Component({
  selector: 'app-page-sign-up',
  templateUrl: './page-sign-up.component.html',
  styleUrls: ['./page-sign-up.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class PageSignUpComponent {

  Username : String = '';
  password : string = '';
  retypePassword :string = '';
  isPasswordsmatch : boolean = false;
  hide: boolean = true;
  registerSuccessful: boolean = true;

  form = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    username: new FormControl('', [Validators.required]),
    firstname: new FormControl('', [Validators.required]),
    lastname: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
    birthday: new FormControl('', [Validators.required]),
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
  public register(){
    for (const controlName in this.form.controls) {
      const control = this.form.get(controlName);
      if (control?.value === '') {
        return;
      }
    }
    this.serverApi.register(this.form.value.email ?? '', this.form.value.username ?? '', this.form.value.firstname ?? '', this.form.value.lastname ?? '', this.form.value.password ?? '', this.formatDate(this.form.value.birthday??'') ?? '').subscribe((registerSuccessful) => {
      if (registerSuccessful) {
        this.router.navigate(['/main']);
      }
      this.registerSuccessful = registerSuccessful;
    });
  }

  formatDate(dateStr: string): string {
    const date = new Date(dateStr);

    // Extract the year, month, and day
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0'); // Months are zero-indexed
    const day = String(date.getDate()).padStart(2, '0');

    // Format as YYYY-MM-DD
    return `${year}-${month}-${day}`;
  }
}
