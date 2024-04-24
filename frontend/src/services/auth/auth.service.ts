import { Injectable, signal } from '@angular/core';
import { UserInterface } from "../../models/user/user";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {ServerApiService} from "../server-api/server-api.service";

@Injectable({
  providedIn: 'root',
})
export class AuthService implements CanActivate {
  currentUserSig = signal<UserInterface | undefined | null>(undefined);

  constructor(private router: Router) {}


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.currentUserSig()) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
}
