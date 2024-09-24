package pe.edu.cibertec.Rueditas_Backend.service;

import pe.edu.cibertec.Rueditas_Backend.dto.PlacaRequestDTO;

import java.io.IOException;

public interface VerificacionService {

    String[] mostrarDatos(PlacaRequestDTO placaRequestDTO) throws IOException;

}
