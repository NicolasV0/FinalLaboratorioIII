package com.laboratorio.laboratorio.DAO;

import com.laboratorio.laboratorio.Models.Materia;
import com.laboratorio.laboratorio.Models.Profesor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProfesorDAO {
    static List<Profesor> listaProfesores = new ArrayList<>();

    public ProfesorDAO() {
    }

    public List<Profesor> getProfesores(){
        return listaProfesores;
    }

    public List<Materia> listaMateria(Profesor profesor){
        for (Profesor prof:listaProfesores) {
            if (prof.getDni() == profesor.getDni()){
                 Collections.sort(prof.getMateriasDictadas(), (Materia a, Materia b) ->a.getNombre().compareTo(b.getNombre()));
                 return prof.getMateriasDictadas();
            }
        }
        return null;
    }

    public boolean crearProfesor(Profesor profesor){

        for (Profesor x:listaProfesores) {
            if (x.getDni() == profesor.getDni()){
                return false;
            }
        }
        Profesor profesor1 = new Profesor();
        profesor1.setNombre(profesor.getNombre());
        profesor1.setApellido(profesor.getApellido());
        profesor1.setId(profesor.getId());
        profesor1.setDni(profesor.getDni());
        listaProfesores.add(profesor1);
        return true;
    }

    public boolean modificarProfesor(int id){
        int opcion;
        Scanner scanner = new Scanner(System.in);
        if (validarProfesor(id) == true){
            while (true){
                System.out.println("Que atributo desea cambiar de profesor");
                System.out.println("1)Nombre");
                System.out.println("2)Apellido");
                System.out.println("3)Dni");
                System.out.println("4)Salir");
                opcion = scanner.nextInt();
                if (opcion == 1){
                    System.out.println("Nombre nuevo: ");
                    String nombre = scanner.next();
                    for (Profesor profe:listaProfesores) {
                        if (profe.getId() == id){
                            profe.setNombre(nombre);
                            for (Materia materia: profe.getMateriasDictadas()) {
                                String[] cadena = materia.getProfesor().split(" ");
                                String apellido = cadena[1];
                                materia.setProfesor(nombre +" "+ apellido);
                            }
                        }
                    }

                } else if (opcion == 2){
                    System.out.println("Apellido nuevo: ");
                    String apellido = scanner.next();
                    for (Profesor profe:listaProfesores) {
                        if (profe.getId() == id){
                            profe.setApellido(apellido);
                            for (Materia materia: profe.getMateriasDictadas()) {
                                String[] cadena = materia.getProfesor().split(" ");
                                String nombre = cadena[0];
                                materia.setProfesor(nombre +" "+ apellido);
                            }
                        }
                    }
                }else if (opcion == 3){
                    System.out.println("Dni nuevo: ");
                    int dni = scanner.nextInt();
                    for (Profesor profe:listaProfesores) {
                        if (profe.getId() == id){
                            profe.setDni(dni);
                        }
                    }

                }
                 else if (opcion == 4) {
                    return true;
                }

            }


        }

        return false;
    }

    public boolean eliminarProfesor(int id){
        if (validarProfesor(id) == true){
            for (Profesor profesor:listaProfesores) {
                if (profesor.getId() == id){
                    for (Materia materia: profesor.getMateriasDictadas()) {
                        materia.setIdProfesor(0);
                        materia.setProfesor("");
                    }
                    listaProfesores.remove(profesor);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean validarProfesor(int id){
        if (listaProfesores.isEmpty()) {
            return false;
        }
        for (Profesor profe:listaProfesores) {
            if (profe.getId() == id){
                return true;
            }
        }
        return false;
    }


}
