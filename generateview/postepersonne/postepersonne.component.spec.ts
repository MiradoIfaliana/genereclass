import {ComponentFixture, TestBed} from '@angular/core/testing';

import { PostepersonneComponent } from './postepersonne.component';
describe('PostepersonneComponent', () => {
  let component: PostepersonneComponent;
  let fixture: ComponentFixture<PostepersonneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PostepersonneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PostepersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
