import { NgModule } from '@angular/core';

import { SecurityRoutingModule } from './security-routing.module';
import { SharedModule } from '../../shared/shared.module';
import { SecurityComponent } from './security.component';
import { LoginComponent } from './login/login.component';
import { RecoverPasswordComponent } from './recover-password/recover-password.component';
import { AuthInterceptor, SecuritySharedModule, JwtConfigService } from './shared';
import { JwtHelperService, JwtModule, JWT_OPTIONS } from '@auth0/angular-jwt';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatCheckboxModule, MatFormFieldModule, MatIconModule, MatInputModule } from '@angular/material';
import { JwtOptionsFactory } from './shared/jwt-options-factory';

@NgModule({
  declarations: [
    SecurityComponent,
    LoginComponent,
    RecoverPasswordComponent],
  imports: [
    SharedModule,
    SecurityRoutingModule,
    SecuritySharedModule,
    JwtModule.forRoot({
      jwtOptionsProvider: {
        provide: JWT_OPTIONS,
        useFactory: JwtOptionsFactory,
        deps: [JwtConfigService],
      }
    }),
    MatCheckboxModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
  ],
  providers: [
    JwtHelperService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ]
})
export class SecurityModule { }
