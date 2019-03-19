import {Component, Input, OnInit} from '@angular/core';
import {Workplace} from '../workplace';
import {Observable} from 'rxjs';
import {WorkplaceService} from '../workplace.service';

@Component({
  selector: 'app-workplace-list',
  templateUrl: './workplace-list.component.html',
  styleUrls: ['./workplace-list.component.css']
})
export class WorkplaceListComponent implements OnInit {

  workplaces: Observable<Workplace[]>;

  constructor(private workplaceService: WorkplaceService) { }

  ngOnInit() {
    this.reloadData();
    console.log(this.workplaces);
  }


  reloadData() {
    this.workplaces = this.workplaceService.getWorkplacesList();
  }

}
