package org.libreria;

import entidad.Libro;
import servicio.LibroService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LibroService libroService = new LibroService();

        libroService.buscarPorNombre();
//        libroService.cargarLibro();
//        libroService.listarTodos();
    }
}
