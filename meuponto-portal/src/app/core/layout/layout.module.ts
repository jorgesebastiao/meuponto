import { NgModule } from '@angular/core';
import { LayoutComponent } from './layout.component';
import {SharedModule} from '../../shared/shared.module';
import {LoadingBarRouterModule} from '@ngx-loading-bar/router';
import {RouterModule} from '@angular/router';
import {MpNgNavbarModule} from '../../shared/mp-ng-navbar/component';
import {  MatSidenavModule, MatToolbarModule, MatListModule, MatIconModule } from '@angular/material';

@NgModule({
  declarations: [LayoutComponent],
  imports: [
    MpNgNavbarModule,
    SharedModule,
    RouterModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    LoadingBarRouterModule,
    MatListModule
  ]
})
export class LayoutModule { }
