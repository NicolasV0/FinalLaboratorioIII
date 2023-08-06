package com.laboratorio.laboratorio.Controllers;

import com.laboratorio.laboratorio.DAO.MateriaDAO;
import com.laboratorio.laboratorio.Service.CarreraServic;
import com.laboratorio.laboratorio.Service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarreraController {

    @Autowired
    private CarreraServic carreraServic;


    @PostMapping("/carreras/load")
    public ResponseEntity<String> loadCarreras (){
        CarreraServic.loadCarreras();
        return new ResponseEntity<>("Carreras creadas", HttpStatus.OK);
    }

}
