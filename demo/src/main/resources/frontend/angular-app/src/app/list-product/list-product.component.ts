import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductserviceService } from '../productservice.service'
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit{
  // set input(value: string) {
  //   this._input = value;
  // }
  //
  // get input(): string | null{
  //   return this._input;
  // }

  public products: Product[] = [];
  private _input: string = "";
  public sortBy = [{id: 0, name: null},{id: 1, name: "Cena od najnizszej"}, {id: 2, name: "Cena od najwyzszej"}];
  selectedValue = null;
  constructor(private productService: ProductserviceService, private activatedRoute: ActivatedRoute) {  this.activatedRoute.queryParams.subscribe(params => {
    this._input = params['search'];
    console.log(this._input); // Print the parameter to the console.
  }); }

  async ngOnInit() {
    // this._input = <string>this.activatedRoute.snapshot.paramMap.get('search');
    console.log(this._input);
    await this.getProducts();
  }

  public getProducts(): void{
    this.productService.getProducts(this._input).subscribe(
      (response: Product[]) => {
        this.products = response;
        })
    }

  sortmin() {
    this.products.sort((a,b) => {
      if(parseFloat(a.price) > parseFloat(b.price)) return 1;
      else
        return -1;}
    );
  }

  sortmax() {
    this.products.sort((a,b) => {
      if(parseFloat(a.price) < parseFloat(b.price)) return 1;
      else
        return -1;}
    );
  }


  onOptionsSelected(value: string) {
    if(value == null)
      return;
  if(value == "Cena od najnizszej")
    this.sortmin();
  else if(value == "Cena od najwyzszej")
    this.sortmax();
  }
}
