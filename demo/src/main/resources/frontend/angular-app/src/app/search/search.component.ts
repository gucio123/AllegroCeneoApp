import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from "@angular/common/http";
import {CartList} from "../CartList";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent {

  cartList = CartList;
  public sidebarShow: boolean = false;
  szukajnik: any;
  results: any;

  constructor(private router: Router, private http: HttpClient) {
  }

  public onChange(fileList: Event): void {
    // @ts-ignore
    let file = (<HTMLInputElement>fileList.target).files[0];
    let fileReader: FileReader = new FileReader();
    let self = this;
    fileReader.onloadend = function(x) {
      self.szukajnik = fileReader.result;
      self.search();
    }
    fileReader.readAsText(file);
  }
  condition: any;
  search() {
    this.router.navigate(['/products'], {queryParams: {search: this.szukajnik}});
  }
  refresh(){
    this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/products'], {queryParams: {search: this.szukajnik}});
    });
  }
}
