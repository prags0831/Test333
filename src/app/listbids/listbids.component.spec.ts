import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListbidsComponent } from './listbids.component';

describe('ListbidsComponent', () => {
  let component: ListbidsComponent;
  let fixture: ComponentFixture<ListbidsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListbidsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListbidsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
