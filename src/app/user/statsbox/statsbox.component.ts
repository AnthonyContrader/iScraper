import { Component, OnInit } from '@angular/core';
import { StatsboxService } from 'src/service/statsbox.service';
import { StatsboxDTO } from 'src/dto/statsboxdto';
import { PlayerDTO } from 'src/dto/playerdto'
import { PlayerService } from 'src/service/playerservice';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-statsbox',
  templateUrl: './statsbox.component.html',
  styleUrls: ['./statsbox.component.css']
})
export class StatsboxComponent implements OnInit {

  statsboxes: StatsboxDTO[];
  statsboxtoinsert: StatsboxDTO = new StatsboxDTO();
  players: PlayerDTO[];
  name: string;
  surname: string;

  constructor(private service: StatsboxService, private playerService: PlayerService) {
   }

  ngOnInit() {
    this.getStats();
    this.getPlayers();
  }

  getPlayers() {
    this.playerService.getAll().subscribe(players => this.players = players);
  }

  getStats() {
    this.service.getAll().subscribe(statsboxes => this.statsboxes = statsboxes);
  }

  delete(statsbox: StatsboxDTO) {
    this.service.delete(statsbox.id).subscribe(() => this.getStats());
  }

  update(statsbox: StatsboxDTO) {
    this.service.update(statsbox).subscribe(() => this.getStats());
  }

  insert(statsbox: StatsboxDTO) {
    this.service.insert(statsbox).subscribe(() => this.getStats());
  }

  readByName() {
    this.service.readByName(this.name, this.surname).subscribe(statsboxes => this.statsboxes = statsboxes);
  }

  clear(){
    this.statsboxtoinsert = new StatsboxDTO();
  }
}
