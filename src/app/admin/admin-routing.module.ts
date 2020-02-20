import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

import { PlayermanagementComponent } from './players/playermanagement/playermanagement.component';

import { StatsboxComponent } from './statsbox/statsbox.component';
import { TeamsComponent } from './teams/teams.component';
import { SearchComponent } from './search/search.component';
import { InjuryComponent } from './injury/injury.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'players/playermanagement', component: PlayermanagementComponent},
    { path: 'teams', component: TeamsComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent},
    { path: 'statsbox', component: StatsboxComponent},
    { path: 'search', component: SearchComponent},
    { path: 'injuries', component: InjuryComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }