import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';



import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { PlayermanagementComponent } from './players/playermanagement/playermanagement.component';
import { StatsboxComponent } from './statsbox/statsbox.component';


/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see USerRoutingModule
 */
@NgModule({
  declarations: [UserDashboardComponent,WorkInProgressComponent,PlayermanagementComponent,StatsboxComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
