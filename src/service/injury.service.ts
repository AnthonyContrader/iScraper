import { HttpClient } from '@angular/common/http';
import { InjuryDTO } from 'src/dto/injurydto';
import { AbstractService } from './abstractservice';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })

export class InjuryService extends AbstractService<InjuryDTO> {
    
    constructor (http: HttpClient){
        super(http);
        this.type='injury';
    }
}