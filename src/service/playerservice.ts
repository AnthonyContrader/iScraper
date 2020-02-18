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
  feedback: string;
  private urlBase = environment.url;

<<<<<<< HEAD
  constructor(http: HttpClient) {
    super(http);
    this.type="player";
=======
  //List<Player> findByT(team:TeamDTO);


  constructor(private http: HttpClient) {
    
>>>>>>> 2868d4c72e83a48bfc16490bf7cc10dfbb1164fa
  }

  private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
          console.error(error);
          console.log('${operation} failed: ${error.message}');
          return of(result as T);
      };
  }

  playerList(): Observable<Array<PlayerDTO>> {
    return this.http.get<any>('http://localhost:8080/player/getall')
        .pipe(tap((response) => console.log('Player'), catchError(this.handleError('error', {})))
        );
}

  insertPlayer(player: PlayerDTO) {
   
      return this.http.post('http://localhost:8080/player/insert', player) .pipe(tap((response) => console.log('Player'), catchError(this.handleError('error', {})))
      );
  }


  readPlayer(id: number): Observable<PlayerDTO> {
      return this.http.get<any>('http://localhost:8080/player/findplayer?id=' + id);
       //   .pipe(tap((response) => console.log('Task'), catchError(this.handleError('error', {})))
          
  }

  deletePlayer(id: number) {
     return this.http.delete('http://localhost:8080/player/delete?id=' + id);
  }

  updatePlayer(player: PlayerDTO) {
      return this.http.put('http://localhost:8080/player/update', player);
  }
  
}