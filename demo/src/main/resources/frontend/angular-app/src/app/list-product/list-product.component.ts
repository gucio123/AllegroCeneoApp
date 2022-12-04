import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductserviceService } from '../productservice.service'

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit{


  public products: Product[] = [];

  public sortBy = [{id: 0, name: null},{id: 1, name: "Cena od najnizszej"}, {id: 2, name: "Cena od najwyzszej"}];
  selectedValue = null;
  constructor(private productService: ProductserviceService) { }

  async ngOnInit() {
    await this.getProducts();
    console.log(this.products);
  }

  public getProducts(): void{
    this.productService.getProducts().subscribe(
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
