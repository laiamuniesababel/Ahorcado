package es.neesis.annotations.services;

import org.springframework.stereotype.Service;

@Service
public class GeneradorPalabras implements IPalabras{

    private String[] palabras = {"elefante", "universidad", "tren", "mariposa", "perro", "bicicleta", "llave", "guitarra", "nube", "caballo"};
    @Override
    public String generarPalabra() {
        int indice = (int) (Math.random() * palabras.length);
        return palabras[indice];
    }
}
