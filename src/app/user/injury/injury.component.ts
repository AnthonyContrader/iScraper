import { Component, OnInit } from '@angular/core';
import { StatsboxService } from 'src/service/statsbox.service';
import { StatsboxDTO } from 'src/dto/statsboxdto';
import { PlayerDTO } from 'src/dto/playerdto'
import { PlayerService } from 'src/service/playerservice';
import { HttpClient } from '@angular/common/http';
import { InjuryDTO } from 'src/dto/injurydto';
import { InjuryService } from 'src/service/injury.service';

@Component({
  selector: 'app-injury',
  templateUrl: './injury.component.html',
  styleUrls: ['./injury.component.css']
})
export class InjuryComponent implements OnInit {

  injuries: InjuryDTO[];
  injurytoinsert: InjuryDTO = new InjuryDTO();
  players: PlayerDTO[];

  constructor(private service: InjuryService, private playerService: PlayerService) {
   }

  ngOnInit() {
    this.getStats();
    this.getPlayers();
  }

  getPlayers() {
    this.playerService.getAll().subscribe(players => this.players = players);
  }

  getStats() {
    this.service.getAll().subscribe(injuries => this.injuries = injuries);
  }

  delete(injury: InjuryDTO) {
    this.service.delete(injury.id).subscribe(() => this.getStats());
  }

  update(injury: InjuryDTO) {
    this.service.update(injury).subscribe(() => this.getStats());
  }

  insert(injury: InjuryDTO) {
    this.service.insert(injury).subscribe(() => this.getStats());
  }

  clear(){
    this.injurytoinsert = new InjuryDTO();
  }
}
