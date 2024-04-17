import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GraphComponent } from './graph/graph.component';
import { PageMainComponent } from './page-main/page-main.component';
import { PageLoginComponent } from './page-login/page-login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { TextFieldModule } from '@angular/cdk/text-field';
import { MatTableModule } from '@angular/material/table';
import { PageStockComponent } from './page-stock/page-stock.component';
import { MatButtonToggleModule } from "@angular/material/button-toggle";
import { MatIconModule } from "@angular/material/icon";

const MaterialComponents = [MatButtonModule, MatInputModule, MatSlideToggleModule, MatFormFieldModule, TextFieldModule, MatTableModule];

@NgModule({
  declarations: [
    AppComponent,
    GraphComponent,
    PageMainComponent,
    PageLoginComponent,
    PageStockComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    MaterialComponents,
    MatButtonToggleModule,
    MatIconModule,
  ],
  exports: [MaterialComponents],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
