import { NgModule } from '@angular/core';

import { PageNotAuthorizedRoutingModule } from './page-not-authorized-routing.module';
import { PageNotAuthorizedComponent } from './page-not-authorized.component';
import {SharedModule} from '../../../shared/shared.module';

@NgModule({
  declarations: [PageNotAuthorizedComponent],
  imports: [
    SharedModule,
    PageNotAuthorizedRoutingModule
  ]
})
export class PageNotAuthorizedModule { }
