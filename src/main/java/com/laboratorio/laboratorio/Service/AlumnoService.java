package com.laboratorio.laboratorio.Service;

import com.laboratorio.laboratorio.DAO.AlumnoDAOImpl;
import com.laboratorio.laboratorio.Exception.DatosIncompletosException;
import com.laboratorio.laboratorio.Exception.DatosIncorrectos;
import com.laboratorio.laboratorio.Models.Alumno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    public void crearAlumno(Alumno alumno) throws RuntimeException{
        validarDatos(alumno);
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        alumnoDAO.crearAlumno(alumno);
    }

    public List<Alumno> getAlumnos(){
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        return alumnoDAO.getAlumno();
    }
    public boolean eliminar(int id){
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        return alumnoDAO.eliminar(id);
    }

    public void modificarAlumno(int id) throws RuntimeException{
        if (id<=0 ){
            throw new DatosIncorrectos("Id no puede ser =< 0");
        }
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        alumnoDAO.modificarAlumno(id);
    }

    public void modificarAsigAlumn(int id, int idAsig){
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        alumnoDAO.modificarAsigAlumno(id,idAsig);
    }

    public void agregarAsigaAlumno(int id,int idasig){
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        alumnoDAO.agregarAsigaAlumno(id,idasig);
    }

    private void validarDatos(Alumno alumno) throws RuntimeException{
        if (alumno.getNombre().isEmpty()){
            throw new  DatosIncompletosException("Name is required");
        } else if (alumno.getApellido().isEmpty()){
            throw new  DatosIncompletosException("LastName is required");
        } else if (alumno.getPassword().isEmpty()){
            throw new  DatosIncompletosException("Password is required");
        } else if (alumno.getDni().toString() == "" || alumno.getDni() == null){
            throw new  DatosIncompletosException("Dni is required");
        } else if (alumno.getCarrera().equals("") || alumno.getCarrera() == null){
            throw new  DatosIncompletosException("Carrer is required");
        }

        if (alumno.getDni() == 0 || alumno.getDni() <=0){
            throw new DatosIncorrectos("Dni no puede ser <=0");
        }

    }
}
