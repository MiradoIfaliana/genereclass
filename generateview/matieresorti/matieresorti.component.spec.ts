import {ComponentFixture, TestBed} from '@angular/core/testing';

import { MatieresortiComponent } from './matieresorti.component';
describe('MatieresortiComponent', () => {
  let component: MatieresortiComponent;
  let fixture: ComponentFixture<MatieresortiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MatieresortiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MatieresortiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
