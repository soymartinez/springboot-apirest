package crud.restapi.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.restapi.models.EmpleadoModel;
import crud.restapi.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    // Crear
    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado) {
        return empleadoRepository.save(empleado);
    }
    
    // Leer
    public ArrayList<EmpleadoModel> obtenerEmpleado() {
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
    }

    // Buscar ID
    public Optional<EmpleadoModel> buscarPorID(Long id) { // Opcional ---> aunque no exista ID
        return empleadoRepository.findById(id);
    }

    // Buscar Nombre
    public ArrayList<EmpleadoModel> buscarPorNombre(String nombre) {
        return empleadoRepository.findByNombre(nombre);
    }
    
    // Eliminar
    public boolean eliminarEmpleado(Long id) {
        try {
            empleadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
