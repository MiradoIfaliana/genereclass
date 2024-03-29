import {ComponentFixture, TestBed} from '@angular/core/testing';

import { PrixventeComponent } from './prixvente.component';
describe('PrixventeComponent', () => {
  let component: PrixventeComponent;
  let fixture: ComponentFixture<PrixventeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrixventeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PrixventeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
