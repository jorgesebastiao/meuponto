import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MpNgDatatableHeaderComponent } from './mp-ng-datatable-header.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {
  MatButtonModule,
  MatFormFieldModule, MatIconModule,
  MatInputModule
} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';

@NgModule({
  declarations: [MpNgDatatableHeaderComponent],
  exports: [
    MpNgDatatableHeaderComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    FlexLayoutModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule
  ]
})
export class MpNgDatatableHeaderModule { }
