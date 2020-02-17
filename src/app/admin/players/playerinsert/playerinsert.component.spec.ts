import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerinsertComponent } from './playerinsert.component';

describe('PlayerinsertComponent', () => {
  let component: PlayerinsertComponent;
  let fixture: ComponentFixture<PlayerinsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerinsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerinsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
