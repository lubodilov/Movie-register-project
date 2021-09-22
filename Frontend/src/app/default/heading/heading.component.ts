import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-heading',
  templateUrl: './heading.component.html',
  styleUrls: ['./heading.component.css']
})
export class HeadingComponent implements OnInit {

  @Output() lang: EventEmitter<any> = new EventEmitter();

  constructor(public translate: TranslateService) { }

  ngOnInit() {
    if (localStorage.getItem("lang") != null) {
    this.translate.use(localStorage.getItem("lang") || 'bg');
    }
   }

  changeLang(lang: string) {
    if(lang == 'bg'){this.lang.emit(1);}
    if(lang == 'en'){this.lang.emit(0);}
    this.translate.use(lang);
    localStorage.setItem('lang', lang);
  }
}
