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
export class SignupService {

  url: string = "/newsarticle/user/save";           
  constructor(private http: HttpClient) { }  
  save(user):Observable<any>{
    console.log("testing")
    return this.http.post<any>(this.url,user,httpOptions);
  }
}
