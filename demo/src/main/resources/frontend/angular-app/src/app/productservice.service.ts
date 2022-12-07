import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {


  constructor( private http: HttpClient) { }


  public getProducts(): Observable<Product[]> {
    return this.http.post<Product[]>('http://localhost:8080/api/getproducts', "LEGO Star Wars 75257 Sokół Millennium,mydło w płynie");
  }
}
