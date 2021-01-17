import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import {HttpsServiceService} from './../services/https-service.service'
@Component({
  selector: 'app-apicalls',
  templateUrl: './apicalls.component.html',
  styleUrls: ['./apicalls.component.css']
})
export class ApicallsComponent implements OnInit {

  constructor(private _msgService:HttpsServiceService) { }
  products=[];
  ngOnInit(): void {
    this._msgService.product().subscribe(productData=>this.products=productData);
  }

}
