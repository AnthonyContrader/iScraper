import { Component, OnInit } from '@angular/core';
import { PlayerDTO } from 'src/dto/playerdto';
import { PlayerService } from 'src/service/playerservice';
import { Router } from '@angular/router';
import { TeamDTO } from 'src/dto/teamdto';

@Component({
  selector: 'app-playermanagement',
  templateUrl: './playermanagement.component.html',
  styleUrls: ['./playermanagement.component.css']
})
export class PlayermanagementComponent implements OnInit {

  public players: Array<PlayerDTO>;

  constructor(private playerService: PlayerService, private router: Router) { }

  ngOnInit() {
      this.playerService.playerList().subscribe((response) => {
          this.players = response;
          
          console.log('La grandezza e\'' + this.players.length);
      });
  }

    removeLink(id: number) {
        
        this.playerService.deletePlayer(id);
     /**   this.router.navigateByUrl('/Client/clientManagement'); */
    }
    updateLink(id: number) {
        
        this.router.navigateByUrl('/players/playerupdate/' + id);
    }

    insertLink():any {
        this.router.navigateByUrl('/players/playerinsert/');
        console.log('clicked')
    }
}
