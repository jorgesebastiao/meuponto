import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CollaboratorsListComponent } from './collaborators-list/collaborators-list.component';
import { AuthGuard } from 'src/app/core/security';

const routes: Routes = [
    {
    path: '',
    component: CollaboratorsListComponent,
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  declarations: [],
  providers: [],
})
export class CollaboratorsRoutingModule { }
