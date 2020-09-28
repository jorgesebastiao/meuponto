import { NgModule } from '@angular/core';

import { CustomersRoutingModule } from './customers-routing.module';
import {SharedModule} from '../../shared/shared.module';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomersSharedModule } from './shared/customers-shared.module';
import { MpNgDatatableHeaderModule } from 'src/app/shared/mp-ng-datatable-header/component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import { MatButtonModule, MatDialogModule, MatFormFieldModule, MatIconModule, MatInputModule } from '@angular/material';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';

@NgModule({
  declarations: [
    CustomersListComponent,
    CustomerEditComponent
  ],
  imports: [
    SharedModule,
    MatDialogModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MpNgDatatableHeaderModule,
    NgxDatatableModule,
    CustomersSharedModule,
    CustomersRoutingModule
  ],
  entryComponents:[CustomerEditComponent]
})
export class CustomersModule { }
