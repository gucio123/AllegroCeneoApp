import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListProductComponent} from "./list-product/list-product.component";
import {LoginRegisterComponent} from "./login-register/login-register.component";

const routes: Routes = [
  {path: 'products', component: ListProductComponent},
  {path: 'register', component: LoginRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
