package com.laboratorio.laboratorio.Service;

import com.laboratorio.laboratorio.DAO.MateriaDAO;
import com.laboratorio.laboratorio.Models.Materia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {
    public MateriaService() {
    }


    public List<Materia> getMaterias(){
        MateriaDAO materiaDAO = new MateriaDAO();
        return materiaDAO.getMaterias();
    }

    public boolean crearMateria(Materia materia){
        if (validarDatos(materia) == false){
            return false;
        }else {
            MateriaDAO materiaDAO = new MateriaDAO();
            return materiaDAO.crearMateria(materia);
        }


    }

    private boolean validarDatos(Materia materia){
        if (materia.getNombre().isEmpty()){
            return false;
        } else if (materia.getCorrelatividades().length == 0) {
            return false;
        } else if (materia.getProfesor().isEmpty()) {
            return false;
        } else if (materia.getIdProfesor() == 0) {
            return false;
        }else {
            return true;
        }
    }
}
