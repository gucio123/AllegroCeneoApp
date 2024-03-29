import {Component, OnInit} from '@angular/core';
import { User } from '../User';
import {UseraccountserviceService} from "../useraccountservice.service";
import {ProductserviceService} from "../productservice.service";
import {Router} from "@angular/router";



@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent implements OnInit{


  user : User = {
    email: "",
    password: ""
  };


  constructor(private userAccountService: UseraccountserviceService, private productService: ProductserviceService, private router: Router){ }
  public createAccount(): void {
    console.log(this.user.email);
    // this.userAccountService.createAccount(this.user);  TO NIE WYSTARCZA NA POSTA
    this.userAccountService // TRZEBA TO ZROBIC TAK, CZYLI DODAC SUBSCRIBE()
      .createAccount(this.user)
      .subscribe()
  }
  ngOnInit(): void {
  }

}
