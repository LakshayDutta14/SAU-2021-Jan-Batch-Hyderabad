import { Component } from '@angular/core';
import { CalculatorService } from './services/calculator.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private calc:CalculatorService)
  {

  }
  title = 'calc';
  result:number=0;
  firstnumber:number=0;
  secondnumber:number=0;
  addition(){
    this.result=this.calc.add(this.firstnumber,this.secondnumber);
  }
  
  subtraction()
  {
    this.result= this.calc.subtract(this.firstnumber,this.secondnumber);
  }
}
