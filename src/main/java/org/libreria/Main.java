package org.libreria;

import servicio.AutorService;
import servicio.EditorialService;
import servicio.LibroService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        AutorService autorService = new AutorService();
        LibroService libroService = new LibroService();
        EditorialService editorialService = new EditorialService();
        Menu.menu();
    }
}
