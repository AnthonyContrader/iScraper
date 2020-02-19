import { UserDTO } from './userdto';
import { PlayerDTO } from './playerdto';
import { NumberValueAccessor } from '@angular/forms';

export class SearchDTO {

    id: number;
    search_date: Date;
    value: number;
    player_index: number;
    user: UserDTO;
    player: PlayerDTO;

}