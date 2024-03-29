import {ComponentFixture, TestBed} from '@angular/core/testing';

import { ProfilupsalaireComponent } from './profilupsalaire.component';
describe('ProfilupsalaireComponent', () => {
  let component: ProfilupsalaireComponent;
  let fixture: ComponentFixture<ProfilupsalaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilupsalaireComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilupsalaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
