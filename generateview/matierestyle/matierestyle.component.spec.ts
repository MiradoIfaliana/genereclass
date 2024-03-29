import {ComponentFixture, TestBed} from '@angular/core/testing';

import { MatierestyleComponent } from './matierestyle.component';
describe('MatierestyleComponent', () => {
  let component: MatierestyleComponent;
  let fixture: ComponentFixture<MatierestyleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MatierestyleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MatierestyleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
