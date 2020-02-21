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
  sessionUser: UserDTO;

  constructor(private searchService : SearchService, private playerService : PlayerService,
    private userService : UserService, private router : Router) { }

  ngOnInit(): void {
    this.sessionUser = JSON.parse(localStorage.getItem('currentUser'));
    this.getSearches();
  }

  getSearches(){
    if (this.sessionUser==null || this.sessionUser.usertype.toString().toUpperCase()!='USER') this.router.navigate(['/login']);
    this.searchService.postAll(this.sessionUser).subscribe(searches => this.searches = searches);
    this.getPlayers();
  }

  getPlayers(){
    this.playerService.getAll().subscribe(players => this.players = players);
  }

  delete(search: SearchDTO) {
    if (this.sessionUser==null || this.sessionUser.usertype.toString().toUpperCase()!='USER') this.router.navigate(['/login']);
    this.searchService.delete(search.id).subscribe(() => this.getSearches());
  }

  insert(search: SearchDTO) {
    if (this.sessionUser==null || this.sessionUser.usertype.toString().toUpperCase()!='USER') this.router.navigate(['/login']);
    if(isNaN(search.value) || isNaN(search.player_index) ||
      isNaN(search.player.id) || isNaN(this.sessionUser.id)) return null;
    else {
      search.user = new UserDTO;
      search.user = this.sessionUser;
      this.searchService.insert(search).subscribe(() => this.getSearches());
    }
  }

  clear(){
    this.searchtoinsert = new SearchDTO();
  }
}  