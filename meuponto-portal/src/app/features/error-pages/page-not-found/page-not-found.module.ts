import {NgModule} from '@angular/core';
import {PageNotFoundComponent} from './page-not-found.component';
import {SharedModule} from '../../../shared/shared.module';
import {PageNotFoundRoutingModule} from './page-not-found-routing.module';

@NgModule({
  declarations: [PageNotFoundComponent],
  imports: [
    SharedModule,
    PageNotFoundRoutingModule
  ]
})
export class PageNotFoundModule {
}
