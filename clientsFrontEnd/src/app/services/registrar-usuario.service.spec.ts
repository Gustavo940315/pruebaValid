import { TestBed } from '@angular/core/testing';

import { RegistrarUsuarioService } from './registrar-usuario.service';

describe('RegistrarUsuarioService', () => {
  let service: RegistrarUsuarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistrarUsuarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
