import { TestBed, inject } from '@angular/core/testing';

import { NewsBulletinService } from './news-bulletin.service';

describe('NewsBulletinService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NewsBulletinService]
    });
  });

  it('should be created', inject([NewsBulletinService], (service: NewsBulletinService) => {
    expect(service).toBeTruthy();
  }));
});
