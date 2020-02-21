import { Component, OnInit } from '@angular/core';
import { TeamDTO } from 'src/dto/teamdto';
import { TeamService } from 'src/service/teamservice';


@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {
  teams:TeamDTO[];
 
  teamtoinsert: TeamDTO = new TeamDTO();


  constructor( private teamService:TeamService) { }

  ngOnInit() {
   this.getTeams();
  }

  getTeams(){
    this.teamService.getAll().subscribe(teams=> this.teams=teams);
  }
  

  delete(team: TeamDTO) {
    this.teamService.delete(team.id).subscribe(() => this.getTeams());
  }

  update(team: TeamDTO) {
    this.teamService.update(team).subscribe(() => this.getTeams());
  }

  insert(team: TeamDTO) {
    this.teamService.insert(this.teamtoinsert).subscribe(() => this.getTeams());
  }

  clear(){
    this.teamtoinsert = new TeamDTO();
  }
}

