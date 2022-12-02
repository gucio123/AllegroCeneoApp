import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import {environment} from "../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  constructor( private http: HttpClient) { }

  public getProducts(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/getproducts');
}
}
