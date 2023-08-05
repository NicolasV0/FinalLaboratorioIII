package com.laboratorio.laboratorio.Models;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String nombre;
    private String apellido;
    private int id;
    private int dni;
    private List<Materia> materiasDictadas;

    public Profesor() {
        this.materiasDictadas = new ArrayList<>();
    }

    public List<Materia> getMateriasDictadas() {
        return materiasDictadas;
    }

    public void setMateriasDictadas(Materia materia) {
        materiasDictadas.add(materia);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id=" + id +
                '}';
    }
}
