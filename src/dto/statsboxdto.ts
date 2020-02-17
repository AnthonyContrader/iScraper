import {PlayerDTO} from 'src/dto/playerdto'

export class StatsboxDTO {

   id: number;

   player: PlayerDTO;

   season: number;

   caps: number;
    
   contributions: number;
        
   shotsper: number;
    
   keypass: number; 
    
   passprec: number;
    
   dribbling: number;
    
   foulssub: number; 
    
   foulscomm: number;
        
   tackles: number; 
    
   tacklesper: number; 
        
   breaks: number;
}

