import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})


export class SearchComponent implements OnInit {

  constructor(private analyst:SearchService, private router: Router) { }
newsAnalyst:any;
isUser=false;


  ngOnInit() {
  }
  get(email){
    this.analyst.search(email).subscribe(
      data => {
        if(data!=null){
         this.isUser=true;
          this.newsAnalyst=data;
        }
 
    
        console.log(this.newsAnalyst)
      }
    );
  }
  changeStatus(email){
    this.analyst.status(email).subscribe(
      data=>{
        this.newsAnalyst=data;
      }
    )

  }
}
