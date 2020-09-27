import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PageNotAuthorizedComponent} from './page-not-authorized.component';

const routes: Routes = [
  {
    path: '',
    component: PageNotAuthorizedComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PageNotAuthorizedRoutingModule { }
