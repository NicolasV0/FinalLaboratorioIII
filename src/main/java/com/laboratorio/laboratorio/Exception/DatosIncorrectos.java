package com.laboratorio.laboratorio.Exception;

public class DatosIncorrectos extends RuntimeException{
    public DatosIncorrectos(String message) {
        super(message);
    }

    public DatosIncorrectos(String message, Throwable cause) {
        super(message, cause);
    }
}
