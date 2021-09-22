import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Country } from '../components/countries/country'
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { CountrySearchModel } from '../components/countries/country-search-model';
import { SortingPaging } from 'src/app/utils/sorting-paging';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private apiurl = environment.apiBaseUrl;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http : HttpClient) { }

  public getCountries() :Observable<Country[]>{
    return this.http.get<Country[]>(this.apiurl + '/countries', this.httpOptions).pipe(
      catchError(this.handleError<Country[]>('getCountries', []))
    );

  }

  public getCountry(id: string) :Observable<any>{
    console.log(id);
    return this.http.get<Country>(this.apiurl + '/countries/' + id);
  }

  public createCountry(country : Country) :Observable<any>{
    return this.http.post<Country>(this.apiurl + '/countries', country);
  }

  public updateCountry(country : Country) :Observable<any>{
    return this.http.put<Country>(this.apiurl + '/countries/' + country.code, country);
  }

  public deleteCountry(countryId : string) :Observable<any>{
    return this.http.delete<void>(this.apiurl + '/countries/' + countryId);
  }

  getCountryPage(sortingPaging: SortingPaging, countrySearchModel: CountrySearchModel): Observable<any> {
    let requestParams = new HttpParams();
    requestParams = requestParams.set("page", sortingPaging.getPageIndex());
    requestParams = requestParams.set("size", sortingPaging.getPageSize());

    const { code, name } = countrySearchModel;

    if (code && code.length !== 0 && code.trim()) {
      requestParams = requestParams.set("code", code);
    }

    if (name && name.length !== 0 && name.trim()) {
      requestParams = requestParams.set("name", name);
    }
    if (sortingPaging.isSortingValid()) {
      requestParams = requestParams.set("sortBy", sortingPaging.getSortBy());
      requestParams = requestParams.set("sortDirection", sortingPaging.getSortDirection());
    }

    return this.http.get<any>("http://localhost:8080/movie-register-ws/countries/paging", {
      params: requestParams
        }).pipe(
        catchError(this.handleError<any>('getCountries', []))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
   


}

