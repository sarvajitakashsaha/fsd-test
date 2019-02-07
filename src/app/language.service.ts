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
export class LanguageService {

  url: string = "/newsarticle/language";           
  constructor(private http: HttpClient) { }  
  getLanguages():Observable<any>{
    console.log("testing")
    return this.http.get<any>(this.url);
  }
}
