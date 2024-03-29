import {ComponentFixture, TestBed} from '@angular/core/testing';

import { ForeigntabComponent } from './foreigntab.component';
describe('ForeigntabComponent', () => {
  let component: ForeigntabComponent;
  let fixture: ComponentFixture<ForeigntabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ForeigntabComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ForeigntabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
