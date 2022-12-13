import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  szukajnik: any;
  results: any;


  constructor(private router: Router, private http: HttpClient) {
  }

  //nawiguj do danej strony
  search() {
    this.router.navigate(['/products'], {queryParams: {search: this.szukajnik}});

    //working on this

    // this.http.get('http://localhost:4200/products', {
    //   params: {
    //     query: this.szukajnik
    //   }
    // }).subscribe(response => {
    //   this.results = response;
    //   this.router.navigate(['/products']);
    // });
  }
}
