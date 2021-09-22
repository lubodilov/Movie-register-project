import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountrySearchbarComponent } from './country-searchbar.component';

describe('CountrySearchbarComponent', () => {
  let component: CountrySearchbarComponent;
  let fixture: ComponentFixture<CountrySearchbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CountrySearchbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CountrySearchbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
