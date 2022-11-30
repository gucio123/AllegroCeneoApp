import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "./User";
import {Observable} from "rxjs";
import {environment} from "../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class UseraccountserviceService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}
  headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8'); // trzeba to dołączać do posta, bo spring nie zaakceptuje
  public createAccount(user: User) : Observable<User>{
    return this.http.post<User>('http://localhost:8080/firebase/add',
      JSON.stringify(user), {headers : this.headers});
  }
}
