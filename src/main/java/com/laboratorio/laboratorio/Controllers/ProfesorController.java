package com.laboratorio.laboratorio.Controllers;
import com.laboratorio.laboratorio.Models.Materia;
import com.laboratorio.laboratorio.Models.Profesor;
import com.laboratorio.laboratorio.Service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;


    @PostMapping("/profesor")
    public ResponseEntity<String> crearProfesor (@RequestBody Profesor profesor){
        if (profesorService.crearProfesor(profesor) == true){
            return new ResponseEntity<>("Creado",HttpStatus.OK);
        }else {
            return new ResponseEntity<>(" No creado",HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/profesor/{idProfesor}")
    public ResponseEntity<String> modificarProfesor(@PathVariable int idProfesor){
        if (profesorService.modificarProfesor(idProfesor) == true){
            return new ResponseEntity<>("Modificacion correcta",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Datos incorrectos",HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/profesor/{idProfesor}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable int idProfesor){
        if (profesorService.eliminarProfesor(idProfesor) == true){
            return new ResponseEntity<>("Eliminacion correcta",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Datos incorrectos",HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("profesores")
    @ResponseStatus(HttpStatus.OK)
    public List<Profesor> getProfesores(){
        return profesorService.getProfesores();
    }

    @GetMapping("profesor/materias")
    @ResponseStatus(HttpStatus.OK)
    public List<Materia> listaMaterias(@RequestBody Profesor profesor){
        return profesorService.listaMaterias(profesor);
    }
}
