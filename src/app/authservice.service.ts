import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  constructor() { }
  status: boolean
  loggedIn: boolean
  role: string;
  email: any;
  id: any;
  article: any;
  languageCode: any;
  data: any;
  getLoggedin() {
    return this.loggedIn;
  }

  setLogin(loggedIn: boolean) {
    console.log("Inside auth service login()");
    this.loggedIn = loggedIn;
  }
getArticle(){
  return this.article
}
setArticle(article:any){
  this.article = article;
}

  getStatus() {
    return this.status
  }
  setStatus(status: boolean) {
    this.status = status
  }


  getId() {
    return this.id;
  }
  setId(id: any) {
    this.id = id;
  }
  getData() {
    return this.data;
  }
  setData(data: any) {
    this.data = data;
  }
  getRole() {
    return this.role;
  }

  setRole(role: string) {
    this.role = role;
  }


  getEmail() {
    return this.email;
  }

  setEmail(email: any) {
    this.email = email;
  }



  getLanguageCode() {
    return this.languageCode;
  }

  setLanguageCode(languageCode: string) {
    this.languageCode = languageCode;
  }
}

