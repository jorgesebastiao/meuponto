import {NgModule} from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';
import {LayoutComponent} from './core/layout/layout.component';
import {AuthGuard} from './core/security/shared';

const appRoutes: Routes = [
  {
    path: 'page-not-found',
    loadChildren: './features/error-pages/page-not-found/page-not-found.module#PageNotFoundModule',
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full'
      },
      {
        path: 'dashboard',
        loadChildren: './features/dashboard/dashboard.module#DashboardModule'
      },
      {
        path: 'customers',
        loadChildren: './features/customers/customers.module#CustomersModule'
      },
      {
        path: 'collaborators',
        loadChildren: './features/collaborators/collaborators.module#CollaboratorsModule'
      }
    ],
    canActivate: [AuthGuard]
  },
  {
    path: 'page-not-authorized',
    loadChildren: './features/error-pages/page-not-authorized/page-not-authorized.module#PageNotAuthorizedModule',
  },
  {
    path: '**',
    redirectTo: 'page-not-found',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes,
    {
      preloadingStrategy: PreloadAllModules,
      paramsInheritanceStrategy: 'always',
    }
  )],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
