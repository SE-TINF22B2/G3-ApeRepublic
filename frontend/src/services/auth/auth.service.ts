import { Injectable, signal } from '@angular/core';
import { UserInterface } from "../../models/user/userIntf";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {ServerApiService} from "../server-api/server-api.service";

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  currentUserSig = signal<UserInterface | undefined | null>(undefined);
  constructor(private router: Router) {}
}
