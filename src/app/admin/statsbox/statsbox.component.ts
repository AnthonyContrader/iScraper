import { Component, OnInit } from '@angular/core';
import { StatsboxService } from 'src/service/statsbox.service';
import { StatsboxDTO } from 'src/dto/statsboxdto';

@Component({
  selector: 'app-statsbox',
  templateUrl: './statsbox.component.html',
  styleUrls: ['./stasbox.component.css']
})
export class StatsboxComponent implements OnInit {

  statsboxes: StatsboxDTO[];
  statstoinsert: StatsboxDTO = new StatsboxDTO();

  constructor(private service: StatsboxService) { }

  ngOnInit() {
    this.getStats();
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

  clear(){
    this.statstoinsert = new StatsboxDTO();
  }
}
