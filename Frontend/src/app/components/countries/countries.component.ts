import { Component, OnInit } from '@angular/core';
import { Country } from './country';
import { CountryService } from 'src/app/services/country.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { SortingPaging } from 'src/app/utils/sorting-paging';
import { CountrySearchModel } from './country-search-model';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit {

  country = {
    code: '',
    name: ''
  };
  isClicked!: boolean;
  isClickedU!: boolean;
  isClickedS!: boolean;
  sortingPaging!: SortingPaging;
  countries!: Country[];
  countryName!: string;
  sortAsc?: boolean;
  countryOperation!: string;
  pagesCount!: number;
  isPrevBtnDisabled?: boolean;
  isNextBtnDisabled?: boolean;
  paramsInvalid?: boolean;
  countrySearchModel!: CountrySearchModel;

  constructor(private countryService: CountryService, private route: ActivatedRoute, private router: Router) {
    this.isClicked = false;
    this.isClickedU = false;
    this.isClickedS = false;
    this.countryName = "";
    this.countryOperation = "update";
    this.countries = [];
    this.sortingPaging = new SortingPaging();
    this.sortAsc = true;
    this.sortingPaging.setSortBy('code');
    this.countrySearchModel = { code: "", name: "" };
  }

  ngOnInit(): void {
    this.route
      .queryParams
      .subscribe(params => {
        this.validatePageParams(params);
        this.getCountries();
      }); 
  }


  public getCountries(): void{
    this.countryService.getCountryPage(this.sortingPaging, this.countrySearchModel)
    .subscribe(response => {
       this.countries = response.content;

       this.pagesCount = parseInt((response.totalElements / response.pageSize).toString());
       this.pagesCount = response.totalElements % response.pageSize != 0 ? 
                         this.pagesCount + 1: this.pagesCount;

                         const currentPage = this.sortingPaging.pageIndex || 1;

                         if (currentPage > this.pagesCount || this.paramsInvalid){
                           this.sortingPaging.pageIndex = 1;
                           this.isNextBtnDisabled =  true;
                           this.isPrevBtnDisabled = true;
                           this.changeRoute();
                         }

                         else {
                           this.isNextBtnDisabled =  currentPage === this.pagesCount;
                           this.isPrevBtnDisabled = currentPage === 1;
                         }
    });

  }

public pageIndexChanged(direction: string){
  const currentPage = this.sortingPaging.pageIndex || 1;
  const pageIndex = direction === 'prev' ? currentPage - 1 : currentPage + 1;

  this.sortingPaging.pageIndex = pageIndex;
  this.changeRoute();
}

pageSizeChanged(event: any){
  const pageSize = event.target.outerText;
  this.sortingPaging.pageSize = pageSize;
  this.sortingPaging.pageIndex = 1;
  this.changeRoute();
}

clickUpdate(event:any){
  if(this.isClickedU == true) {
    this.isClickedU = !this.isClickedU;
    if(!this.isClickedU && !this.isClickedS) {
      this.isClicked = false;
    }
    return;
  }
  console.log("asdsadasd");
  this.isClickedU = true;
  this.isClickedS = false;
  if(this.isClickedU || this.isClickedS) {
    this.isClicked = true;
  }
  this.countryOperation="update"; 
  const tableData = event.currentTarget.closest('tr').children;
  console.log(tableData[0].innerText);
  const countryCode = tableData[0].innerText;
  const countryName = tableData[1].innerText;

  this.country.code = countryCode;
  this.country.name = countryName;
}

clickSave(){
  if(this.isClickedS == true) {
    this.isClickedS = !this.isClickedS;
    if(!this.isClickedU && !this.isClickedS) {
      this.isClicked = false;
    }
    return;
  }
  console.log("saveeeee");
  this.isClickedS = true;
  this.isClickedU = false;
  if(this.isClickedU || this.isClickedS) {
    this.isClicked = true;
  }
  this.countryOperation="save"; 
  this.country.code = "";
  this.country.name = "";
  
 }
 
 clickDelete()
 {
   //delete
 }
 search() {
   this.sortingPaging.pageIndex = 1;
   this.changeRoute();
 }

 clear(){
   this.sortingPaging.pageIndex = 1;
   this.sortingPaging.setSortBy('code');
   this.sortingPaging.setSortDirection("asc");
   this.sortAsc = true;
   this.countrySearchModel.code = '';
   this.countrySearchModel.name = '';
   this.changeRoute();
 }

 sort(sort: string) {
  this.sortingPaging.pageIndex = 1;

  if (this.sortingPaging.getSortBy() === sort){
    this.sortAsc = !this.sortAsc;
  }

  else {
    this.sortingPaging.setSortBy(sort);
    this.sortAsc = true;
  }

  this.sortingPaging.setSortDirection(this.sortAsc ? "asc" : "desc");
  this.changeRoute();
  this.getCountries();
}

private validatePageParams(params: { [x: string]: any; }) {
  this.paramsInvalid = false;

  if (!params['size'] || isNaN(params['size']) || +params['size'] < 5 || +params['size'] > 50) {
    this.sortingPaging.pageSize = 5;
    this.paramsInvalid = true;
  } else {
    this.sortingPaging.pageSize = +params['size'];
  }

  if (!params['page'] || isNaN(params['page']) || +params['page'] < 1 || +params['page'] > this.pagesCount) {
    this.sortingPaging.pageIndex = 1;
    this.paramsInvalid = true;
  } else {
    this.sortingPaging.pageIndex = +params['page'];
  }

  if (this.isValidParam(params['code'])){
    this.countrySearchModel.code = params['code'];
  }

  if (this.isValidParam(params['name'])){
    this.countrySearchModel.name = params['name'];
  }
}

private isValidParam(value: string): boolean {
  if (value && value.length !== 0 && value.trim()) {
    return true;
  }
  return false;
}

private changeRoute(){

  const { code, name } = this.countrySearchModel;

  this.router.navigate(['/countries'], { queryParams: 
    { page: this.sortingPaging.pageIndex,
      size: this.sortingPaging.pageSize,
      code: this.isValidParam(code) ? code : null,
      name: this.isValidParam(name) ? name : null 
    },
      queryParamsHandling: 'merge'
    });
}


}
