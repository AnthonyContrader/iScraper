import { Component, OnInit } from '@angular/core';
import { PlayerDTO } from 'src/dto/playerdto';
import { PlayerService } from 'src/service/playerservice';
import { Router } from '@angular/router';
import { TeamDTO } from 'src/dto/teamdto';
import { TeamService } from 'src/service/teamservice';

@Component({
  selector: 'app-playermanagement',
  templateUrl: './playermanagement.component.html',
  styleUrls: ['./playermanagement.component.css']
})
export class PlayermanagementComponent implements OnInit {

    
  public teamInserts: Array<TeamDTO>;
        players: PlayerDTO[];
        playertoinsert: PlayerDTO = new PlayerDTO();
      team:TeamDTO;
      teamservice:TeamService;
      

        constructor(private service: PlayerService, private teamService:TeamService) { }
      
        ngOnInit() {
          this.getPlayers();
          
        }
      
        getPlayers() {
          this.service.playerList().subscribe(players => this.players = players);
        }
      
        delete(player: PlayerDTO) {
          this.service.deletePlayer(player.id).subscribe(() => this.getPlayers());
        }
      
        update(player: PlayerDTO) {
          this.service.updatePlayer(player).subscribe(() => this.getPlayers());
        }
      
        insert(player: PlayerDTO) {
        //  this.teamservice.getTeambyName()
          this.service.insertPlayer(this.playertoinsert).subscribe(() => this.getPlayers());
        }
      
        clear(){
          this.playertoinsert = new PlayerDTO();
        }
      }
      
