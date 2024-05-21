import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {ServerApiService} from "../server-api/server-api.service";

@Injectable({
  providedIn: 'root'
})
export class IsinGuardService implements CanActivate{

  constructor( private serverApi : ServerApiService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.serverApi.getStock(route.queryParamMap.get('isin'));
  }
}
