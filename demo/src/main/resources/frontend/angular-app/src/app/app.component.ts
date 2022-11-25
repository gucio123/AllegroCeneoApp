import { Component, OnInit } from '@angular/core';
import {Object} from '../object';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  object: Object ={
  id: 1,
  name: 'Aspiryna'
  };

  constructor() { }

  ngOnInit():void{
  }
}
