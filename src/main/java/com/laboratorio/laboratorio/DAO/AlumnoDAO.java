package com.laboratorio.laboratorio.DAO;

import com.laboratorio.laboratorio.Models.Alumno;

import java.util.List;

public interface AlumnoDAO {


    public List<Alumno> getAlumno();
    public void crearAlumno(Alumno alumno);
    public boolean eliminar(int id);
}
