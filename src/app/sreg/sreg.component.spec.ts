import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SregComponent } from './sreg.component';

describe('SregComponent', () => {
  let component: SregComponent;
  let fixture: ComponentFixture<SregComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SregComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
