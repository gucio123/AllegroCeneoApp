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

  fileContent: string | ArrayBuffer | null = '';

  public onChange(fileList: FileList): void {
    let file = fileList[0];
    let fileReader: FileReader = new FileReader();
    let self = this;
    fileReader.onloadend = function (x) {
      self.fileContent = fileReader.result;
    }
    fileReader.readAsText(file);
  }

  //nawiguj do danej strony
  condition: any;
  search() {
    this.router.navigate(['/products'], {queryParams: {search: this.szukajnik}});

  }
}
