import { Component, OnInit } from '@angular/core';
import { Page } from '../../../shared/models/page/page.model';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../shared/customer.service';
import { CustomerEditComponent } from '../customer-edit/customer-edit.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'mp-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.scss']
})
export class CustomersListComponent implements OnInit {
  page: Page;
  rows = [];
  isLoading: boolean;

  constructor(public dialog: MatDialog,
    private customerService: CustomerService) {
    this.page = new Page();
    this.page.pageNumber = 1;
    this.page.size = 10;
  }

  pageInfoInitial = { size: 10, offset: 0 };
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
    const dialogRef = this.dialog.open(CustomerEditComponent, {
      width: "600px",
      data: { title: "Adicionar Cliente", action: "Salvar" },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) this.setPage(this.pageInfoInitial);
    });
  }

  public searchCustomer(search) {
    this.setPage(this.pageInfoInitial, search.search);
  }

  public editCustomer(customerId) {
    const dialogRef = this.dialog.open(CustomerEditComponent, {
      width: "600px",
      data: { title: "Editar Cliente", action: "Editar", customerId: customerId },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) this.setPage(this.pageInfoInitial);
    });
  }
}
