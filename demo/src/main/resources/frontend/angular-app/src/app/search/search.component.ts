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

  fileContent: string | ArrayBuffer | null = '';

  public onChange(fileList: FileList): void {
    let file = fileList[0];
    let fileReader: FileReader = new FileReader();
    let self = this;
    fileReader.readAsText(file);

    fileReader.onloadend = function(x) {
      self.szukajnik = fileReader.result;
      console.log(self.szukajnik);
    }}


  // fileContent: string = '';
  //
  // handleFileInput(files: FileList) {
  //   let fileToUpload = files.item(0);
  //   let fileReader: FileReader = new FileReader();
  //   if(fileToUpload != null){
  //     // @ts-ignore
  //     fileReader.readAsText(fileToUpload, "UTF-8");
  //     // fileReader.onloadend = function(x) {
  //     // console.log(fileReader.);
  //     fileReader.onloadend = function (x){
  //       console.log(fileReader.result);
  //     }
  //   // }
  // }}

  // searchFromFile() {
  //   if(this.fileToUpload != null){
  //
  //   }
  // }
}
