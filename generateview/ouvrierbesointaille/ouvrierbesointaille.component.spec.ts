import {ComponentFixture, TestBed} from '@angular/core/testing';

import { OuvrierbesointailleComponent } from './ouvrierbesointaille.component';
describe('OuvrierbesointailleComponent', () => {
  let component: OuvrierbesointailleComponent;
  let fixture: ComponentFixture<OuvrierbesointailleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OuvrierbesointailleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OuvrierbesointailleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
