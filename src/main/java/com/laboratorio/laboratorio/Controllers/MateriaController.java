package com.laboratorio.laboratorio.Controllers;
import com.laboratorio.laboratorio.Models.Alumno;
import com.laboratorio.laboratorio.Models.Materia;
import com.laboratorio.laboratorio.Service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MateriaController {
    @Autowired
    private MateriaService materiaService;


    @GetMapping("/materias")
    @ResponseStatus(HttpStatus.OK)
    public List<Materia> getMaterias(){
        return materiaService.getMaterias();
    }
    @PostMapping("/materia")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> crearMateria (@RequestBody Materia materia){
        if (materiaService.crearMateria(materia) == true){
            return new ResponseEntity<>("Creado",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
        }
    }

}
