import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { SearchDTO } from 'src/dto/searchdto';
import { HttpClient } from '@angular/common/http';
import { PlayerService } from 'src/service/playerservice';
import { UserService } from 'src/service/user.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService extends AbstractService<SearchDTO>{

  port: string = '8080';
  
  constructor(http: HttpClient) { 
    super(http);
    this.type = 'search';
  }
    /*insert(dto: SearchDTO){
        dto.user.id = Number(dto.user.id);
        dto.player.id = Number(dto.player.id);
        return this.http.post('http://localhost:' + this.port + '/' + this.type + '/insert', dto);    
    }
  /*insert(dto: SearchDTO){
    const myObserver = {
       next: x => array.push(x),
       error: err => console.error('Observer got an error: ' + err),
       complete: () => console.log('Observer got a complete notification'),
    };
    let userService: UserService;
    let playerService: PlayerService;
    let userDto=userService.read(dto.user.id);
    let array = new Array();
    userDto.subscribe(myObserver);
    dto.user.id = array[0];
    dto.user.username = array[1];
    dto.user.password = array[2];
    dto.user.usertype = array[3];
    let playerDto=playerService.read(dto.user.id);
    playerDto.subscribe(myObserver);
    dto.player.id = array[0];
    dto.player.team = array[1];
    dto.player.player_name = array[2];
    dto.player.player_surname = array[3];
    dto.player.age = array[4];
    dto.player.actualMarketValue = array[5];
    dto.player.previousMarketValue = array[6];
    dto.player.position = array[7];
    return this.http.post('http://localhost:' + this.port + '/' + this.type + '/insert', dto);
  }*/
}