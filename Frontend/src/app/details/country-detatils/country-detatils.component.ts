import { Component, Input, OnInit } from '@angular/core';
import { Country } from 'src/app/components/countries/country';
import { CountryService } from 'src/app/services/country.service';

@Component({
  selector: 'app-country-detatils',
  templateUrl: './country-detatils.component.html',
  styleUrls: ['./country-detatils.component.css']
})
export class CountryDetatilsComponent implements OnInit {

  @Input() countryOperation!: string;
  @Input() country!: Country;

  codeErrorMessage!: string;
  nameErrorMessage!: string;
  codeEmptyMessage!: string;
  nameEmptyMessage!: string;
  submitted!: boolean;

  constructor(private countryService: CountryService) {
    this.codeErrorMessage = "";
    this.nameErrorMessage = "";
    this.codeEmptyMessage = "";
    this.nameEmptyMessage = "";
   }

  ngOnInit(): void {
    console.log(this.countryOperation);
  }

  save() {
    this.submitted = true;
    const data = {
       code: this.country.code,
       name: this.country.name,
    };
    
     this.countryService.createCountry(this.country)
     .subscribe(data => console.log(data), error => console.log(error));
  }

  update() {
    this.submitted = true;
    const data = {
       code: this.country.code,
       name: this.country.name,
  };
  this.countryService.updateCountry(this.country)
  .subscribe(data=>console.log(data), error => console.log(error));
}

validateSave() {
  this.codeErrorMessage = "";
  this.nameErrorMessage = "";
  this.nameEmptyMessage = "";
  this.codeEmptyMessage = "";
  let hasError = false;

  if(!this.isValidParam(this.country.code)){
    this.codeEmptyMessage = "Code cannot be empty!";
    hasError = true;
  }

  if(!this.isValidParam(this.country.name)){
    this.nameEmptyMessage = "Name cannot be empty!";
    hasError = true;
  }

  if(this.country.code.length > 8){
    this.codeErrorMessage = "Length cannot be greater than 8 characters!";
    hasError = true;
  }

  if(this.country.name.length > 128){
    this.nameErrorMessage = "Length cannot be greater than 128 characters!";
    hasError = true;
  }
  if(!hasError && this.countryOperation == 'save'){
    this.save();
  }else if(!hasError && this.countryOperation == 'update'){
    this.update();
  }
}

private isValidParam(value: string): boolean {
  if (value && value.length !== 0 && value.trim()) {
    return true;
  }
  return false;
}


}
