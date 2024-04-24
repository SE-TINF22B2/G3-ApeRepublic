import { Injectable } from '@angular/core';
import {ServerApi} from "./server-api";
import {Stock} from "../../models/stock/stock";
import {HttpClient} from "@angular/common/http";
import {FormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../auth/auth.service";
import {UserInterface} from "../../models/user/user";
import {UserAuthResponse} from "../../models/userAuthResponse/user-auth-response";
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ServerApiService implements ServerApi, CanActivate {

  host: string = "localhost:8080";

  constructor(private http : HttpClient, private fb : FormBuilder, private authService : AuthService) { }

  buyStock(): boolean {
    return false;
  }

  getStock(isin: string): Stock {
    return new Stock();
  }

  login(email: string, password: string): void {
    let form = this.fb.nonNullable.group({
      email: [email, Validators.required],
      password: [password, Validators.required],
    });

    this.http
      .post<{ userAuthResponse: UserAuthResponse }>(this.host + "/login", {
        user: form.getRawValue(),
      })
      .subscribe((response) => {
        console.log('response', response);
        localStorage.setItem('token', response.userAuthResponse.user.token);
        this.authService.currentUserSig.set(response.userAuthResponse.user);
      });
  }

  logout(token: string): void {
  }

  register(email: string, username: string, firstname: string, lastname: string, password: string, birthday: string): void {
    let form = this.fb.nonNullable.group({
      username: [username, Validators.required],
      firstname: [firstname, Validators.required],
      lastname: [lastname, Validators.required],
      email: [email, Validators.required],
      birthday: [birthday, Validators.required],
      password: [password, Validators.required],
    });

    this.http
      .post<{ userAuthResponse: UserAuthResponse }>(this.host + "/register", {
        user: form.getRawValue(),
      })
      .subscribe((response) => {
        console.log('response', response);
        localStorage.setItem('token', response.userAuthResponse.user.token);
        this.authService.currentUserSig.set(response.userAuthResponse.user);
      });
  }

  sellStock(): boolean {
    return false;
  }

  stockExists(isin: string): boolean {
    return false;
  }

  validate(token: string): boolean {
    if (token.length === 0) {
      return false;
    }
    return true;
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.validate(this.authService.currentUserSig()?.token ?? 'MockToken');
  }
}
