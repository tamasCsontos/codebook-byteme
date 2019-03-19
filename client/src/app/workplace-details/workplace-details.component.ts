import {Component, Input, OnInit} from '@angular/core';
import {Workplace} from '../workplace';
import {WorkplaceService} from '../workplace.service';
import {WorkplaceListComponent} from '../workplace-list/workplace-list.component';

@Component({
  selector: 'app-workplace-details',
  templateUrl: './workplace-details.component.html',
  styleUrls: ['./workplace-details.component.css']
})
export class WorkplaceDetailsComponent implements OnInit {

  @Input() workplace: Workplace;

  constructor() { }

  ngOnInit() {
    console.log(this.workplace);
  }


}
