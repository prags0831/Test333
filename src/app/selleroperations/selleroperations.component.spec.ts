import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelleroperationsComponent } from './selleroperations.component';

describe('SelleroperationsComponent', () => {
  let component: SelleroperationsComponent;
  let fixture: ComponentFixture<SelleroperationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelleroperationsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelleroperationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
