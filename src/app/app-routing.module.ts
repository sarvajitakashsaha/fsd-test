import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArticleComponent } from './article/article.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SearchComponent } from './search/search.component';
import { FavouriteArticleComponent } from './favourite-article/favourite-article.component';
import { APP_BASE_HREF } from '@angular/common';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"analyst",component:ArticleComponent},
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"article",component:ArticleComponent},
  {path:"search",component:SearchComponent},
  {path:"favourite",component:FavouriteArticleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    { provide: APP_BASE_HREF, useValue: '/' }
  ]
})
export class AppRoutingModule { }
