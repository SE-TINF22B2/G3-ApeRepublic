import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageMainComponent } from './page-main.component';

describe('MainComponent', () => {
  let component: PageMainComponent;
  let fixture: ComponentFixture<PageMainComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PageMainComponent]
    });
    fixture = TestBed.createComponent(PageMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
