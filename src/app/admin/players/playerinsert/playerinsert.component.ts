import { Component, OnInit } from '@angular/core';
import { PlayerDTO } from 'src/dto/playerdto';
import { PlayerService } from 'src/service/playerservice';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-playerinsert',
  templateUrl: './playerinsert.component.html',
  styleUrls: ['./playerinsert.component.css']
})
export class PlayerinsertComponent implements OnInit {

  
  public player: PlayerDTO;
  constructor(private playerService: PlayerService, private router: Router) { }

  ngOnInit() {
      const userInsert: UserDTO = JSON.parse(sessionStorage.getItem('user'));
      this.player = new PlayerDTO();
  }
  insertPlayer(f: NgForm) {
      console.log('PLayer Id: ' + f.value.playerName);
      this.playerService.insertPlayer(this.player);
  }
}