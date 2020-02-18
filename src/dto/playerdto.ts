import { TeamDTO } from './teamdto';



export class PlayerDTO {

   	id:number;
    team:TeamDTO;
	player_name:string;
	player_surname:string;
	age:number;
	actualMarketValue:number;
	previousMarketValue:number;
	position:string;
	//team_id:number;
	constructor(){};
}