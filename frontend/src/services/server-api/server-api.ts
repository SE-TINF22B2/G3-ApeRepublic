import {Observable} from "rxjs";

export interface ServerApi {
  stockExists: (isin: string) => boolean;
  getStock: (isin: string | null) => Observable<boolean>;
  buyStock: (isin: any, result: any) => boolean;
  sellStock: (isin: string | undefined, result: any) => boolean;

  register: (email: string, username: string, firstname: string, lastname: string, password: string, birthday: string) => void;
  login: (email: string, password: string, username: string) => Observable<boolean>;
  logout: (token: string) => void;

  validate: (token: string) => boolean;
}
