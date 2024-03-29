import {ComponentFixture, TestBed} from '@angular/core/testing';

import { OrigintabComponent } from './origintab.component';
describe('OrigintabComponent', () => {
  let component: OrigintabComponent;
  let fixture: ComponentFixture<OrigintabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrigintabComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OrigintabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
