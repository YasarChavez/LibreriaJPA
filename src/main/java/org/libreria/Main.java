package org.libreria;

import servicio.AutorService;
import servicio.EditorialService;
import servicio.LibroService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LibroService libroService = new LibroService();
        AutorService autorService = new AutorService();
        EditorialService editorialService = new EditorialService();


//        autorService.cargarAutor();
//        Búsqueda de un Autor por nombre.
//        autorService.buscarPorNombre();
//        libroService.cargarLibro();
//        Búsqueda de un libro por Título.
//        libroService.listarTodos();
//        libroService.buscarPorNombre();
//        Búsqueda de un libro por ISBN.
//        libroService.buscarPorISBN();
//        libroService.buscarLibroPorAutor();
//        editorialService.cargarEditorial();
//        editorialService.listarEditoriales();
//        libroService.buscarLibroPorEditorial();
    }
}
