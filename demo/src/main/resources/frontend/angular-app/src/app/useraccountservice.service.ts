import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "./User";
import {Observable} from "rxjs";
import {environment} from "../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class UseraccountserviceService {
  // private apiServerUrl = environment.apiBaseUrl;
  // constructor(private http: HttpClient) {}
  //
  // public createAccount(user: User): Observable<User> {
  //   return this.http.post<User>('${this.apiServerUrl}/firebase/add', user);
  // }
}
