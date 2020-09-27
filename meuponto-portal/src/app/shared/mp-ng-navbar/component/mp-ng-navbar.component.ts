import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'mp-ng-navbar',
  templateUrl: './mp-ng-navbar.component.html',
  styleUrls: ['./mp-ng-navbar.component.scss']
})
export class MpNgNavbarComponent implements OnInit {

  @Output() toggleSidenav = new EventEmitter<void>();

  constructor() { }

  ngOnInit() {
  }

}
