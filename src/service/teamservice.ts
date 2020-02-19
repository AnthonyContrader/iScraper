import { Injectable } from '@angular/core';
import { environment } from 'src/dto/environment.models';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { TeamDTO } from 'src/dto/teamdto';
import { tap, catchError } from 'rxjs/operators';
import { AbstractService } from './abstractservice';
@Injectable({
    providedIn: 'root'
  })
  export class TeamService extends AbstractService<TeamDTO>{
  
    constructor(http: HttpClient) {
      super(http);
      this.type = 'team';
    }
  }