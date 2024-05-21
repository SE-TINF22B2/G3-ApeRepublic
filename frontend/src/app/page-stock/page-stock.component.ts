import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {StockInfoService} from "../../services/stockInfo/stock-info.service";
import {AuthService} from "../../services/auth/auth.service";
import {ServerApiService} from "../../services/server-api/server-api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-page-stock',
  templateUrl: './page-stock.component.html',
  styleUrls: ['./page-stock.component.scss']
})
export class PageStockComponent {

  constructor(public dialog: MatDialog, public stock: StockInfoService, public user: AuthService, private serverApi: ServerApiService, private router : Router) {}

  openBuyDialog(): void {
    const dialogRef = this.dialog.open(BuyPopup, {
      width: '30%',
      data: {name: this.stock.currentStock()?.name, price: this.stock.currentStock()?.ticker, capital: "400$"}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (this.serverApi.buyStock(this.stock.currentStock()?.ticker, result)) {
          this.openSuccessDialog();
        } else {
          this.openErrorDialog();
        }
      }
    });
  }

  openSellDialog(): void {
    const dialogRef = this.dialog.open(SellPopup, {
      width: '30%',
      data: {name: this.stock.currentStock()?.name, price: this.stock.currentStock()?.shareOutstanding, position: "600$"}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (this.serverApi.sellStock(this.stock.currentStock()?.ticker, result)) {
          this.openSuccessDialog();
        } else {
          this.openErrorDialog();
        }
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
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
      this.data.shares = "0";
      this.data.amount = "0";
  }

  public OnAmountInputChanged (e : Event){
    this.data.amount = this.data.amount.replace(/^0+/, "");
    this.data.shares = String(Math.round(parseFloat(this.data.amount) / parseFloat(this.data.price) * 100) / 100);
    if (this.data.shares == "NaN") {
     this.data.shares = "0";
    }
  }
  public OnShareInputChanged (e : Event){
    if (!this.data.shares.startsWith('0.')) { this.data.shares = this.data.shares.replace(/^0+/, "");}
    this.data.amount = String(parseFloat(this.data.shares) * parseFloat(this.data.price));
    if (this.data.amount == "NaN") {
      this.data.amount = "0";
    }
  }


  onNoClick(): void {
    this.dialogRef.close();
  }

  enoughCapital() {
    return parseFloat(this.data.amount) <= parseFloat(this.data.capital) && parseFloat(this.data.amount) > 0 ;
  }
}

@Component({
  selector: 'sell',
  templateUrl: 'sell.html',
})
export class SellPopup {

  constructor(
    public dialogRef: MatDialogRef<BuyPopup>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
    this.data.shares = "0";
    this.data.amount = "0";
  }

  public OnAmountInputChanged (e : Event){
    this.data.amount = this.data.amount.replace(/^0+/, "");
    this.data.shares = String(Math.round(parseFloat(this.data.amount) / parseFloat(this.data.price) * 100) / 100);
    if (this.data.shares == "NaN") {
      this.data.shares = "0";
    }
  }
  public OnShareInputChanged (e : Event){
    if (!this.data.shares.startsWith('0.')) { this.data.shares = this.data.shares.replace(/^0+/, "");}
    this.data.amount = String(parseFloat(this.data.shares) * parseFloat(this.data.price));
    if (this.data.amount == "NaN") {
      this.data.amount = "0";
    }
  }


  onNoClick(): void {
    this.dialogRef.close();
  }

  enoughPosition() {
    return parseFloat(this.data.amount) <= parseFloat(this.data.position) && parseFloat(this.data.amount) > 0 ;
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
