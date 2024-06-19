import { Injectable } from '@angular/core';
import {ServerApi} from "./server-api";
import {HttpClient} from "@angular/common/http";
import {FormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../auth/auth.service";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {map, Observable, tap} from "rxjs";
import {StockInfoService} from "../stockInfo/stock-info.service";
import {Company} from "../../app/page-main/page-main.component";

@Injectable({
  providedIn: 'root'
})
export class ServerApiService implements ServerApi, CanActivate {

  host: string = "http://localhost:8080";

  constructor(private http : HttpClient, private fb : FormBuilder, private authService : AuthService, private stockService: StockInfoService, private router : Router) { }

  buyStock(symbol: any, result: any): Observable<boolean> {
    const form = this.fb.nonNullable.group({
      token: [localStorage.getItem('token') ?? '', Validators.required],
      symbol: [this.stockService.symbol, Validators.required],
      amount: [parseFloat(result), Validators.required],
    });
    return this.http.post<any>(this.host + "/api/stock/trade", form.getRawValue())
      .pipe(
        map((response) => response.status === 'success')
      );
  }

  sellStock(symbol: any, result: any): Observable<boolean> {
    const form = this.fb.nonNullable.group({
      token: [localStorage.getItem('token') ?? '', Validators.required],
      symbol: [this.stockService.symbol, Validators.required],
      amount: [Math.abs(parseFloat(result)) * -1, Validators.required],
    });
    return this.http.post<any>(this.host + "/api/stock/trade", form.getRawValue())
      .pipe(
        map((response) => response.status === 'success')
      );
  }

  updatePosition(symbol: any) {
    const form = this.fb.nonNullable.group({
      token: [localStorage.getItem('token') ?? '', Validators.required],
      symbol: [this.stockService.symbol, Validators.required],
    });
    this.http.post<any>(this.host + "/api/stock/position", form.getRawValue()  )
      .pipe(
        tap((response) => {
          if (response.position) {
            this.stockService.currentStock()!.userShares = response.position.amount;
            this.stockService.currentStock()!.buyIn = response.position.avgBuyPrice;
          }
        })
      )
      .subscribe(() => {
      });
  }

  getPositions(): Observable<Company[]> {
    const form = this.fb.nonNullable.group({
      token: [localStorage.getItem('token') ?? '', Validators.required]
    });

    return this.http.post<any>(`${this.host}/api/stock/portfolio`, form.getRawValue())
      .pipe(
        map((response) => {
          let arr: Company[] = [];
          for (const position of response.positions) {
            if (position.amount != 0) {
              this.http.get<any>(this.host + "/companySymbol", {params: {symbol: position.symbol,}})
                .pipe(
                  tap((response2) => {
                    let form = this.fb.nonNullable.group({
                      token: [localStorage.getItem('token')??'', Validators.required],
                      symbol: [position.symbol, Validators.required]
                    });
                    this.http.post<any>(this.host + "/stock/price/realtime", form.getRawValue()  )
                      .pipe(
                        tap((response3) => {
                          arr.push({
                            symbol: position.symbol,
                            name: response2.name,
                            amount: String((response3.prices[0].price * position.amount).toFixed(2)),
                            absolute: String(((response3.prices[0].price - position.avgBuyPrice) * position.amount).toFixed(2)),
                            relative: String(((response3.prices[0].price / position.avgBuyPrice) * 100 - 100).toFixed(2))
                          });
                          console.log(arr);
                        })
                      )
                      .subscribe(() => {
                      });
                  })
                )
                .subscribe(() => {
                });
            }
          }
          return arr;
        })
      );
  }

  getStockPrice() {
    let form = this.fb.nonNullable.group({
      token: [localStorage.getItem('token')??'', Validators.required],
      symbol: [this.stockService.symbol, Validators.required]
    });
    this.http.post<any>(this.host + "/stock/price/realtime", form.getRawValue()  )
      .pipe(
        tap((response) => {
          if (this.stockService.latestPrice == "----" && response.prices) {
            this.stockService.firstPrice = response.prices[0].price;
            this.stockService.firstTimestamp = response.prices[0].timestamp;
          }
          if (response.prices) {
            this.stockService.latestPrice = response.prices[0].price;
          }
        })
      )
      .subscribe(() => {
      });
  }

  getStockProgression() {
    let form = this.fb.nonNullable.group({
      token: [localStorage.getItem('token')??'', Validators.required],
      symbol: [this.stockService.symbol, Validators.required]
    });
    this.http.post<any>(this.host + "/stock/price/progression", form.getRawValue()  )
      .pipe(
        tap((response) => {
          if (response.prices) {
            for (const price of response.prices) {
            // @ts-ignore
              this.stockService.prices.push(price);
            }
          }
        })
      )
      .subscribe(() => {
      });
  }

  getStockInfo(symbol: string | null): Observable<boolean> {
    if (symbol !== null) {
      return new Observable<boolean>(observer => {
        this.http.get<any>(this.host + "/companySymbol", {params: {symbol: symbol,}})
          .pipe(
            tap((response) => {
              if (response.name !== null) {
                this.stockService.currentStock.set(response);
                this.stockService.symbol = symbol;
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
      /* this.stockService.currentStock.set(JSON.parse('{ "name" : "Apple", "price" : "53", "symbol" : "812382138"}'));
      return true; */
    }
    this.router.navigate(['/main']);
    return new Observable<boolean>(observer => {observer.next(false)});
  }

  login(email: string, password: string): Observable<boolean> {
    return new Observable<boolean>(observer => {
      let form = this.fb.nonNullable.group({
        email: [email, Validators.required],
        password: [password, Validators.required]
      });

      this.http.post<any>(this.host + "/api/user/auth/login", form.getRawValue())
        .pipe(
          tap((response) => {
            if (response.status == 'success') {
              localStorage.setItem('token', response.sessionTokenId);
              this.authService.currentUserSig.set(response.userDetails);
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
            if (response.status === 'success') {
              localStorage.setItem('token', response.sessionTokenId);
              this.authService.currentUserSig.set(response.userDetails);
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

  stockExists(symbol: string): boolean {
    return false;
  }

  validate(token: string): Observable<boolean> {
    return new Observable<boolean>(observer => {
      let form = this.fb.nonNullable.group({
        token: [token, Validators.required]
      });

      this.http.post<any>(this.host + "/api/user/auth/validate", form.getRawValue())
        .pipe(
          tap((response) => {
            if (response.status == 'success') {
              observer.next(true);
              this.authService.isValid = true;
              this.authService.currentUserSig.set(response.userDetails);
            } else {
              observer.next(false);
              this.authService.isValid = false;
            }
          })
        )
        .subscribe(() => {
          observer.complete();
        });
    });
  }

  openWebsocket(symbol: string) {
    this.http.get<any>(this.host + "/stock/openWebSocket",{params: {symbol: symbol}})
      .pipe(tap()).subscribe();
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    // @ts-ignore
    if (route.url.at(0).path == 'logout') {
      this.logout(localStorage.getItem('token')??'');
      this.authService.isValid = true;
      return true;
    }
    return this.validate(localStorage.getItem('token') ?? '').toPromise().then(isValidToken => {
      // @ts-ignore
      if (isValidToken) {
        if (route.url[0].path === 'login') {
          this.router.navigate(['/main']);
          return false;
        } else {
          return true;
        }
      } else {
        if (route.url[0].path === 'login') {
          return true;
        } else {
          this.router.navigate(['/login']);
          return false;
        }
      }
    }).catch(() => {
      this.router.navigate(['/login']);
      return false;
    });
  }
}
