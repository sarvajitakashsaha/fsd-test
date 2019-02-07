import { Component, OnInit } from '@angular/core';
import { AuthserviceService } from '../authservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(public service : AuthserviceService,public router: Router) { }
  loggedIn:boolean;
  ngOnInit() {
    this.loggedIn=this.service.getLoggedin();
    console.log('loggedIn'+this.loggedIn)
  }
  logout(){
    this.router.navigate(['/login']);
  }
  favouriteArticle(){
    this.router.navigate(['/favourite']);
  }

}
