import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LayoutModule } from '@angular/cdk/layout';
import {FlexModule} from '@angular/flex-layout';
import { CpfPipe, CnpjPipe, CellPhone } from './pipes';
import { FormService } from './services/form.service';
import { NgxLoadingModule } from 'ngx-loading';

@NgModule({
  declarations: [
    CpfPipe,
    CnpjPipe,
    CellPhone
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutModule,
    FlexModule,
    NgxLoadingModule
  ],
  exports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    FlexModule,
    CpfPipe,
    CnpjPipe,
    CellPhone,
    NgxLoadingModule
  ],
  providers: [
    FormService
  ]
})
export class SharedModule {
}
