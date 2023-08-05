package com.laboratorio.laboratorio.DAO;
import com.laboratorio.laboratorio.Models.Materia;
import com.laboratorio.laboratorio.Models.Profesor;

import java.util.ArrayList;
import java.util.List;

import static com.laboratorio.laboratorio.DAO.ProfesorDAO.listaProfesores;

public class MateriaDAO {
    static List<Materia> listaMaterias = new ArrayList<>();
    static int id = 0;


    public MateriaDAO() {

    }

    public List<Materia> getMaterias(){
        return listaMaterias;
    }

    public static void cargarMateria() {
        int[] co = {0};
        int[] co1 = {1,2};
        int[] co2 = {3};
        int[] co3 = {1,2,4,5};
        int[] co4 = {3,6};
        int[] co5 = {1,2,4,5,7,8};

        Materia materia1 = new Materia(1, "ProgramacionI", "Coppo", 1,co);
        Materia materia2 = new Materia(2, "LaboratorioI", "Balmaceda", 2,co);
        Materia materia3 = new Materia(3, "Matematica", "Cofre", 3,co);
        Materia materia4 = new Materia(4, "ProgramacionII", "Urzarroz", 4,co1);
        Materia materia5 = new Materia(5, "LaboratorioII", "Torres", 5,co1);
        Materia materia6 = new Materia(6, "MatematicaII", "Cofre", 3,co2);
        Materia materia7 = new Materia(7, "ProgramacionIII", "Urzarroz", 4,co3);
        Materia materia8 = new Materia(8, "LaboratorioIII", "Salotto", 6,co3);
        Materia materia9 = new Materia(9, "MatematicaIII", "Cofre", 3,co4);
        Materia materia10 = new Materia(10, "Base de datos", "Torres", 5, co5);
        Materia materia11 = new Materia(11, "ProgramacionIV", "Urzarroz", 4,co5);
        Materia materia12 = new Materia(12, "LaboratorioIV", "Balmaceda", 2,co5);


        int[] co6 = {20};
        int[] co7 = {21,22};
        int[] co8 = {23};
        int[] co9 = {20,23,24,26};
        Materia materia20 = new Materia(20, "InformaticaI", "Coppo", 1,co);
        Materia materia21 = new Materia(21, "Algebra", "Troilo", 7,co);
        Materia materia22 = new Materia(22, "Analisis", "Cofre", 3,co);
        Materia materia23 = new Materia(23, "FisicaI", "Rodriguez", 8,co);
        Materia materia24 = new Materia(24, "InformaticaII", "Coppo", 1,co6);
        Materia materia25 = new Materia(25, "AnalisisII", "Cofre", 3,co7);
        Materia materia26 = new Materia(26, "FisicaII", "Manquin", 9,co8);
        Materia materia27 = new Materia(27, "Fisica Electronica", "Balmaceda", 2,co9);
        Materia materia28 = new Materia(28, "Analisis de señales y sistemas", "Wunderlich", 10,co9);
        Materia materia29 = new Materia(29, "Teoria de circuitos", "Lamponi", 11,co9);
        Materia materia30 = new Materia(30, "DigitalesI", "Galindez", 12,co9);
        Materia materia31 = new Materia(31, "Electronica aplicada", "Balmaceda", 2,co9);


        listaMaterias.add(materia1);
        listaMaterias.add(materia2);
        listaMaterias.add(materia3);
        listaMaterias.add(materia4);
        listaMaterias.add(materia5);
        listaMaterias.add(materia6);
        listaMaterias.add(materia7);
        listaMaterias.add(materia8);
        listaMaterias.add(materia9);
        listaMaterias.add(materia10);
        listaMaterias.add(materia11);
        listaMaterias.add(materia12);
        listaMaterias.add(materia20);
        listaMaterias.add(materia21);
        listaMaterias.add(materia22);
        listaMaterias.add(materia23);
        listaMaterias.add(materia24);
        listaMaterias.add(materia25);
        listaMaterias.add(materia26);
        listaMaterias.add(materia27);
        listaMaterias.add(materia28);
        listaMaterias.add(materia29);
        listaMaterias.add(materia30);
        listaMaterias.add(materia31);

        for (Materia mat:listaMaterias) {
            for (Profesor prof:listaProfesores) {
                if (prof.getId() == mat.getIdProfesor()){
                    mat.setProfesor(prof.getNombre()+ " "+ prof.getApellido());
                    mat.setIdProfesor(prof.getId());
                    prof.setMateriasDictadas(mat);

                }
            }
        }



    }


    public boolean crearMateria(Materia materia){
        for (Materia x:listaMaterias) {
            if (x.getNombre().equals(materia.getNombre())){
                return false;
            }
        }
        id+=1;
        Materia materia1 = new Materia();
        materia1.setNombre(materia.getNombre());
        materia1.setCorrelatividades(materia.getCorrelatividades());
        materia1.setMateriaId(id);
        for (Profesor prof:listaProfesores) {
            if (prof.getId() == materia.getIdProfesor()){
                materia1.setProfesor(prof.getNombre()+ " "+ prof.getApellido());
                materia1.setIdProfesor(prof.getId());
                prof.setMateriasDictadas(materia1);

            }
        }
        listaMaterias.add(materia1);
        return true;
    }

}
