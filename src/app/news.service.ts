import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
export class NewsService {

  constructor(private http: HttpClient) { }

  apiKey: string = "ad37b1f0f78f403d826128c4ba3d7b14";
  url: string = "/newsarticle/user/savearticle";
  url1: string = "/newsarticle/user/analyst/";
  url2: string = "/newsarticle/user/removerticle/";
  getNews(languageCode): Observable<any> {
    let newsUrl: string = "https://newsapi.org/v2/top-headlines?language="+languageCode+"&apiKey="+this.apiKey;
     return this.http.get(newsUrl);

  }
searchNews(key):Observable<any>{
  let newsUrl1 : string =  "https://newsapi.org/v2/everything?q="+key+"&apiKey="+this.apiKey;
  return this.http.get(newsUrl1);
}


  saveArticle(json):Observable<any>{
    console.log("testing")
    return this.http.post<any>(this.url,json,httpOptions);

  }
  getfavourite(email):Observable<any> {
    return this.http.get<any>(this.url1+email)
  }
  removeArticle(json):Observable<any>{
    console.log("testing")
    return this.http.post<any>(this.url2,json,httpOptions);

  }
}
