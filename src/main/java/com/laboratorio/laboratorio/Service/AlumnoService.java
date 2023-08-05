package com.laboratorio.laboratorio.Service;

import com.laboratorio.laboratorio.DAO.AlumnoDAOImpl;
import com.laboratorio.laboratorio.Models.Alumno;
import com.laboratorio.laboratorio.Models.Asignatura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    public void crearAlumno(Alumno alumno){
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

    public void modificarAlumno(int id){
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        alumnoDAO.modificarAlumno(id);
    }

    public Asignatura consultarAsigAlumn(int id, int idAsig){
        AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl();
        return alumnoDAO.consultarAsigAlumno(id,idAsig);
    }
}
