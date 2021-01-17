import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';
import{CalculatorService} from'./../services/calculator.service';

@Component({
  selector: 'app-nameeditor',
  templateUrl: './nameeditor.component.html',
  styleUrls: ['./nameeditor.component.css']
})

export class NameeditorComponent  {
  myform=this.fb.group({
    firstname:[''],
    lastname:[''],
    phonenumber:[''],
    email:[''],
    date:['']
  });
  t=[];  
 
  Submit()
  {
    console.log(this.myform.value);
    this.t.push(this.myform.value)
    sessionStorage.setItem('userRecord',JSON.stringify(this.t));
    
  }
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
   
  }

}
