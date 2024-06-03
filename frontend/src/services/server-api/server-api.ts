import {Observable} from "rxjs";

export interface ServerApi {
  stockExists: (symbol: string) => boolean;
  getStockInfo: (symbol: string | null) => Observable<boolean>;
  buyStock: (symbol: any, result: any) => boolean;
  sellStock: (symbol: string | undefined, result: any) => boolean;

  register: (email: string, username: string, firstname: string, lastname: string, password: string, birthday: string) => void;
  login: (email: string, password: string, username: string) => Observable<boolean>;
  logout: (token: string) => void;

  validate: (token: string) => Observable<boolean>;
}
