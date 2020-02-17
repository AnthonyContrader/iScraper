import { Component, OnInit } from '@angular/core';
import { PlayerDTO } from 'src/dto/playerdto';
import { PlayerService } from 'src/service/playerservice';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-playerupdate',
  templateUrl: './playerupdate.component.html',
  styleUrls: ['./playerupdate.component.css']
})
export class PlayerupdateComponent implements OnInit {

  id: number;
  playerName: string;
  public player: PlayerDTO;

constructor(private playerService: PlayerService, private route: ActivatedRoute, private router: Router) { }

ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    console.log('Resource id in update:' + this.id);
    this.playerService.readPlayer(this.id).subscribe((response) => {
        this.player = response;
        console.log('PLayer caricato: ' + this.player.player_name);
        
    });
  }

 update(f: NgForm) {
      console.log(f.value);
      const userUpdate: UserDTO = JSON.parse(sessionStorage.getItem('user'));
     // this.player.userD = userUpdate;
      this.playerService.updatePlayer(this.player);
   //   this.router.navigateByUrl('/Client/clientManagement');
  }

}
