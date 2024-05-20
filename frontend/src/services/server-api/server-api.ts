import {Stock} from "../../models/stock/stock";
import {Observable} from "rxjs";

export interface ServerApi {
  stockExists: (isin: string) => boolean;
  getStock: (isin: string) => Stock;
  buyStock: () => boolean;
  sellStock: () => boolean;

  register: (email: string, username: string, firstname: string, lastname: string, password: string, birthday: string) => void;
  login: (email: string, password: string, username: string) => Observable<boolean>;
  logout: (token: string) => void;

  validate: (token: string) => boolean;
}
