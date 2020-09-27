import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MpNgNavbarComponent} from './mp-ng-navbar.component';
import {MatToolbarModule, MatIconModule, MatButtonModule} from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule
  ],
  declarations: [ MpNgNavbarComponent],
  exports: [ MpNgNavbarComponent]
})
export class MpNgNavbarModule { }
