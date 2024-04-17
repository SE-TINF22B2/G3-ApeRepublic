import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageLoginComponent } from './page-login.component';

describe('LoginComponent', () => {
  let component: PageLoginComponent;
  let fixture: ComponentFixture<PageLoginComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PageLoginComponent]
    });
    fixture = TestBed.createComponent(PageLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
