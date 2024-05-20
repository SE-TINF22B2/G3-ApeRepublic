import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PageMainComponent } from './page-main/page-main.component';
import { PageLoginComponent } from './page-login/page-login.component';
import { PageStockComponent } from "./page-stock/page-stock.component";
import { PageSignUpComponent} from './page-sign-up/page-sign-up.component';
import {ServerApiService} from "../services/server-api/server-api.service";

const routes: Routes = [
  {path: 'main', component: PageMainComponent, canActivate: [ServerApiService] },
  {path: 'stock', component: PageStockComponent, canActivate: [ServerApiService] },
  {path: 'login', component: PageLoginComponent, canActivate: [ServerApiService] },
  {path: 'logout', component: PageLoginComponent, canActivate: [ServerApiService] },
  {path: 'signup', component: PageSignUpComponent},

  { path: '',   redirectTo: '/main', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
