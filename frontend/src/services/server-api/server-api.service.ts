import { Injectable } from '@angular/core';
import {ServerApi} from "./server-api";
import {Stock} from "../../models/stock/stock";
import {HttpClient} from "@angular/common/http";
import {FormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../auth/auth.service";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ServerApiService implements ServerApi, CanActivate {

  host: string = "http://localhost:8080";

  constructor(private http : HttpClient, private fb : FormBuilder, private authService : AuthService, private router : Router) { }

  buyStock(): boolean {
    return false;
  }

  getStock(isin: string): Stock {
    return new Stock();
  }

  login(email: string, password: string, username: string): Observable<boolean> {
    return new Observable<boolean>(observer => {
      let form = this.fb.nonNullable.group({
        email: [email, Validators.required],
        password: [password, Validators.required],
        username: [username, Validators.required]
      });

      this.http.post<any>(this.host + "/api/user/auth/login", form.getRawValue())
        .pipe(
          tap((response) => {
            console.log('response', response);
            if (response.success) {
              localStorage.setItem('token', response.success.sessionTokenId);
              this.authService.currentUserSig.set(response.success.userDetails);
              observer.next(true);
            } else {
              observer.next(false);
            }
          })
        )
        .subscribe(() => {
          observer.complete();
        });
    });
  }

  logout(token: string): void {
    localStorage.removeItem('token');
  }

  register(email: string, username: string, firstname: string, lastname: string, password: string, birthday: string): Observable<boolean> {
    return new Observable<boolean>(observer => {
      let form = this.fb.nonNullable.group({
        username: [username, Validators.required],
        firstname: [firstname, Validators.required],
        lastname: [lastname, Validators.required],
        email: [email, Validators.required],
        birthday: [birthday, Validators.required],
        password: [password, Validators.required],
      });

      this.http.post<any>(this.host + "/api/user/auth/register", form.getRawValue())
        .pipe(
          tap((response) => {
            console.log('response', response);
            if (response.success) {
              localStorage.setItem('token', response.success.sessionTokenId);
              this.authService.currentUserSig.set(response.success.userDetails);
              observer.next(true);
            } else {
              observer.next(false);
            }
          })
        )
        .subscribe(() => {
          observer.complete();
        });
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
    // @ts-ignore
    if (route.url.at(0).path == 'logout') {
      this.logout(localStorage.getItem('token')??'');
      return true;
    }
    // @ts-ignore
    if (route.url.at(0).path == 'login') {
      if (this.validate(localStorage.getItem('token')??'')) {
        this.router.navigate(['/main']);
        return false;
      }
      return true;
    }

    if (this.validate(localStorage.getItem('token')??'')) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
}
