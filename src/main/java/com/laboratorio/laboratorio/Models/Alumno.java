package com.laboratorio.laboratorio.Models;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private String password;
    private Integer dni;
    private Integer id;
    private Carrera carrera;
    private List<Asignatura> asignaturas;

    public Alumno() {
        this.asignaturas = new ArrayList<>();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void agregarAsignatura(Asignatura asignatura){
        asignaturas.add(asignatura);
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void listarAsignaturas(){
        for (Asignatura asignatura:asignaturas) {
            System.out.println(asignatura);

        }
    }



    public Integer getId() {
        return id;
    }

    public void setAsignaturas (Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password + '\'' +
                ", dni=" + dni +
                ", id=" + id +'}';
    }
}
