package crud.restapi.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crud.restapi.models.EmpleadoModel;
import crud.restapi.services.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @PostMapping()
    public EmpleadoModel guardarEmpleado(@RequestBody EmpleadoModel empleado) {
        return this.empleadoService.guardarEmpleado(empleado);
    }
    
    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleados() {
        return empleadoService.obtenerEmpleado();
    }

    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> obtenerEmpleadoPorID(@PathVariable("id") Long id) {
        return this.empleadoService.buscarPorID(id);
    }

    @GetMapping("/query")
    public ArrayList<EmpleadoModel> obtenerEmpleadoPorNombre(@RequestParam("nombre") String nombre) {
        return this.empleadoService.buscarPorNombre(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String elimianrEmpleadoPorID(@PathVariable("id") Long id) {
        boolean status = this.empleadoService.eliminarEmpleado(id);
        if (status) {
            return "Empleado eliminado con el id: " + id;
        } else {
            return "No se pudo eliminar el emplado con el id: " + id;
        }
    }
}
