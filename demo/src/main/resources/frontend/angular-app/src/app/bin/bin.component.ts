import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './bin.component.html',
  styleUrls: ['./bin.component.css']
})
export class BinComponent {
  koszyk: any;
  constructor(private router: Router, private http: HttpClient) {
  }

  bin() {
    this.router.navigate(['/bin'], {queryParams: {search: this.koszyk}});

  }
}
