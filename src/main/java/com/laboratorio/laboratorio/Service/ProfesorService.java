package com.laboratorio.laboratorio.Service;
import com.laboratorio.laboratorio.DAO.ProfesorDAO;
import com.laboratorio.laboratorio.Exception.DatosIncompletosException;
import com.laboratorio.laboratorio.Exception.DatosIncorrectos;
import com.laboratorio.laboratorio.Models.Materia;
import com.laboratorio.laboratorio.Models.Profesor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfesorService {
    public ProfesorService() {
    }

    public void crearProfesor(Profesor profesor) throws RuntimeException{
        validarDatos(profesor);
        ProfesorDAO profesorDAO = new ProfesorDAO();
        profesorDAO.crearProfesor(profesor);

    }

    public List<Profesor> getProfesores(){

        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.getProfesores();
    }


    public void modificarProfesor(int id)  throws RuntimeException{
        if (id == 0 || id <= 0){
            throw new DatosIncompletosException("ID no puede ser 0 o menor");
        }
        ProfesorDAO profesorDAO = new ProfesorDAO();
        profesorDAO.modificarProfesor(id);

    }

    public boolean eliminarProfesor(int id) throws RuntimeException{
        if (id == 0 || id <= 0){
            throw new DatosIncorrectos("Id no puede ser menor igual que 0");
        }
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.eliminarProfesor(id);
    }

    public List<Materia> listaMaterias(Profesor profesor){
        ProfesorDAO profesorDAO = new ProfesorDAO();
        validarDatos(profesor);
        return profesorDAO.listaMateria(profesor);
        }


    private void validarDatos (Profesor profesor) throws RuntimeException{


        if (profesor.getNombre().isEmpty() || profesor.getNombre() == null){
            throw new DatosIncompletosException("Name is required");
        } else if (profesor.getApellido().isEmpty() || profesor.getApellido() == null){
            throw new DatosIncompletosException("LastName is required");
        }
        else if (profesor.getId() ==0 || (profesor.getId() <= 0) ){
            throw new DatosIncompletosException("ID is required");
        }
        else if (profesor.getDni() ==0 || (profesor.getDni() <= 0) ){
            throw new DatosIncompletosException("Dni is required");
        }
    }


    }




