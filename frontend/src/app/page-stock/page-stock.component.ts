import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {StockInfoService} from "../../services/stockInfo/stock-info.service";
import {AuthService} from "../../services/auth/auth.service";
import {ServerApiService} from "../../services/server-api/server-api.service";
import {Router} from "@angular/router";
import {interval, Subscription, takeWhile} from "rxjs";

@Component({
  selector: 'app-page-stock',
  templateUrl: './page-stock.component.html',
  styleUrls: ['./page-stock.component.scss']
})
export class PageStockComponent implements OnInit, OnDestroy {
  latestStockPrice: any = "----";

  mySub: Subscription | undefined;

  constructor(public dialog: MatDialog, public stock: StockInfoService, private serverApi: ServerApiService, private router : Router) {}

  ngOnInit(): void {
    this.serverApi.getStockPrice();
    this.serverApi.getStockProgression();
    this.serverApi.updatePosition(this.stock.currentStock()!.ticker);
    this.mySub = interval(1000).subscribe((func => {
      this.serverApi.getStockPrice();
      this.serverApi.getStockProgression();
      if (this.stock.latestPrice !== '----') {
        this.latestStockPrice = parseFloat(this.stock.latestPrice).toFixed(2);
      }
    }));
  }


  firstEntryTime() {
    return new Date(parseInt(this.stock.firstTimestamp)).toLocaleTimeString();
  }

  isAbsoluteDifferencePositive(): boolean {
    return parseFloat(this.absoluteDifference()) >= 0;
  }

  absoluteDifference() {
    return (this.latestStockPrice - this.stock.firstPrice).toFixed(2);
  }

  relativeDifference() {
    return ((this.stock.firstPrice / this.latestStockPrice) - 1).toFixed(2);

  }

  ngOnDestroy(): void {
    this.mySub?.unsubscribe();
  }

  openBuyDialog(): void {
    const dialogRef = this.dialog.open(BuyPopup, {
      width: '30%',
      data: {name: this.stock.currentStock()?.name, price: "300$", capital: "400$"}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.serverApi.buyStock(this.stock.currentStock()?.ticker, result).subscribe((isSuccess) => {
          if (isSuccess) {
            this.serverApi.updatePosition(this.stock.currentStock()?.ticker);
            this.openSuccessDialog();
          }
          else {
            this.openErrorDialog();
          }
        })
      }
    });
  }

  openSellDialog(): void {
    const dialogRef = this.dialog.open(SellPopup, {
      width: '30%',
      data: {name: this.stock.currentStock()?.name, price: "300$", position: "600$"}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.serverApi.sellStock(this.stock.currentStock()?.ticker, result).subscribe((isSuccess) => {
          if (isSuccess) {
            this.serverApi.updatePosition(this.stock.currentStock()?.ticker);
            this.openSuccessDialog();
          }
          else {
            this.openErrorDialog();
          }
        })
      }
    });
  }

  openSuccessDialog(): void {
    const dialogRef = this.dialog.open(SuccessPopup, {width: '30%',});
  }
  openErrorDialog(): void {
    const dialogRef = this.dialog.open(ErrorPopup, {width: '30%',});
  }

  backToMain() {
    this.router.navigate(['/main']);
  }

  protected readonly parseFloat = parseFloat;
}

export interface DialogData {
  capital: string;
  amount: string;
  name: string;
  price: string;
  shares: string;
  position: string;
}

@Component({
  selector: 'buy',
  templateUrl: 'buy.html',
})
export class BuyPopup {

  constructor(
    public dialogRef: MatDialogRef<BuyPopup>,
    public stock: StockInfoService,
    @Inject(MAT_DIALOG_DATA) public data: DialogData)
  {
      this.data.shares = "0";
      this.data.amount = "0";
  }

  public OnAmountInputChanged (e : Event){
    this.data.amount = this.data.amount.replace(/^0+/, "");
    this.data.shares = String(Math.round(parseFloat(this.data.amount) / parseFloat(this.stock.latestPrice) * 100) / 100);
    if (this.data.shares == "NaN") {
     this.data.shares = "0";
    }
  }
  public OnShareInputChanged (e : Event){
    if (!this.data.shares.startsWith('0.')) { this.data.shares = this.data.shares.replace(/^0+/, "");}
    this.data.amount = String(parseFloat(this.data.shares) * parseFloat(this.stock.latestPrice));
    if (this.data.amount == "NaN") {
      this.data.amount = "0";
    }
  }


  onNoClick(): void {
    this.dialogRef.close();
  }

  enoughCapital() {
    //return parseFloat(this.data.amount) <= parseFloat(this.data.capital) && parseFloat(this.data.amount) > 0 ;
    return parseFloat(this.data.amount) > 0
  }
}

@Component({
  selector: 'sell',
  templateUrl: 'sell.html',
})
export class SellPopup {

  constructor(
    public dialogRef: MatDialogRef<BuyPopup>,
    public stock: StockInfoService,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
    this.data.shares = "0";
    this.data.amount = "0";
  }

  public OnAmountInputChanged (e : Event){
    this.data.amount = this.data.amount.replace(/^0+/, "");
    this.data.shares = String(Math.round(parseFloat(this.data.amount) / parseFloat(this.stock.latestPrice) * 100) / 100);
    if (this.data.shares == "NaN") {
      this.data.shares = "0";
    }
  }
  public OnShareInputChanged (e : Event){
    if (!this.data.shares.startsWith('0.')) { this.data.shares = this.data.shares.replace(/^0+/, "");}
    this.data.amount = String(parseFloat(this.data.shares) * parseFloat(this.stock.latestPrice));
    if (this.data.amount == "NaN") {
      this.data.amount = "0";
    }
  }


  onNoClick(): void {
    this.dialogRef.close();
  }

  enoughPosition() {
    return parseFloat(this.data.shares) <= parseFloat(this.stock.currentStock()?.userShares??'') && parseFloat(this.data.amount) > 0 ;
  }

  protected readonly Math = Math;
  protected readonly parseFloat = parseFloat;
}

@Component({
  selector: 'success',
  templateUrl: 'success.html',
})
export class SuccessPopup {
  constructor(public dialogRef: MatDialogRef<SuccessPopup>){}
  onNoClick(): void {
    this.dialogRef.close();
  }
}
@Component({
  selector: 'error',
  templateUrl: 'error.html',
})
export class ErrorPopup {
  constructor(public dialogRef: MatDialogRef<SuccessPopup>){}
  onNoClick(): void {
    this.dialogRef.close();
  }
}
