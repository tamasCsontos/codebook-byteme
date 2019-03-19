import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkplaceDetailsComponent } from './workplace-details.component';

describe('WorkplaceDetailsComponent', () => {
  let component: WorkplaceDetailsComponent;
  let fixture: ComponentFixture<WorkplaceDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkplaceDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkplaceDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
