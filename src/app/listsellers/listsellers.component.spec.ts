import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListsellersComponent } from './listsellers.component';

describe('ListsellersComponent', () => {
  let component: ListsellersComponent;
  let fixture: ComponentFixture<ListsellersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListsellersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListsellersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
