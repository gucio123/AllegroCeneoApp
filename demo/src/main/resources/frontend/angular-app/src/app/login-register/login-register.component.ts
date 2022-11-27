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
  constructor(private userAccountService: UseraccountserviceService){ }

  // public createAccount(): void {
  //   this.userAccountService.createAccount(this.user);
  // }

  ngOnInit(): void {
  }
}
