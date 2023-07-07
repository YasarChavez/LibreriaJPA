package org.libreria;

import entidad.Libro;
import servicio.AutorService;
import servicio.LibroService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LibroService libroService = new LibroService();
        AutorService autorService = new AutorService();


//        autorService.cargarAutor();
//        Búsqueda de un Autor por nombre.
//        autorService.buscarPorNombre();
//        libroService.cargarLibro();
//        Búsqueda de un libro por Título.
//        libroService.buscarPorNombre();
//        libroService.listarTodos();
//        Búsqueda de un libro por ISBN.
//        libroService.buscarPorISBN();
//        libroService.buscarLibroPorAutor();
    }
}
