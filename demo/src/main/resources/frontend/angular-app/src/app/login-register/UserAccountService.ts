import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable({providedIn: 'root'})

export class UserAccountService {
  private apiServerUrl = '';
  constructor(private http: HttpClient) {}

  // public createAccount(): Observable<any> {
  //   return this.http.post<any>('${this.apiServerUrl}', user.ema);
  // }
}
