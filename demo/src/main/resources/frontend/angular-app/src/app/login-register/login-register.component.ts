import {Component, OnInit} from '@angular/core';
import { User } from '../User'

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
  constructor() { }

  ngOnInit(): void {
  }
}
