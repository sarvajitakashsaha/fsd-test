import { Component, OnInit } from '@angular/core';
import { AuthserviceService } from '../authservice.service';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-favourite-article',
  templateUrl: './favourite-article.component.html',
  styleUrls: ['./favourite-article.component.css']
})
export class FavouriteArticleComponent implements OnInit {

  constructor(private service: AuthserviceService, private newservice: NewsService) { }
  email: any;
  articleList: any;
  ngOnInit() {
    this.email = this.service.getEmail();
    this.newservice.getfavourite(this.email).subscribe(data => {
      this.articleList = data.article;
      console.log(data);
      console.log(data);

    },
      error => {

      });
  }
  delete(article) {
    this.email = this.service.getEmail();
    let json = JSON.stringify({
      email: this.email,
      article: [
        article
      ]
    }
    )
    this.newservice.removeArticle(json).subscribe(data => {
      this.email = this.service.getEmail();
      this.newservice.getfavourite(this.email).subscribe(data => {
        this.articleList = data.article;
        console.log(data);
        console.log(data);

      },
        error => {

        });
    })
  }

}
