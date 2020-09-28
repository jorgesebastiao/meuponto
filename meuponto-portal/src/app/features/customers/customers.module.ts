import { NgModule } from '@angular/core';

import { CustomersRoutingModule } from './customers-routing.module';
import {SharedModule} from '../../shared/shared.module';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomersSharedModule } from './shared/customers-shared.module';
import { MpNgDatatableHeaderModule } from 'src/app/shared/mp-ng-datatable-header/component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';

@NgModule({
  declarations: [
    CustomersListComponent
  ],
  imports: [
    SharedModule,
    MpNgDatatableHeaderModule,
    NgxDatatableModule,
    CustomersSharedModule,
    CustomersRoutingModule
  ]
})
export class CustomersModule { }
