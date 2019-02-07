import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common//http';
import { Observable } from 'rxjs';
const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type': 'application/json',
    }
  )
};
@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor(private http: HttpClient) { }
  url: string = "/newsarticle/authenticate"
  authenticate(user): Observable<any> {
    console.log("inside service");
    return this.http.post(this.url, user, httpOptions);


  }
}
