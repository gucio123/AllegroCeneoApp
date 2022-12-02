import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/core';
import { Observable } from 'rxjs';
import {enviroment} from './enviroment';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  private userUrl = enviroment.apiBaseUrl;

  constructor( private http: HttpClient) { }

  public getProducts(): Observable<any> {
    return this.htttp.get<any>('${this.userUrl}/api/getproducts');
}
