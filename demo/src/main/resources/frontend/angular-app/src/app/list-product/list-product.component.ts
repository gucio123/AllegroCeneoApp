import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductserviceService } from './productService.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit{

  product: Product[]{
  };

  constructor(private productService: ProductserviceService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  public getProducts(): void{
    this.productService.getProducts().subscribe(
      (response: Product[]) => {
        this.products = response;
        })
    }
}
