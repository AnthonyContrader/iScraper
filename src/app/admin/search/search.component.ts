import { Component, OnInit } from '@angular/core';
import { SearchService } from 'src/service/search.service';
import { UserService } from 'src/service/user.service';
import { PlayerService } from 'src/service/playerservice';
import { SearchDTO } from 'src/dto/searchdto';
import { UserDTO } from 'src/dto/userdto';
import { PlayerDTO } from 'src/dto/playerdto';
import { Router } from '@angular/router';

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

  constructor(private searchService : SearchService, private playerService : PlayerService,
    private userService : UserService, private router: Router) { }

  ngOnInit(): void {
    this.sessionUser = JSON.parse(localStorage.getItem('currentUser'));
    this.getSearches();
  }

  getSearches(){
    if (this.sessionUser==null || this.sessionUser.usertype.toString().toUpperCase()!='ADMIN') this.router.navigate(['/login']);
    this.searchService.postAll(this.sessionUser).subscribe(searches => this.searches = searches);
    this.getPlayers();
    this.getUsers();
  }
  

  getPlayers(){
    this.playerService.getAll().subscribe(players => this.players = players);
  }

  getUsers(){
    this.userService.getAll().subscribe(users => this.users = users);
  }

  delete(search: SearchDTO) {
    if (this.sessionUser==null || this.sessionUser.usertype.toString().toUpperCase()!='ADMIN') this.router.navigate(['/login']);
    this.searchService.delete(search.id).subscribe(() => this.getSearches());
  }

  update(search: SearchDTO) {
    if (this.sessionUser==null || this.sessionUser.usertype.toString().toUpperCase()!='ADMIN') this.router.navigate(['/login']);
    if((isNaN(search.value) || search.value.toString().trim().length==0) ||
      (isNaN(search.player_index) || search.player_index.toString().trim().length==0) ||
      (isNaN(search.user.id) || search.user.id.toString().trim().length==0) ||
      (isNaN(search.player.id) || search.player.id.toString().trim().length==0)) return null;
    else {
      if (Object.prototype.toString.call(search.search_date) === "[object Date]"
        && !isNaN(search.search_date.getTime()))
        this.searchService.update(search).subscribe(() => this.getSearches());
      else return null;
    }
  }

  insert(search: SearchDTO) {
    switch (this.sessionUser.usertype.toString().toUpperCase()){

    case 'ADMIN':
      if((isNaN(search.value) || search.value.toString().trim().length==0) ||
      (isNaN(search.player_index) || search.player_index.toString().trim().length==0) ||
      (isNaN(search.user.id) || search.user.id.toString().trim().length==0) ||
      (isNaN(search.player.id) || search.player.id.toString().trim().length==0)) return null;
      else {
        if (Object.prototype.toString.call(search.search_date) === "[object Date]"
          && !isNaN(search.search_date.getTime()))
          this.searchService.insert(search).subscribe(() => this.getSearches());
        else return null;
      }
      break;
    
    default:
      this.router.navigate(['/login']);
      break;
    }
  }

  clear(){
    this.searchtoinsert = new SearchDTO();
  }
}  