import {ComponentFixture, TestBed} from '@angular/core/testing';

import { DureestyleComponent } from './dureestyle.component';
describe('DureestyleComponent', () => {
  let component: DureestyleComponent;
  let fixture: ComponentFixture<DureestyleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DureestyleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DureestyleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
