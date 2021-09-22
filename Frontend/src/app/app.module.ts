import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { CountriesComponent } from './components/countries/countries.component';
import { CountryService } from './services/country.service';
import { CountryDetatilsComponent } from './details/country-detatils/country-detatils.component';
import { PagingComponent } from './default/paging/paging.component';
import { CountrySearchbarComponent } from './default/country-searchbar/country-searchbar.component';
import { HeadingComponent } from './default/heading/heading.component';

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/languages/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    CountriesComponent,
    CountryDetatilsComponent,
    PagingComponent,
    CountrySearchbarComponent,
    HeadingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    TranslateModule.forRoot({
      loader: {
          provide: TranslateLoader,
          useFactory: (createTranslateLoader),
          deps: [HttpClient],
      },
      defaultLanguage: 'bg'
  })

  ],
  providers: [CountryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
