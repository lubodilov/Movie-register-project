import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CountrySearchModel } from 'src/app/components/countries/country-search-model';

@Component({
  selector: 'app-country-searchbar',
  templateUrl: './country-searchbar.component.html',
  styleUrls: ['./country-searchbar.component.css']
})
export class CountrySearchbarComponent implements OnInit {
  @Input() countrySearchModel!: CountrySearchModel;

  @Output() searchForMe: EventEmitter<CountrySearchModel> = new EventEmitter();
  @Output() clearForMe: EventEmitter<void> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  search(){
    this.searchForMe.emit(this.countrySearchModel);
  }

  clear(){
    this.clearForMe.emit();
  }

}
