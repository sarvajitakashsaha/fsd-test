import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupComponent } from './signup.component';
import { BrowserModule, By } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
// import { RouterTestingModule } from '@angular/router/testing';
import { SignupService } from '../signup.service';
import { DebugElement } from '@angular/core';
import { of } from 'rxjs';
import { AppComponent } from '../app.component';
import { ArticleComponent } from '../article/article.component';
import { LoginComponent } from '../login/login.component';
import { NavbarComponent } from '../navbar/navbar.component';
import { SearchComponent } from '../search/search.component';
import { FavouriteArticleComponent } from '../favourite-article/favourite-article.component';
import { APP_BASE_HREF } from '@angular/common';
import { LanguageService } from '../language.service';

fdescribe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;
  let de: DebugElement;
  let el: HTMLElement;
  let service: SignupService;
  let language :LanguageService
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ArticleComponent,
        LoginComponent,
        NavbarComponent,
        SignupComponent,
        SearchComponent,
        FavouriteArticleComponent],
      imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        // RouterTestingModule
      ],
      providers: [{provide: APP_BASE_HREF, useValue : '/' },
         SignupService ,
         LanguageService
      ]
    }).compileComponents();
      // .compileComponents().then(() => {
      //   fixture = TestBed.createComponent(SignupComponent);
      //   component = fixture.componentInstance;

      //   de = fixture.debugElement.query(By.css('form'));
      //   el = de.nativeElement;

      // });
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    de = fixture.debugElement.query(By.css('form'));
    el = de.nativeElement;

    
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should be called signup method', async () => {
    service = fixture.debugElement.injector.get(SignupService)
    let data: any = JSON.parse(JSON.stringify({
     signupStatus: true
    }))
    spyOn(service, 'save').and.returnValue(of(data));
    component.save();
    //expect(component.save).toHaveBeenCalledTimes(0);
    expect(component.issignedup).toBe(true);
  })
  
  it('should get language when getLanguage method', async()=>{
  language = fixture.debugElement.injector.get(LanguageService);
  let data:any = JSON.parse(JSON.stringify(
  [{
  code:"en",
  name:"english"
  }]
  ))
  spyOn(language , 'getLanguages').and.returnValue(of(data));
  component.ngOnInit();
  expect(component.languageList[0].code).toBe('en')
  }) 
   
  


});
