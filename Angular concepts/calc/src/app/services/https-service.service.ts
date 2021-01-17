import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpsServiceService {

  constructor(private http:HttpClient) { }
  product():Observable<any>{
    return(this.http.get('http://jsonplaceholder.typicode.com/users'));
  }
}
