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


  constructor(private router: Router, private http: HttpClient) {}

  search() {
    this.router.navigate(['/products'], {queryParams: {search: this.szukajnik}});
  }
}
