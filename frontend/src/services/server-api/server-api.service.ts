import { Injectable } from '@angular/core';
import {ServerApi} from "./server-api";
import {Stock} from "../../models/stock/stock";

@Injectable({
  providedIn: 'root'
})
export class ServerApiService implements ServerApi {
  constructor() { }

  buyStock(): boolean {
    return false;
  }

  getStock(isin: string): Stock {
    return undefined;
  }

  login(email: string, password: string): void {
  }

  logout(token: string): void {
  }

  register(email: string, username: string, firstname: string, lastname: string, password: string, birthday: string): void {
  }

  sellStock(): boolean {
    return false;
  }

  stockExists(isin: string): boolean {
    return false;
  }

  validate(token: string): boolean {
    return false;
  }


}
