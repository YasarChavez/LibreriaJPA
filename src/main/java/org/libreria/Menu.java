package org.libreria;

import servicio.AutorService;
import servicio.EditorialService;
import servicio.LibroService;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorService autorService = new AutorService();
        EditorialService editorialService = new EditorialService();
        LibroService libroService = new LibroService();
        int opcion = 0;
        do {
            System.out.println();
            System.out.println("1. Agregar Autor");
            System.out.println("2. Agregar Editorial");
            System.out.println("3. Agregar Libro");
            System.out.println("4. Buscar Autor Por Nombre");
            System.out.println("5. Buscar Autor Por Id");
            System.out.println("6. Listar Autores");
            System.out.println("7. Buscar Editorial Por Nombre");
            System.out.println("8. Buscar Editorial Por Id");
            System.out.println("9. Listar Editoriales");
            System.out.println("10. Buscar Libro Por Nombre");
            System.out.println("11. Buscar Libro Por ISBN");
            System.out.println("12. Buscar Libro Por Autor");
            System.out.println("13. Buscar Libro Por Editorial");
            System.out.println("14. Listar Libros");
            System.out.println("15. Salir");
            try {
                opcion = leer.nextInt();
            }catch (Exception e){
                System.out.println("Error: "+e.fillInStackTrace());
                leer.next();
            }
            switch (opcion) {
                case 1:
                    autorService.cargarAutor();
                    break;
                case 2:
                    editorialService.cargarEditorial();
                    break;
                case 3:
                    libroService.cargarLibro();
                    break;
                case 4:
                    autorService.buscarAutorPorNombre();
                    break;
                case 5:
                    autorService.buscarAutorPorId();
                    break;
                case 6:
                    autorService.listarAutores();
                    break;
                case 7:
                    editorialService.buscarEditorialPorNombre();
                    break;
                case 8:
                    editorialService.buscarEditorialPorId();
                    break;
                case 9:
                    editorialService.listarEditoriales();
                    break;
                case 10:
                    libroService.buscarLibroPorNombre();
                    break;
                case 11:
                    libroService.buscarLibroPorISBN();
                    break;
                case 12:
                    libroService.buscarLibroPorAutor();
                    break;
                case 13:
                    libroService.buscarLibroPorEditorial();
                    break;
                case 14:
                    libroService.listarLibros();
                    break;
                case 15:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 15);
    }
}
