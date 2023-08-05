package com.laboratorio.laboratorio.Service;

import com.laboratorio.laboratorio.DAO.ProfesorDAO;
import com.laboratorio.laboratorio.Models.Materia;
import com.laboratorio.laboratorio.Models.Profesor;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService {
    public ProfesorService() {
    }

    public boolean crearProfesor(Profesor profesor){
        if (validarDatos(profesor) == true){
            ProfesorDAO profesorDAO = new ProfesorDAO();
            return profesorDAO.crearProfesor(profesor);
        }else {
            return false;
        }
    }

    public List<Profesor> getProfesores(){
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.getProfesores();
    }


    public boolean modificarProfesor(int id){
        if (id == 0){
            return false;
        }
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.modificarProfesor(id);

    }

    public boolean eliminarProfesor(int id){
        if (id == 0){
            return false;
        }
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.eliminarProfesor(id);
    }

    public List<Materia> listaMaterias(Profesor profesor){
        ProfesorDAO profesorDAO = new ProfesorDAO();
        if (validarDatos(profesor) == true){
            return profesorDAO.listaMateria(profesor);
        }
        return null;
    }


    private boolean validarDatos(Profesor profesor) {
        if (profesor.getNombre().isEmpty() || profesor.getNombre() == null){
            return false;
        } else if (profesor.getApellido().isEmpty() || profesor.getApellido() == null){
            return false;
        }
        else if (profesor.getApellido().isEmpty() || profesor.getApellido() == null){
            return false;
        }
        else {
            return true;
        }
    }



    }




