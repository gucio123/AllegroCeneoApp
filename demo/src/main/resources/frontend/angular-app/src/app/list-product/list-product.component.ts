import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductserviceService } from '../productservice.service'
import {ActivatedRoute} from "@angular/router";
import {CartList} from "../CartList";


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
  cartList = CartList;
  public products: Product[] = [];
  private _input: string = "";
  currentSortPrice: 'min' | 'max' = 'min';
  currentSortOffert: 'min' | 'max' = 'min';

  toggleSortPrice(): void {
    if (this.currentSortPrice === 'min') {
      this.sortminPrice();
      this.currentSortPrice = 'max';
    } else {
      this.sortmaxPrice();
      this.currentSortPrice = 'min';
    }
  }

  toggleSortOffert(): void {
    if (this.currentSortOffert === 'min') {
      this.sortminOffert();
      this.currentSortOffert = 'max';
    } else {
      this.sortmaxOffert();
      this.currentSortOffert = 'min';
    }
  }
  public sortBy = [{id: 0, name: null},{id: 1, name: "Cena od najnizszej"}, {id: 2, name: "Cena od najwyzszej"}];
  selectedValue = null;


  constructor(private productService: ProductserviceService, private activatedRoute: ActivatedRoute ) {  this.activatedRoute.queryParams.subscribe(params => {
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

  sortminPrice() {
    this.products.sort((a,b) => {
      let priceA = parseFloat(a.price.replace(',', ''));
      let priceB = parseFloat(b.price.replace(',', ''));
      if(priceA > priceB) return 1;
      else
        return -1;}
    );
  }

  sortmaxPrice() {
    this.products.sort((a,b) => {
      let priceA = parseFloat(a.price.replace(',', ''));
      let priceB = parseFloat(b.price.replace(',', ''));
      if(priceA < priceB) return 1;
      else
        return -1;}
    );
  }
  sortminOffert() {
    this.products.sort((a,b) => {
      let priceA = parseFloat(a.productOffert.replace(',', ''));
      let priceB = parseFloat(b.productOffert.replace(',', ''));
      if(priceA > priceB) return 1;
      else
        return -1;}
    );
  }

  sortmaxOffert() {
    this.products.sort((a,b) => {
      let priceA = parseFloat(a.productOffert.replace(',', ''));
      let priceB = parseFloat(b.productOffert.replace(',', ''));
      if(priceA < priceB) return 1;
      else
        return -1;}
    );
  }
  addProductToCart(product : Product){
    this.cartList.push(product);
  };


  // onOptionsSelected(value: string) {
  //   if(value == null)
  //     return;
  // if(value == "Cena od najnizszej")
  //   this.sortminPrice();
  // else if(value == "Cena od najwyzszej")
  //   this.sortmaxPrice();
  // }
}
