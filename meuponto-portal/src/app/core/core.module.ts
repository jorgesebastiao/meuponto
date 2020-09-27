import {LOCALE_ID, NgModule, Optional, SkipSelf} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {LayoutModule} from './layout/layout.module';
import {SecurityModule} from './security';
import {ToastrModule, ToastrService} from 'ngx-toastr';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [],
  imports: [
    HttpClientModule,
    SharedModule,
    LayoutModule,
    SecurityModule,
    ToastrModule.forRoot({
      closeButton: true
    })
  ],
  exports: [
    ToastrModule
  ],
  providers: [
    ToastrService,
    {provide: LOCALE_ID, useValue: 'pt-BR'}
  ]
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule) {
      throw new Error('CoreModule can only be loaded in AppModule');
    }
  }
}
