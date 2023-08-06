package com.laboratorio.laboratorio.DAO;

import com.laboratorio.laboratorio.Models.Carrera;
import com.laboratorio.laboratorio.Models.Materia;

import java.util.ArrayList;
import java.util.List;

public class CarreraDAO {
    private final int topeProgramacion = 20;
    private final int topeElectronica = 40;
    static Carrera carrera1 = new Carrera("Tecnicatura en Programacion",2);
    static Carrera carrera2 = new Carrera("Ing. Electronica",4);
    static List<Materia> listaTecnicatura = new ArrayList<>();
    static List<Materia> listaIngElectronica = new ArrayList<>();

    public CarreraDAO() {
    }


    public void loadCarreras(){
        List<Materia> listaMaterias = new ArrayList<>();
        MateriaDAO materiaDAO = new MateriaDAO();
        listaMaterias =  materiaDAO.getMaterias();

        for (Materia materia:listaMaterias) {
            if (materia.getMateriaId() < topeProgramacion){
                carrera1.setMateriaCarrera(materia);
                listaTecnicatura.add(materia);
            }
            if (materia.getMateriaId()>=topeProgramacion && materia.getMateriaId()<topeElectronica) {
                carrera2.setMateriaCarrera(materia);
                listaIngElectronica.add(materia);
            }
        }
    }

    public Carrera obtenerCarrera(Carrera carrera){
        if (carrera.getNombre().equals(carrera1.getNombre())){
            return carrera1;
        }
        if (carrera.getNombre().equals(carrera2.getNombre())){
            return carrera2;
        }
        return null;
    }

}
