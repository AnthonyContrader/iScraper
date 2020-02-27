import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable, of } from 'rxjs';
import { PlayerDTO } from 'src/dto/playerdto';
import { environment } from 'src/dto/environment.models';



import { tap, catchError } from 'rxjs/operators';


import { logging } from 'protractor';
import { TeamDTO } from 'src/dto/teamdto';
/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class PlayerService extends AbstractService<PlayerDTO>{
  
  constructor(http: HttpClient) {
    super(http);
    this.type = 'player';
  }
  findByName(nome:string):Observable<any>{
    return this.http.get<PlayerDTO>('http://localhost:' + this.port + '/' + this.type + '/findByName?name=' + nome);
}
}