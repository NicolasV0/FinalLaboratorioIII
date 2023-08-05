package com.laboratorio.laboratorio.Models;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private int cantAnios;
    private List<Materia> materiaCarrera;

    public Carrera() {
        this.materiaCarrera = new ArrayList<>();
    }

    public Carrera(String nombre, int cantAnios) {
        this.nombre = nombre;
        this.cantAnios = cantAnios;
        this.materiaCarrera = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantAnios() {
        return cantAnios;
    }

    public void setCantAnios(int cantAnios) {
        this.cantAnios = cantAnios;
    }

    public List<Materia> getMateriaCarrera() {
        return materiaCarrera;
    }

    public void setMateriaCarrera(Materia materia) {
        materiaCarrera.add(materia);
    }
}
