import {Component, OnInit} from '@angular/core';
import {Page} from '../../../shared/models/page/page.model';
import {ActivatedRoute, Router} from '@angular/router';
import { CustomerService } from '../shared/customer.service';

@Component({
  selector: 'mp-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.scss']
})
export class CustomersListComponent implements OnInit {
  page: Page;
  rows = [];
  isLoading: boolean;

  constructor(private  router: Router,
              private route: ActivatedRoute,
              private  customerService: CustomerService) {
    this.page = new Page();
    this.page.pageNumber = 1;
    this.page.size = 10;
  }

  pageInfoInitial = {size: 10, offset: 0};
  columns = [
    { prop: 'id', name: 'ID' },
    { prop: 'corporateName', name: 'Razão Social' },
    { prop: 'tradeName', name: 'Nome Fantasia' },
    { prop: 'cnpj', name: 'CNPJ' }
  ];

  messages: any = {
    emptyMessage: 'Não há dados para exibição',
    totalMessage: 'total',
    selectedMessage: 'selecionado'
  };

  ngOnInit() {
    this.setPage(this.pageInfoInitial);
  }

  setPage(pageInfo, filter?: string) {
    this.isLoading = true;
    this.page.pageNumber = pageInfo.offset;
    this.customerService.getAll(this.page, filter).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.pageNumber = pagedData.pageable.pageNumber;
      this.page.totalPages = pagedData.totalPages;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
      this.isLoading = false;
    });
  }

  public registerCustomer(event) {
    this.router.navigate(['new'], {relativeTo: this.route});
  }
  public searchCustomer(search) {
    this.setPage(this.pageInfoInitial, search.search);
  }
}
