package com.laboratorio.laboratorio.Models;

public class Materia {
    private int materiaId;
    private String nombre;
    private int[] correlatividades;
    private String Profesor;
    private int idProfesor;

    public Materia() {

    }

    public Materia(int materiaId, String nombre, String profesor, int idProfesor,int[] correlatividades) {
        this.materiaId = materiaId;
        this.nombre = nombre;
        Profesor = profesor;
        this.idProfesor = idProfesor;
        this.correlatividades = correlatividades;
    }

    public String getProfesor() {
        return Profesor;
    }

    public void setProfesor(String profesor) {
        Profesor = profesor;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCorrelatividades() {
        return correlatividades;
    }

    public void setCorrelatividades(int[] correlatividades) {
        this.correlatividades = correlatividades;
    }
}
