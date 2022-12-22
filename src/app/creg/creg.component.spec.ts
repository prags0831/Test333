import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CregComponent } from './creg.component';

describe('CregComponent', () => {
  let component: CregComponent;
  let fixture: ComponentFixture<CregComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CregComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
