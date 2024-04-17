import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageMainComponent } from './page-main/page-main.component';
import { PageLoginComponent } from './page-login/page-login.component';
import { PageStockComponent } from "./page-stock/page-stock.component";

const routes: Routes = [
  {path: 'main', component: PageMainComponent},
  {path: 'login', component: PageLoginComponent},
  {path: 'stock', component: PageStockComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
