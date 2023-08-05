package com.laboratorio.laboratorio;

import com.laboratorio.laboratorio.DAO.CarreraDAO;
import com.laboratorio.laboratorio.DAO.MateriaDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
@SpringBootApplication
public class LaboratorioApplication {

	public static void main(String[] args) {

		SpringApplication.run(LaboratorioApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		int opcion;
		while (true){
			System.out.println("1)Ingresar profesor");
			System.out.println("2)Ingresar alumno");
			System.out.println("3)Cargar materia");
			System.out.println("4)Cargar carrera");
			System.out.println("5)Salir");
			opcion = scanner.nextInt();
			if (opcion == 1){
				System.out.println("Ingrese profesor desde postman");
			}
			else if (opcion == 2){
				System.out.println("Ingrese alumno desde postman");
			}
			else if (opcion == 3){
				MateriaDAO materiaDAO = new MateriaDAO();
				materiaDAO.cargarMateria();
			} else if (opcion == 4) {
				CarreraDAO carreraDAO = new CarreraDAO();
				carreraDAO.cargarCarreras();
				break;
			}


		}




	}

}
