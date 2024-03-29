import {ComponentFixture, TestBed} from '@angular/core/testing';

import { MatiereentreComponent } from './matiereentre.component';
describe('MatiereentreComponent', () => {
  let component: MatiereentreComponent;
  let fixture: ComponentFixture<MatiereentreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MatiereentreComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MatiereentreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
