import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SucursalDetailsComponent } from './sucursal-details.component';

describe('SucursalDetailsComponent', () => {
  let component: SucursalDetailsComponent;
  let fixture: ComponentFixture<SucursalDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SucursalDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SucursalDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
