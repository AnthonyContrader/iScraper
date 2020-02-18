import { Injectable } from '@angular/core';
import { environment } from 'src/dto/environment.models';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { TeamDTO } from 'src/dto/teamdto';
import { tap, catchError } from 'rxjs/operators';
@Injectable({
    providedIn: 'root'
  })
  export class TeamService {
    feedback: string;
    private urlBase = environment.url;
  
    //List<Player> findByT(team:TeamDTO);
  
  
    constructor(private http: HttpClient) {
      
    }
  
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
  
    
    teamList(): Observable<Array<TeamDTO>> {
      return this.http.get<any>('http://localhost:8080/team/getall')
          .pipe(tap((response) => console.log('Team'), catchError(this.handleError('error', {})))
          );
  }
  
    insertTeam(team: TeamDTO) {
     
        return this.http.post('http://localhost:8080/team/insert', team) .pipe(tap((response) => console.log('Team'), catchError(this.handleError('error', {})))
        );
    }
  
  
    readTeam(id: number): Observable<TeamDTO> {
        return this.http.get<any>('http://localhost:8080/team/findteam?id=' + id);
         //   .pipe(tap((response) => console.log('Task'), catchError(this.handleError('error', {})))
            
    }
  
    deleteTeam(id: number) {
       return this.http.delete('http://localhost:8080/team/delete?id=' + id);
    }
  
    updateTeam(team: TeamDTO) {
        return this.http.put('http://localhost:8080/team/update', team);
    }
    getTeambyName(name:String): Observable<TeamDTO> {
        return this.http.get<any>('http://localhost:8080/team/findTeambyName=' + name)
            .pipe(tap((response) => console.log('Team'), catchError(this.handleError('error', {})))
            );
    }
  }