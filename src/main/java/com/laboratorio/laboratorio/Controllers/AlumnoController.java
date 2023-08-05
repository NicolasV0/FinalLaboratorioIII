package com.laboratorio.laboratorio.Controllers;
import com.laboratorio.laboratorio.Models.Alumno;
import com.laboratorio.laboratorio.Models.Asignatura;
import com.laboratorio.laboratorio.Service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;


    @GetMapping("/alumnos")
    @ResponseStatus(HttpStatus.OK)
    public List<Alumno> getAlumnos(){
        return alumnoService.getAlumnos();
    }
    @PostMapping("/alumno")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearAlumno (@RequestBody Alumno alumno){
        alumnoService.crearAlumno(alumno);
    }

    @PutMapping("/alumno/{id}")
    public void modificarAlumno(@PathVariable int id){
         alumnoService.modificarAlumno(id);
    }

    @GetMapping("/alumno/{id}/asignatura/{idasignatura}")
    public Asignatura consultarAsignauraAlumno(@PathVariable int id, @PathVariable int idasignatura){
        return alumnoService.consultarAsigAlumn(id,idasignatura);
    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<String> eliminarAlumno(@PathVariable int id){
    if (alumnoService.eliminar(id) == true){
        return new ResponseEntity<>("Eliminado",HttpStatus.NO_CONTENT);
    }else {
        return new ResponseEntity<>(id+" No encontrado",HttpStatus.NOT_FOUND);

    }
    }
}
