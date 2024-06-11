import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageStockComponent } from './page-stock.component';

describe('PageStockComponent', () => {
  let component: PageStockComponent;
  let fixture: ComponentFixture<PageStockComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PageStockComponent]
    });
    fixture = TestBed.createComponent(PageStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
