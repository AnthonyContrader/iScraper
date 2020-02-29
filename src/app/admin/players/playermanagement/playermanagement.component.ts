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

      nome:string;
      teams:TeamDTO[];
      players: PlayerDTO[];
      playertoinsert: PlayerDTO = new PlayerDTO();
      team:TeamDTO;
      teamservice:TeamService;
      name:string;
      playerName:string;
     
      playersName: PlayerDTO[];
      playersValue:PlayerDTO[];
      playerOrder:PlayerDTO;
      option:string[] =["Valore Precedente","Valore attuale","Eta", "Squadra", "ID"];
     playersToEdit:PlayerDTO [];

      constructor(private service: PlayerService, private teamService:TeamService ) { }
      
      ngOnInit() {
          this.getPlayers();
          this.getTeams();
          this.service.getAll().subscribe(playersToEdit => this.playersToEdit = playersToEdit);
        //  this.findByName(this.nameInput);
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
          this.service.update(player).subscribe(() => this.getPlayers());
        }
      
        insert(player: PlayerDTO) {
          this.service.insert(this.playertoinsert).subscribe(() => this.getPlayers());
        }
        order(nome:string){
          this.clear();
          this.service.order(nome).subscribe(playersValue => this.playersValue= playersValue);
          this.service.order(nome).subscribe(players => this.players = players);
        }
       findByName(nome:string){
        this.clear();
        this.service.findByName(nome).subscribe(playersName => this.playersName= playersName);
        this.service.findByName(nome).subscribe(players => this.players = players);
       
        console.log(nome.toString());
      }
      
        clear(){
          this.playertoinsert = new PlayerDTO();

          this.playersValue= null;
          this.playersName= null;
        }

    

      }
      
