export class SortingPaging {
    pageSize?: number;
    pageIndex?: number;
    totalSize?: number;
   
     private sortBy?: string;
     private sortDirection?: string;
   
     public isSortingValid(): boolean {
       if (this.sortBy && this.sortDirection && this.sortDirection.length !== 0 && this.sortDirection.trim()) {
           return true;
       }
       return false;
     }
   
     public getPageSize(): string {
         if (this.pageSize == null) {
             return "";
         } else {
           return this.pageSize.toString();
         }
     }
   
     public getPageIndex(): string {
       if (this.pageIndex == null) {
           return "";
       } else {
         return this.pageIndex.toString();
       }
     }
   
     public getSortBy(): string {
       if (!this.sortBy) {
           return "";
       } else {
         return this.sortBy;
       }
     }
   
     public setSortBy(sortBy: string): void {
         this.sortBy = sortBy;
     }
   
     public getSortDirection(): string {
       if (!this.sortDirection) {
           return "";
       } else {
         return this.sortDirection;
       }
     }
   
     public setSortDirection(sortDirection: string): void {
         this.sortDirection = sortDirection;
     }
}
