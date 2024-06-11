import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {ServerApiService} from "../server-api/server-api.service";
import {StockInfoService} from "../stockInfo/stock-info.service";

@Injectable({
  providedIn: 'root'
})
export class IsinGuardService implements CanActivate{

  constructor( private serverApi : ServerApiService, private stock : StockInfoService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let obs : Observable<boolean> = this.serverApi.getStockInfo(route.queryParamMap.get('symbol'));
    obs.subscribe(value => {
      if (value) {
        this.serverApi.openWebsocket(route.queryParamMap.get('symbol')??'');
      }
    });
    return obs;
  }
}
