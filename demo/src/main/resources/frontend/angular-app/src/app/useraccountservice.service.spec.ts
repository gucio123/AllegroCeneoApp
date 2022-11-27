import { TestBed } from '@angular/core/testing';

import { UseraccountserviceService } from './useraccountservice.service';

describe('UseraccountserviceService', () => {
  let service: UseraccountserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UseraccountserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
