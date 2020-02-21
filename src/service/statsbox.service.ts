import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StatsboxDTO } from 'src/dto/statsboxdto';

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
export class StatsboxService extends AbstractService<StatsboxDTO>{
  
  constructor(http: HttpClient) {
    super(http);
    this.type = 'statsbox';
  }

  readByName(name: string, surname: string): Observable<StatsboxDTO[]> {
    return this.http.get<StatsboxDTO[]>('http://localhost:' + this.port + '/' + this.type + '/readByName', {params:{name,surname}})
  }
}
