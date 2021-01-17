import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApicallsComponent } from './apicalls.component';

describe('ApicallsComponent', () => {
  let component: ApicallsComponent;
  let fixture: ComponentFixture<ApicallsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApicallsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApicallsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
