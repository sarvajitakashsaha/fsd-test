import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FavouriteArticleComponent } from './favourite-article.component';

describe('FavouriteArticleComponent', () => {
  let component: FavouriteArticleComponent;
  let fixture: ComponentFixture<FavouriteArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FavouriteArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavouriteArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
