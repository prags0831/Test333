import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlacebidsComponent } from './placebids.component';

describe('PlacebidsComponent', () => {
  let component: PlacebidsComponent;
  let fixture: ComponentFixture<PlacebidsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlacebidsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlacebidsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
