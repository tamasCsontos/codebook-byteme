import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {WorkplaceListComponent} from './workplace-list/workplace-list.component';
import {StudentListComponent} from './student-list/student-list.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/students', pathMatch: 'full' },
  { path: 'workplaces', component: WorkplaceListComponent},
  { path: 'students', component: StudentListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
