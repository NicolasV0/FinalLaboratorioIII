package com.laboratorio.laboratorio.DAO;

import com.laboratorio.laboratorio.Exception.DatosIncorrectos;
import com.laboratorio.laboratorio.Exception.ListaVacia;
import com.laboratorio.laboratorio.Exception.ProfesorExisteException;
import com.laboratorio.laboratorio.Exception.ProfesorNoExistente;
import com.laboratorio.laboratorio.Models.Materia;
import com.laboratorio.laboratorio.Models.Profesor;

import java.util.*;

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

    public void crearProfesor(Profesor profesor) throws RuntimeException {
        for (Profesor x:listaProfesores) {
            if (x.getDni() == profesor.getDni()){
                throw new ProfesorExisteException("Profesor ya registrado con ese dni");
            }
            if(x.getId() == profesor.getId()){
                throw new ProfesorExisteException("Profesor ya registrado con ese ID");
            }
        }
        Profesor profesor1 = new Profesor();
        profesor1.setNombre(profesor.getNombre());
        profesor1.setApellido(profesor.getApellido());
        profesor1.setId(profesor.getId());
        profesor1.setDni(profesor.getDni());
        listaProfesores.add(profesor1);
    }

    public void modificarProfesor(int id) throws RuntimeException{
        int opcion;
        Scanner scanner = new Scanner(System.in);
        Profesor profesorEncontrado =  validarProfesor(id);
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
                    profesorEncontrado.setNombre(nombre);
                    for (Materia materia: profesorEncontrado.getMateriasDictadas()) {
                        String[] cadena = materia.getProfesor().split(" ");
                        String apellido = cadena[1];
                        materia.setProfesor(nombre +" "+ apellido);
                    }

                } else if (opcion == 2){
                    System.out.println("Apellido nuevo: ");
                    String apellido = scanner.next();
                    profesorEncontrado.setApellido(apellido);
                    for (Materia materia: profesorEncontrado.getMateriasDictadas()) {
                        String[] cadena = materia.getProfesor().split(" ");
                        String nombre = cadena[0];
                        materia.setProfesor(nombre +" "+ apellido);
                    }
                }else if (opcion == 3){
                    System.out.println("Dni nuevo: ");
                    int dni = scanner.nextInt();
                    if (dni <= 0){
                    throw new DatosIncorrectos("DNI no puede ser 0 o menor");
                    }
                    for (Profesor profe:listaProfesores) {
                        if (profe.getDni() == dni){
                            System.err.print("Ya existe un profesor con ese dni");
                            throw new ProfesorExisteException("Ya existe un profesor con ese dni");
                        }
                    }
                    profesorEncontrado.setDni(dni);

                }
                 else if (opcion == 4) {
                    return;
                }
            }
    }

    public boolean eliminarProfesor(int id) throws RuntimeException{
        validarProfesor(id);
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

        return false;
    }

    private Profesor validarProfesor(int id) throws RuntimeException{
        Profesor profEncontrado = null;
        Iterator<Profesor> it = listaProfesores.iterator();
        if (listaProfesores.isEmpty()) {
            throw new ListaVacia("No hay profesores cargados");
        }
        while (it.hasNext() && profEncontrado == null){
            Profesor p = it.next();
            if (p.getId() == id){
                profEncontrado = p;
            }
        }

        if (profEncontrado == null){
            throw new ProfesorNoExistente("No existe el profesor en el sistema");
        }
        return profEncontrado;

    }


}
