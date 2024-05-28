import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GraphComponent } from './graph/graph.component';
import { BuyPopup } from "./page-stock/page-stock.component";
import { SellPopup } from "./page-stock/page-stock.component";
import { ErrorPopup } from "./page-stock/page-stock.component";
import { SuccessPopup } from "./page-stock/page-stock.component";

import { PageMainComponent } from './page-main/page-main.component';
import { PageStockComponent } from './page-stock/page-stock.component';
import { PageLoginComponent } from './page-login/page-login.component';
import { PageSignUpComponent} from './page-sign-up/page-sign-up.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { TextFieldModule } from '@angular/cdk/text-field';
import { MatTableModule } from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';

import { MatButtonToggleModule } from "@angular/material/button-toggle";
import { MatIconModule } from "@angular/material/icon";
import { MatDatepickerModule } from '@angular/material/datepicker';
import {MatNativeDateModule, MatOptionModule} from '@angular/material/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import {MatTabsModule} from "@angular/material/tabs";
import {MatListModule} from "@angular/material/list";


const MaterialComponents = [MatButtonModule, MatInputModule, MatSlideToggleModule, MatFormFieldModule, TextFieldModule, MatTableModule, MatDialogModule];

@NgModule({
  declarations: [
    AppComponent,
    GraphComponent,
    BuyPopup,
    SellPopup,
    SuccessPopup,
    ErrorPopup,

    PageMainComponent,
    PageLoginComponent,
    PageSignUpComponent,
    PageStockComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    MatDatepickerModule,
    MatNativeDateModule,
    MaterialComponents,
    MatButtonToggleModule,
    MatIconModule,

    ReactiveFormsModule,

    HttpClientModule,
    FormsModule,
    MatTabsModule,
    MatListModule,
    MatOptionModule
  ],
  exports: [MaterialComponents],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }
