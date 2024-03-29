import {ComponentFixture, TestBed} from '@angular/core/testing';

import { MatiereprixComponent } from './matiereprix.component';
describe('MatiereprixComponent', () => {
  let component: MatiereprixComponent;
  let fixture: ComponentFixture<MatiereprixComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MatiereprixComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MatiereprixComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
