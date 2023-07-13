package org.libreria;

import persistencia.PrestamoDAO;
import servicio.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        AutorService autorService = new AutorService();
        LibroService libroService = new LibroService();
        EditorialService editorialService = new EditorialService();
        ClienteService clienteService = new ClienteService();
        PrestamoService prestamoService = new PrestamoService();
        prestamoService.crearPrestamo();

//        Menu.menu();
    }
}
