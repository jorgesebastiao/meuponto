import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LayoutModule } from '@angular/cdk/layout';
import {FlexModule} from '@angular/flex-layout';
import { CpfPipe, CnpjPipe, CellPhone } from './pipes';

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
    FlexModule
  ],
  exports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    FlexModule,
    CpfPipe,
    CnpjPipe,
    CellPhone,
  ]
})
export class SharedModule {
}
