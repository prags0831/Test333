import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListcustomersComponent } from './listcustomers.component';

describe('ListcustomersComponent', () => {
  let component: ListcustomersComponent;
  let fixture: ComponentFixture<ListcustomersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListcustomersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListcustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
