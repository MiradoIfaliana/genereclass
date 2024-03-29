import {ComponentFixture, TestBed} from '@angular/core/testing';

import { ProfilborneComponent } from './profilborne.component';
describe('ProfilborneComponent', () => {
  let component: ProfilborneComponent;
  let fixture: ComponentFixture<ProfilborneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilborneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilborneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
