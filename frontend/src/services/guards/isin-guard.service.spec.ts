import { TestBed } from '@angular/core/testing';

import { IsinGuardService } from './isin-guard.service';

describe('IsinGuardService', () => {
  let service: IsinGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IsinGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
