import {ComponentFixture, TestBed} from '@angular/core/testing';

import { OuvrierbesoinComponent } from './ouvrierbesoin.component';
describe('OuvrierbesoinComponent', () => {
  let component: OuvrierbesoinComponent;
  let fixture: ComponentFixture<OuvrierbesoinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OuvrierbesoinComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OuvrierbesoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
