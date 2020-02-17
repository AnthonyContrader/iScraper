import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerupdateComponent } from './playerupdate.component';

describe('PlayerupdateComponent', () => {
  let component: PlayerupdateComponent;
  let fixture: ComponentFixture<PlayerupdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerupdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
