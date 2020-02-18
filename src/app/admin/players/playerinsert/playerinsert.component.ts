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
  public playerDTO: PlayerDTO;
  public user: UserDTO;

  constructor(private router: Router, private playerService: PlayerService) { }

  ngOnInit() {
    
    this.playerDTO = new PlayerDTO();
    console.log(this.playerDTO.toString())

    
  }
  insert(playerDTO: PlayerDTO) {
    this.playerService.insertPlayer(playerDTO).subscribe();
  }
  insertPlayer(){
    //this.thingDTO.user = JSON.parse(sessionStorage.getItem("User")) as UserDTO;
  //  this.labelDTO.user.idUser = parseInt(sessionStorage.getItem("idUser"));
  //  console.log(this.labelDTO.user.idUser);
   
  this.playerService.insertPlayer(this.playerDTO).subscribe((data: any) => {
    console.log(this.playerDTO.toString())
    if(data != null)
      alert("Inserimento effettuato");
    else
      alert("Inserimento fallito");

      this.router.navigateByUrl("/player/playermanagement");
  })
}

}
