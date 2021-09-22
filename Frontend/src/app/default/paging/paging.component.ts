import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-paging',
  templateUrl: './paging.component.html',
  styleUrls: ['./paging.component.css']
})
export class PagingComponent implements OnInit {
  @Input() pageIndex?: number;
  @Input() pageSize?: number;
  @Input() isPrevBtnDisabled?: boolean;
  @Input() isNextBtnDisabled?: boolean;

  @Output() changePageIndexForMe: EventEmitter<string> = new EventEmitter();
  @Output() changePageSizeForMe: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  pageIndexChanged(direction: string) {
    this.changePageIndexForMe.emit(direction);
  }

  pageSizeChanged(event: any) {
    this.changePageSizeForMe.emit(event);
  }
}
