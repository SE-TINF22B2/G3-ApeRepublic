import {Observable} from "rxjs";
import {Company} from "../../app/page-main/page-main.component";

export interface ServerApi {
  stockExists: (symbol: string) => boolean;
  getStockInfo: (symbol: string | null) => Observable<boolean>;
  getStockPrice: (symbol: string) => void;
  getStockProgression: (symbol: string) => void;
  buyStock: (symbol: any, result: any) => Observable<boolean>;
  sellStock: (symbol: any, result: any) => Observable<boolean>;
  updatePosition: (symbol: any) => void;
  getPositions: () => Observable<Company[]>;
  openWebsocket: (symbol: string) => void;

  register: (email: string, username: string, firstname: string, lastname: string, password: string, birthday: string) => void;
  login: (email: string, password: string, username: string) => Observable<boolean>;
  logout: (token: string) => void;

  validate: (token: string) => Observable<boolean>;
}
