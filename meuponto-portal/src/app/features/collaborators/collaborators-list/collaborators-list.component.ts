import {Component, OnInit} from '@angular/core';
import {Page} from '../../../shared/models/page/page.model';
import {ActivatedRoute, Router} from '@angular/router';
import { CollaboratorService } from '../shared/collaborator.service';

@Component({
  selector: 'mp-collaborators-list',
  templateUrl: './collaborators-list.component.html',
  styleUrls: ['./collaborators-list.component.scss']
})
export class CollaboratorsListComponent implements OnInit {
  page: Page;
  rows = [];
  isLoading: boolean;

  constructor(private  router: Router,
              private route: ActivatedRoute,
              private  collaboratorService: CollaboratorService) {
    this.page = new Page();
    this.page.pageNumber = 1;
    this.page.size = 10;
  }

  pageInfoInitial = {size: 10, offset: 0};
  columns = [
    { prop: 'id', name: 'ID' },
    { prop: 'name', name: 'Nome' },
    { prop: 'cpf', name: 'CPF' },
    { prop: 'registration', name: 'Matricula' },
    { prop: 'admissionDate', name: 'Data de admissão' }
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
    this.collaboratorService.getAll(this.page, filter).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.pageNumber = pagedData.pageable.pageNumber;
      this.page.totalPages = pagedData.totalPages;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
      this.isLoading = false;
    });
  }

  public registerCollaborator(event) {
    this.router.navigate(['new'], {relativeTo: this.route});
  }

  public searchCollaborator(search) {
    this.setPage(this.pageInfoInitial, search.search);
  }
}
