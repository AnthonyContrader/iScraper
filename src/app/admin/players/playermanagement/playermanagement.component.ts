import { Component, OnInit } from '@angular/core';
import { PlayerDTO } from 'src/dto/playerdto';
import { PlayerService } from 'src/service/playerservice';
import { Router } from '@angular/router';
import { TeamDTO } from 'src/dto/teamdto';
import { TeamService } from 'src/service/teamservice';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-playermanagement',
  templateUrl: './playermanagement.component.html',
  styleUrls: ['./playermanagement.component.css']
})
export class PlayermanagementComponent implements OnInit {

    
   teams:TeamDTO[];
        players: PlayerDTO[];
        playertoinsert: PlayerDTO = new PlayerDTO();
      team:TeamDTO;
      teamservice:TeamService;
      name:string;
      playerName:string;
      nameInput:string;
playersName:string[];
        constructor(private service: PlayerService, private teamService:TeamService, ) { }
      
        ngOnInit() {
          this.getPlayers();
          this.getTeams();
        }
        getTeams(){
        this.teamService.getAll().subscribe(teams=> this.teams=teams);
      }
        getPlayers() {
          this.service.getAll().subscribe(players => this.players = players);
        }
      
        delete(player: PlayerDTO) {
          this.service.delete(player.id).subscribe(() => this.getPlayers());
        }
      
        update(player: PlayerDTO) {
        //  this.teamService.getTeambyName(player.team.name);
          this.service.update(player).subscribe(() => this.getPlayers());
        }
      
        insert(player: PlayerDTO) {
        //  this.teamservice.getTeambyName()
          this.service.insert(this.playertoinsert).subscribe(() => this.getPlayers());
        }
      findByName(nome:string){
        this.service.findByName(nome).subscribe(players => this.players= players)
      }
        clear(){
          this.playertoinsert = new PlayerDTO();
        }

        getFromInput(nameForm: NgForm):void {
           this.nameInput=nameForm.value;
           console.log(nameForm.value);
        }
       


      }
      
