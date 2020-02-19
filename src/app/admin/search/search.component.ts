import { Component, OnInit } from '@angular/core';
import { SearchService } from 'src/service/search.service';
import { SearchDTO } from 'src/dto/searchdto';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searches: SearchDTO[];
  searchtoinsert: SearchDTO = new SearchDTO();

  constructor(private service : SearchService) { }

  ngOnInit(): void {
    this.getSearches();
  }

  getSearches(){
    this.service.getAll().subscribe(searches => this.searches = searches);
  }

  delete(search: SearchDTO) {
    this.service.delete(search.id).subscribe(() => this.getSearches());
  }

  update(search: SearchDTO) {
    this.service.update(search).subscribe(() => this.getSearches());
  }

  insert(search: SearchDTO) {
    this.service.insert(search).subscribe(() => this.getSearches());
  }

  clear(){
    this.searchtoinsert = new SearchDTO();
  }
}  