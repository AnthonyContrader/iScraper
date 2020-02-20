import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

import { PlayermanagementComponent } from './players/playermanagement/playermanagement.component';

import { StatsboxComponent } from './statsbox/statsbox.component';
import { TeamsComponent } from './teams/teams.component';
import { SearchComponent } from './search/search.component'
import { InjuryComponent } from './injury/injury.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, InjuryComponent, UsersComponent, StatsboxComponent, WorkInProgressComponent, PlayermanagementComponent, TeamsComponent, SearchComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
    
  ]
})
export class AdminModule { }
