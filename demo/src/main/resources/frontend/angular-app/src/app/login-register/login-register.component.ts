import {Component, OnInit} from '@angular/core';
import { User } from '../User'
import {UseraccountserviceService} from "../useraccountservice.service";

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

  constructor(public userAccountService: UseraccountserviceService){ }
  public createAccount(): void {
    // this.userAccountService.createAccount(this.user);  TO NIE WYSTARCZA NA POSTA

    if(this.user.email.includes("@") && this.user.password.length >= 6)
    this.userAccountService // TRZEBA TO ZROBIC TAK, CZYLI DODAC SUBSCRIBE()
      .createAccount(this.user)
      .subscribe()
  }

  ngOnInit(): void {
  }
}
