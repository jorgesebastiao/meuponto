import { NgModule } from '@angular/core';

import { CollaboratorsRoutingModule } from './collaborators-routing.module';
import {SharedModule} from '../../shared/shared.module';
import { CollaboratorsSharedModule } from './shared/collaborators-shared.module';
import { MpNgDatatableHeaderModule } from 'src/app/shared/mp-ng-datatable-header/component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import { CollaboratorsListComponent } from './collaborators-list/collaborators-list.component';

@NgModule({
  declarations: [CollaboratorsListComponent],
  imports: [
    SharedModule,
    MpNgDatatableHeaderModule,
    NgxDatatableModule,
    CollaboratorsSharedModule,
    CollaboratorsRoutingModule
  ]
})
export class CollaboratorsModule { }
