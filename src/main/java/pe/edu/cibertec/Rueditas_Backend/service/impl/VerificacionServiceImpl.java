package pe.edu.cibertec.Rueditas_Backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Rueditas_Backend.dto.PlacaRequestDTO;
import pe.edu.cibertec.Rueditas_Backend.service.VerificacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class VerificacionServiceImpl implements VerificacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] mostrarDatos(PlacaRequestDTO placaRequestDTO) throws IOException {

        String[] datosPlaca = null;
        Resource resource = resourceLoader.getResource("classpath:datos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){

            String linea;
            while ((linea = br.readLine()) !=null){

                String[] datos = linea.split(";");
                if (placaRequestDTO.numero().equals(datos[1])){

                    datosPlaca = new String[5];
                    datosPlaca[0] = datos[2];
                    datosPlaca[1] = datos[3];
                    datosPlaca[2] = datos[4];
                    datosPlaca[3] = datos[5];
                    datosPlaca[4] = datos[6];


                }

            }

        }catch (IOException e){
            datosPlaca = null;
            throw new IOException(e);
        }

        return datosPlaca;
    }
}
