package com.laboratorio.laboratorio.DAO;

import com.laboratorio.laboratorio.Exception.AlumnoExistenteException;
import com.laboratorio.laboratorio.Exception.DatosIncorrectos;
import com.laboratorio.laboratorio.Exception.ListaVacia;
import com.laboratorio.laboratorio.Models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AlumnoDAOImpl implements AlumnoDAO{
    static List<Alumno> listaAlumnos = new ArrayList<>();
    static int id = 0;
    Scanner scanner2 = new Scanner(System.in);
    public AlumnoDAOImpl() {

    }

    public void crearAlumno(Alumno alumno) throws RuntimeException{
        Alumno alumno1 = new Alumno();
        alumno1.setNombre(alumno.getNombre());
        alumno1.setApellido(alumno.getApellido());
        alumno1.setId(id+=1);
        alumno1.setDni(alumno.getDni());
        alumno1.setPassword(alumno.getPassword());
        CarreraDAO carreraDAO = new CarreraDAO();
        alumno1.setCarrera(carreraDAO.obtenerCarrera(alumno.getCarrera()));
        buscarAlumnoDni(alumno1.getDni());
        for (Materia mat:alumno1.getCarrera().getMateriaCarrera()) {
            for (Integer correlatividad:mat.getCorrelatividades()) {
                if (correlatividad.equals(0)){
                    Asignatura asignatura = new Asignatura();
                    asignatura.setMateria(mat);
                    asignatura.setEstado(EstadoAsignatura.NO_CURSADA);
                    asignatura.setNota(0);
                    alumno1.agregarAsignatura(asignatura);
                }

            }

        }

        listaAlumnos.add(alumno1);
    }

    public void modificarAlumno(int id) throws RuntimeException {
        int opcion2;
        if (listaAlumnos.isEmpty()) {
            throw new ListaVacia("No hay ninguna alumno ingresado");
        }
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getId() == id) {
            }
            while (true) {
                System.out.println("Que atributo desea cambiar de Alumno");
                System.out.println("1)Nombre");
                System.out.println("2)Apellido");
                System.out.println("3)Dni");
                System.out.println("4)Password");
                System.out.println("5)Salir");
                opcion2 = scanner2.nextInt();


                if (opcion2 == 1) {
                    System.out.println("Nombre nuevo: ");
                    String nombre = scanner2.next();
                    if (nombre == ""){
                        throw new DatosIncorrectos("Nombre no puede estar vacio");
                    }
                    alumno.setNombre(nombre);

                } else if (opcion2 == 2) {
                    System.out.println("Apellido nuevo: ");
                    String apellido = scanner2.next();
                    if (apellido == ""){
                        throw new DatosIncorrectos("Apellido no puede estar vacio");
                    }
                    alumno.setApellido(apellido);

                } else if (opcion2 == 3) {
                    System.out.println("Dni nuevo: ");
                    int dni = scanner2.nextInt();
                    buscarAlumnoDni(dni);
                    alumno.setDni(dni);
                } else if (opcion2 == 4) {
                    System.out.println("Password nuevo: ");
                    String pass = scanner2.next();
                    if (pass == ""){
                        throw new DatosIncorrectos("Password no puede estar vacio");
                    }
                    alumno.setPassword(pass);
                } else if (opcion2 == 5) {
                    return;
                }

            }
        }
    }


    public void modificarAsigAlumno(int id, int idAsig){
        int op;
        for (Alumno alumno:listaAlumnos) {
            if (alumno.getId() == id){
                for (Asignatura asignatura:alumno.getAsignaturas()) {
                    if (asignatura.getMateria().getMateriaId() == idAsig){
                        while (true){
                            System.out.println("Que desea modificar de asigntura?");
                            System.out.println("1)Estado");
                            System.out.println("2)Nota");
                            System.out.println("3)Salir");
                            op = scanner2.nextInt();
                            if (op == 1){
                                System.out.println("Estado actual: " + asignatura.getEstado());
                                System.out.println("Nuevo estado(NO_CURSADA/APROBADA/CURSADA)");
                                String estado = scanner2.next();
                                if (estado.toUpperCase().equals("NO_CURSADA")){
                                    asignatura.setEstado(EstadoAsignatura.NO_CURSADA);
                                    asignatura.setNota(0);
                                } else if (estado.toUpperCase().equals("APROBADA")){
                                    asignatura.setEstado(EstadoAsignatura.APROBADA);
                                    asignatura.setNota(0);
                                } else if (estado.toUpperCase().equals("CURSADA")){
                                    asignatura.setEstado(EstadoAsignatura.CURSADA);
                                }
                            } else if (op == 2) {
                                if (asignatura.getEstado().equals(EstadoAsignatura.NO_CURSADA)){
                                    System.err.println("No se puede poner nota a una asignatura no aprobada");
                                } else if (asignatura.getEstado().equals(EstadoAsignatura.CURSADA)){
                                    System.err.println("No se puede poner nota a una asignatura no aprobada");
                                }
                                else {
                                    System.out.println("Nota: " );
                                    int nota = scanner2.nextInt();
                                    asignatura.setNota(nota);
                                }
                            } else if (op == 3) {
                                return;
                            }
                        }
                    }
                }
                System.out.println("Asignatura no encontrada");
            }
        }
        System.out.println("Alumno no encontrado");
    }

    public void agregarAsigaAlumno(int id,int idasig){
        for (Alumno alumno:listaAlumnos) {
            if (alumno.getId() == id){
                for (Materia mat:alumno.getCarrera().getMateriaCarrera()) {
                    if (mat.getMateriaId() == idasig){
                        for (Integer cor:mat.getCorrelatividades()) {
                            for (Asignatura asigCo:alumno.getAsignaturas()) {
                                if (asigCo.getMateria().getMateriaId() == idasig){
                                    System.err.println("Asignatura ya cargada");
                                    return;
                                }
                                if (asigCo.getMateria().getMateriaId() == cor){
                                    if (asigCo.getEstado().equals(EstadoAsignatura.NO_CURSADA) || asigCo.getEstado().equals(EstadoAsignatura.CURSADA)){
                                        System.err.println("No cumple correlatividades");
                                        return;
                                    }
                                }
                            }
                        }
                        Asignatura asignatura = new Asignatura(mat);
                        alumno.setAsignaturas(asignatura);
                        return;
                    }

                }
            }
        }
    }

    @Override
    public List<Alumno> getAlumno() {
        return listaAlumnos;
    }

    @Override
    public boolean eliminar(int id) {
        for (int i = 0; i< listaAlumnos.size(); i++){
            if (listaAlumnos.get(i).getId() == id){
                listaAlumnos.remove(i);
                return true;

            }
        }
        return false;
    }



    private void buscarAlumnoDni(int dni) throws RuntimeException{
        for (Alumno al:listaAlumnos) {
            if (al.getDni().equals(dni)){
                throw new AlumnoExistenteException("Alumno ya creado");
            }
        }
    }
}
