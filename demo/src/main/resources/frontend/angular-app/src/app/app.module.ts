import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginRegisterComponent } from './login-register/login-register.component';
import {UseraccountserviceService} from "./useraccountservice.service";
import {HttpClientModule} from "@angular/common/http";
import { ListProductComponent } from './list-product/list-product.component';
import {ProductserviceService} from "./productservice.service";
import {SearchComponent} from "./search/search.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginRegisterComponent,
    ListProductComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UseraccountserviceService, ProductserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
