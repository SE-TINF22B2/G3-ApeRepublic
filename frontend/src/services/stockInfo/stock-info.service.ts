import {Injectable, signal} from '@angular/core';
import {StockInterface} from "../../models/stock/stockIntf";

@Injectable({
  providedIn: 'root'
})
export class StockInfoService {
  currentStock = signal<StockInterface | undefined | null>(undefined);
  symbol : string = "";
  constructor() { }
}
