import { Component } from '@angular/core';
import {UseraccountserviceService} from "./useraccountservice.service";
import {ProductserviceService} from "./productservice.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';

  constructor(private router: Router){}

  getFromFile() {
    this.router.navigateByUrl('/products');
  }
  goToLoginRegister() {
    this.router.navigateByUrl('/loginRegister');
  }

}
