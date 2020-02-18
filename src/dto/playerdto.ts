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
//  userDTO: import("c:/Users/majorsky/Documents/iscraper-angular/src/dto/userdto").UserDTO;
}