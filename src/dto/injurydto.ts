import { PlayerDTO } from './playerdto';

export class InjuryDTO {
    id: number;
	
	severity: number;
	
	description: String;
	
    duration: number;
    
	date: String;
	
	player: PlayerDTO;
}