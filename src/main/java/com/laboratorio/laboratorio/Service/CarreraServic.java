package com.laboratorio.laboratorio.Service;

import com.laboratorio.laboratorio.DAO.CarreraDAO;
import org.springframework.stereotype.Service;

@Service
public class CarreraServic {
    public CarreraServic() {
    }

    public static void loadCarreras(){
        CarreraDAO carreraDAO = new CarreraDAO();
        carreraDAO.loadCarreras();
    }
}
