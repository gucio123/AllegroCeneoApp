import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-search',
  templateUrl:'./search.component.html',
  styleUrls: ['./search.component.css']
// <!--    <label for="search">Search:</label>-->
// <!--    <input id="search" [(ngModel)]="searchTerm" type="text" placeholder="Enter search term">-->
// <!--    <button (click)="search()">Search</button>-->

})
export class SearchComponent{
  szukajnik: any;


  constructor(private router: Router) {}

  search() {
    // nawiguj do danej strony
    this.router.navigate(['/products'], { queryParams: { search: this.szukajnik } });
  }
}
