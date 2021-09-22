import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountryDetatilsComponent } from './country-detatils.component';

describe('CountryDetatilsComponent', () => {
  let component: CountryDetatilsComponent;
  let fixture: ComponentFixture<CountryDetatilsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CountryDetatilsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CountryDetatilsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
