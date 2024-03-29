import {ComponentFixture, TestBed} from '@angular/core/testing';

import { NbouvrierComponent } from './nbouvrier.component';
describe('NbouvrierComponent', () => {
  let component: NbouvrierComponent;
  let fixture: ComponentFixture<NbouvrierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NbouvrierComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NbouvrierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
