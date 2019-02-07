import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  url: string = "/newsarticle/user/analyst/";
  url1: string = "/newsarticle/user/saveuser/";
  constructor(private http: HttpClient) { }
 
  search(email): Observable<any>{    
    console.log(email);
    return this.http.get<any>(this.url+email);
}
  
status(email): Observable<any>{    
  console.log(email);
  return this.http.get<any>(this.url1+email);
}

}
