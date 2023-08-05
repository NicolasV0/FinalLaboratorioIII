package com.laboratorio.laboratorio.DAO;

import com.laboratorio.laboratorio.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.laboratorio.laboratorio.DAO.CarreraDAO.listaTecnicatura;
import static com.laboratorio.laboratorio.DAO.MateriaDAO.listaMaterias;

public class AlumnoDAOImpl implements AlumnoDAO{
    static List<Alumno> listaAlumnos = new ArrayList<>();
    static int id = 0;

    public AlumnoDAOImpl() {

    }

    public void crearAlumno(Alumno alumno){
        Alumno alumno1 = new Alumno();
        alumno1.setNombre(alumno.getNombre());
        alumno1.setApellido(alumno.getApellido());
        alumno1.setId(id+=1);
        alumno1.setDni(alumno.getDni());
        alumno1.setPassword(alumno.getPassword());
        CarreraDAO carreraDAO = new CarreraDAO();
        alumno1.setCarrera(carreraDAO.obtenerCarrera(alumno.getCarrera()));




        listaAlumnos.add(alumno1);
    }

    public void modificarAlumno(int id) {
        Scanner scanner2 = new Scanner(System.in);
        int opcion2;
        if (listaAlumnos.isEmpty()) {
            System.out.println("no se ingreso ninguna alumno todavia");
            return;
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
                    alumno.setNombre(nombre);

                } else if (opcion2 == 2) {
                    System.out.println("Apellido nuevo: ");
                    String apellido = scanner2.next();
                    alumno.setApellido(apellido);

                } else if (opcion2 == 3) {
                    System.out.println("Dni nuevo: ");
                    int dni = scanner2.nextInt();
                    alumno.setDni(dni);
                } else if (opcion2 == 4) {
                    System.out.println("Password nuevo: ");
                    String pass = scanner2.next();
                    alumno.setPassword(pass);
                } else if (opcion2 == 5) {
                    return;
                }

            }
        }
    }


    public Asignatura consultarAsigAlumno(int id, int idAsig){
        for (Alumno alumno:listaAlumnos) {
            if (alumno.getId() == id){
                for (int i=0; i<=alumno.getAsignaturas().size();i++){
                    if (alumno.getAsignaturas().get(i).getMateria().getMateriaId() == idAsig){
                        return alumno.getAsignaturas().get(i);
                    }
                }
                System.out.println("Materia no encontrada");
            }
        }
        System.out.println("Alumno no encontrado");
        return null;
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
}
