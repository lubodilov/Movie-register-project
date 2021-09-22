import { Component, OnInit } from '@angular/core';
import { Country } from './components/countries/country';
import { CountryService } from './services/country.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    country : boolean = true;

  ngOnInit(): void {}
  
  changeLang(lang : boolean) : void{
      this.country = lang;
  }


}
