import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {
  isPlayerCollapsed = false;
  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isStatsboxCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }
  playercollapse() {
    if (this.isPlayerCollapsed === false) {
      this.isPlayerCollapsed = true;
    } else { this.isPlayerCollapsed = false; }
  }
  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
  statsboxcollapse() {
    if (this.isStatsboxCollapsed === false) {
      this.isStatsboxCollapsed = true;
    }
    else { this.isStatsboxCollapsed = false; }
  }
}
