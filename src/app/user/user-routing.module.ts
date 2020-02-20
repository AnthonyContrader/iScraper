import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsersComponent } from '../admin/users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

import { StatsboxComponent } from './statsbox/statsbox.component';
import { TeamsComponent } from './teams/teams.component';
import { PlayermanagementComponent } from './playermanagement/playermanagement/playermanagement.component';
import { SearchComponent } from './search/search.component';




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
  { path: 'user-dashboard', component: UserLayoutComponent, children:[
    { path: 'user/work-in-progress', component:WorkInProgressComponent},
    { path: '', component: UserDashboardComponent},
    { path: 'user', component: UsersComponent},
    { path: 'playermanagement', component: PlayermanagementComponent},
    { path: 'statsbox', component: StatsboxComponent},
    { path: 'teams', component: TeamsComponent},
    { path: 'search', component: SearchComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }