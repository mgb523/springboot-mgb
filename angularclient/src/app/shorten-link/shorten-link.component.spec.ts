import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShortenLinkComponent } from './shorten-link.component';

describe('UserListComponent', () => {
  let component: ShortenLinkComponent;
  let fixture: ComponentFixture<ShortenLinkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShortenLinkComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShortenLinkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
