import {ComponentFixture, TestBed} from '@angular/core/testing';

import { QuantitematiereComponent } from './quantitematiere.component';
describe('QuantitematiereComponent', () => {
  let component: QuantitematiereComponent;
  let fixture: ComponentFixture<QuantitematiereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuantitematiereComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(QuantitematiereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
