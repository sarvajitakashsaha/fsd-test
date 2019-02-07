import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { ArticleComponent } from './article/article.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignupComponent } from './signup/signup.component';
import { SearchComponent } from './search/search.component';
import { FavouriteArticleComponent } from './favourite-article/favourite-article.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { APP_BASE_HREF } from '@angular/common';
import { Routes } from '@angular/router';

fdescribe('AppComponent', () => {
  const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    /* {path:"",component:LoginComponent}, */
    {path:"analyst",component:ArticleComponent},
    {path:"login",component:LoginComponent},
    {path:"signup",component:SignupComponent},
    {path:"article",component:ArticleComponent},
    {path:"search",component:SearchComponent},
    {path:"favourite",component:FavouriteArticleComponent}
  ];
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        ArticleComponent,
        LoginComponent,
        NavbarComponent,
        SignupComponent,
        SearchComponent,
        FavouriteArticleComponent
      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule    
      ],
      providers: [{provide: APP_BASE_HREF, useValue : '/' }],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'ui'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('ui');
  });

/*   it('should render title in a h1 tag', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to ui!');
  }); */
});
