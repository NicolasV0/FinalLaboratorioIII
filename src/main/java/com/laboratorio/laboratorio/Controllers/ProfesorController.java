package com.laboratorio.laboratorio.Controllers;
import com.laboratorio.laboratorio.Exception.*;
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
    try{
        profesorService.crearProfesor(profesor);
        return new ResponseEntity<>("Creado",HttpStatus.OK);
    }catch (DatosIncompletosException e){
            return new ResponseEntity<>("Datos incompletos " +e,HttpStatus.CONFLICT);
        }
    catch (ProfesorExisteException e){
        return new ResponseEntity<>(" No creado " +e,HttpStatus.CONFLICT);
    }

    }

    @PutMapping("/profesor/{idProfesor}")
    public ResponseEntity<String> modificarProfesor(@PathVariable int idProfesor){
        try {
            profesorService.modificarProfesor(idProfesor);
            return new ResponseEntity<>("Modificacion correcta",HttpStatus.OK);

        }catch (DatosIncompletosException e){
            return new ResponseEntity<>("Datos incorrectos "+e,HttpStatus.BAD_GATEWAY);

        }catch (ListaVacia e){
            return new ResponseEntity<>("No encontrado "+e,HttpStatus.NO_CONTENT);

        }
        catch (ProfesorExisteException e){
            return new ResponseEntity<>("Profesor ya en sistema con ese dni "+e,HttpStatus.CONFLICT);

        }

        catch (ProfesorNoExistente e){
            return new ResponseEntity<>("Profesorno en sistema con ese dni "+e,HttpStatus.NOT_FOUND);

        }
        catch (DatosIncorrectos e){
            return new ResponseEntity<>("Atributos mal ingresados" +e,HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/profesor/{idProfesor}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable int idProfesor) {

        try {
            profesorService.eliminarProfesor(idProfesor);
            return new ResponseEntity<>("Eliminacion correcta", HttpStatus.OK);
        } catch (DatosIncorrectos error) {
            return new ResponseEntity<>("Datos incorrectos", HttpStatus.BAD_GATEWAY);
        }
        catch (ListaVacia e){
            return new ResponseEntity<>("No hay profesores cargados",HttpStatus.NO_CONTENT);
        }
        catch (ProfesorNoExistente e){
            return new ResponseEntity<>("No existe ese profesor",HttpStatus.NOT_FOUND);
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
