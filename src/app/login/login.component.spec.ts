import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { BrowserModule, By } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { LoginService } from '../login.service';
import { DebugElement } from '@angular/core';
import { of } from 'rxjs';
import { AuthserviceService } from '../authservice.service';
import { APP_BASE_HREF } from '@angular/common';
import { ArticleComponent } from '../article/article.component';
import { AppRoutingModule } from '../app-routing.module';
import { FavouriteArticleComponent } from '../favourite-article/favourite-article.component';
import { SearchComponent } from '../search/search.component';
import { SignupComponent } from '../signup/signup.component';
import { Routes } from '@angular/router';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"analyst",component:ArticleComponent},
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"article",component:ArticleComponent},
  {path:"search",component:SearchComponent},
  {path:"favourite",component:FavouriteArticleComponent}
];
fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de : DebugElement;
  let el : HTMLElement;
  let service:LoginService;
  let authservice : AuthserviceService;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent, ArticleComponent, SignupComponent, FavouriteArticleComponent, SearchComponent ],
      imports : [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule,
        AppRoutingModule
  ],
  providers : [
     LoginService 
  ]
    })
    .compileComponents().then(() =>{
      fixture = TestBed.createComponent(LoginComponent);
      component = fixture.componentInstance;

      de = fixture.debugElement.query(By.css('form'));
      el = de.nativeElement;

    });
  }));


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should valid when field is not empty',async(()=> {
    //accessing controls
    component.form.controls['email'].setValue('sarvajit1gmail.com');
    component.form.controls['password'].setValue('saha');
    expect(component.form.valid).toBeTruthy();
  }));

  it('form should invalid when empty',async(()=> {
    //accessing controls
    component.form.controls['email'].setValue('');
    component.form.controls['password'].setValue('');
    expect(component.form.valid).toBeFalsy();
  }));


  it('should call the authenticate method', async(()=> {
    fixture.detectChanges();
    spyOn(component, 'authenticate');
    el =fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.authenticate).toHaveBeenCalledTimes(1);
  }));


it('should calll the authenticate method of login service',async(()=>{

service = fixture.debugElement.injector.get(LoginService);
authservice = fixture.debugElement.injector.get(AuthserviceService)
let data : any = JSON.parse(JSON.stringify({
  authenticated : true,
  user : {
    id : 1,
     email : "saha",
    language :{
      code:"en"
    },
    role : {
      name : "admin"
    }
  }
}))
spyOn(service,'authenticate').and.returnValue(of(data));
component.authenticate();
let email= authservice.getEmail();
//expect(authservice.getEmail()).toBe("saha")
expect(authservice.email).toBe("saha")
expect(service.authenticate).toHaveBeenCalled();

}))



});
