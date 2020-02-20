import { Component, OnInit } from '@angular/core';
import { SearchService } from 'src/service/search.service';
import { UserService } from 'src/service/user.service';
import { PlayerService } from 'src/service/playerservice';
import { SearchDTO } from 'src/dto/searchdto';
import { UserDTO } from 'src/dto/userdto';
import { PlayerDTO } from 'src/dto/playerdto';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searches: SearchDTO[];
  searchtoinsert: SearchDTO = new SearchDTO();
  players: PlayerDTO[];
  users: UserDTO[];
  sessionUser: UserDTO;

  constructor(private searchService : SearchService,
    private playerService : PlayerService, private userService : UserService) { }

  ngOnInit(): void {
    this.getSearches();
    this.getPlayers();
    this.getUsers();
    this.sessionUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  getSearches(){
    this.searchService.getAll().subscribe(searches => this.searches = searches);
  }

  getPlayers(){
    this.playerService.getAll().subscribe(players => this.players = players);
  }

  getUsers(){
    this.userService.getAll().subscribe(users => this.users = users);
  }

  delete(search: SearchDTO) {
    this.searchService.delete(search.id).subscribe(() => this.getSearches());
  }

  update(search: SearchDTO) {
    if((isNaN(search.value) ||search.value.toString.length>0) ||
      (isNaN(search.player_index) || search.player_index.toString.length>0) ||
      (isNaN(search.user.id) || search.user.id.toString.length>0) ||
      (isNaN(search.player.id) || search.player.id.toString.length>0)) return null;
    else this.searchService.update(search).subscribe(() => this.getSearches());
  }

  insert(search: SearchDTO) {
    if(isNaN(search.value) || isNaN(search.player_index) ||
      isNaN(search.user.id) || isNaN(search.player.id)) return null;
    else this.searchService.insert(search).subscribe(() => this.getSearches());
  }

  clear(){
    this.searchtoinsert = new SearchDTO();
  }
}  