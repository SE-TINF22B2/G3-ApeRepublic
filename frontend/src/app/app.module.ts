import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GraphComponent } from './graph/graph.component';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';
import { PageSignUpComponent} from './page-sign-up/page-sign-up.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { TextFieldModule } from '@angular/cdk/text-field';
import { MatTableModule } from '@angular/material/table';




const MaterialComponents = [MatButtonModule, MatInputModule, MatSlideToggleModule, MatFormFieldModule, TextFieldModule, MatTableModule];

@NgModule({
  declarations: [
    AppComponent,
    GraphComponent,
    MainComponent,
    LoginComponent,
    PageSignUpComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    MaterialComponents
  ],
  exports: [MaterialComponents],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
