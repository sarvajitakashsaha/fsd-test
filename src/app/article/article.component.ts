import { Component, OnInit } from '@angular/core';
import { NewsService } from '../news.service';
import { AuthserviceService } from '../authservice.service';
import { delay } from 'q';
import { Router } from '@angular/router';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  constructor(public newservice: NewsService, public service: AuthserviceService, public router: Router) { }
  savedArticle: any;
  email: any;
  languageCode: any;
  articleList: any;
  currentArticleTitle:any='';
  articles: any;
  isSaved = false;
  isfavourite = false;
  title: any;
  article1: any
  status: any;
  ngOnInit() {
    this.isSaved = false;
    this.article1 = this.service.getArticle();
    this.languageCode = this.service.getLanguageCode();
    this.email = this.service.getEmail();
    this.status = this.service.getStatus();
    this.newservice.getNews(this.languageCode).subscribe(data => {

      // if(data.user.article.title == data.articles.title ){
      //   this.isfavourite=true;
      // }
      console.log(data)
      this.articleList = data.articles;


      //this.article=data;
    })
  }
  favouriteArticle(article) {
    this.currentArticleTitle=article.title;
    this.email = this.service.getEmail();
    let json = JSON.stringify({
      email: this.email,
      article: [
        article
      ]
    }
    )
    this.newservice.saveArticle(json).subscribe(data => {
      this.isSaved = true;
      this.savedArticle = data;
      console.log("sarvajit")
      console.log(data)
      console.log(article.title)
      this.title = article.title

    })
  }

  get(key) {
    this.newservice.searchNews(key).subscribe(data => {
      this.articleList = data.articles;
    })
  }

}
