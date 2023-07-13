package org.libreria;

import servicio.AutorService;
import servicio.EditorialService;
import servicio.LibroService;

import java.util.Scanner;

public class MenuTest {
    public static void menu() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorService autorService = new AutorService();
        EditorialService editorialService = new EditorialService();
        LibroService libroService = new LibroService();

        int opcion = -1;
        do {
            System.out.println();
            System.out.println("1. Gestión de Autores");
            System.out.println("2. Gestión de Editoriales");
            System.out.println("3. Gestión de Libros");
            System.out.println("0. Salir");
            try {
                opcion = leer.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.fillInStackTrace());
                leer.next();
            }
            switch (opcion) {
                case 1:
                    gestionAutores(autorService, leer);
                    break;
                case 2:
                    gestionEditoriales(editorialService, leer);
                    break;
                case 3:
                    gestionLibros(libroService, leer);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void gestionAutores(AutorService autorService, Scanner leer) {
        int opcion = -1;
        do {
            System.out.println();
            System.out.println("----- GESTIÓN DE AUTORES -----");
            System.out.println("1. Agregar Autor");
            System.out.println("2. Buscar Autor Por Nombre");
            System.out.println("3. Buscar Autor Por Id");
            System.out.println("4. Listar Autores");
            System.out.println("5. Autor Alta/Baja");
            System.out.println("6. Modificar Autor");
            System.out.println("0. Volver al Menú Principal");
            try {
                opcion = leer.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.fillInStackTrace());
                leer.next();
            }
            switch (opcion) {
                case 1:
                    autorService.cargarAutor();
                    break;
                case 2:
                    autorService.buscarAutorPorNombre();
                    break;
                case 3:
                    autorService.buscarAutorPorId();
                    break;
                case 4:
                    autorService.listarAutores();
                    break;
                case 5:
                    autorService.altaBajaAutorPorId();
                    break;
                case 6:
                    autorService.modificarAutorPorId();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void gestionEditoriales(EditorialService editorialService, Scanner leer) {
        int opcion = -1;
        do {
            System.out.println();
            System.out.println("----- GESTIÓN DE EDITORIALES -----");
            System.out.println("1. Agregar Editorial");
            System.out.println("2. Buscar Editorial Por Nombre");
            System.out.println("3. Buscar Editorial Por Id");
            System.out.println("4. Listar Editoriales");
            System.out.println("5. Editorial Alta/Baja");
            System.out.println("6. Modificar Editorial");
            System.out.println("0. Volver al Menú Principal");
            try {
                opcion = leer.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.fillInStackTrace());
                leer.next();
            }
            switch (opcion) {
                case 1:
                    editorialService.cargarEditorial();
                    break;
                case 2:
                    editorialService.buscarEditorialPorNombre();
                    break;
                case 3:
                    editorialService.buscarEditorialPorId();
                    break;
                case 4:
                    editorialService.listarEditoriales();
                    break;
                case 5:
                    editorialService.altaBajaEditorialPorId();
                    break;
                case 6:
                    editorialService.modificarEditorialPorId();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 0);
    }

    private static void gestionLibros(LibroService libroService, Scanner leer) {
        int opcion = -1;
        do {
            System.out.println();
            System.out.println("----- GESTIÓN DE LIBROS -----");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Buscar Libro Por Nombre");
            System.out.println("3. Buscar Libro Por ISBN");
            System.out.println("4. Buscar Libro Por Autor");
            System.out.println("5. Buscar Libro Por Editorial");
            System.out.println("6. Listar Libros");
            System.out.println("7. Libro Alta/Baja");
            System.out.println("8. Modificar Libro");
            System.out.println("0. Volver al Menú Principal");
            try {
                opcion = leer.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.fillInStackTrace());
                leer.next();
            }
            switch (opcion) {
                case 1:
                    libroService.cargarLibro();
                    break;
                case 2:
                    libroService.buscarLibroPorNombre();
                    break;
                case 3:
                    libroService.buscarLibroPorISBN();
                    break;
                case 4:
                    libroService.buscarLibroPorAutor();
                    break;
                case 5:
                    libroService.buscarLibroPorEditorial();
                    break;
                case 6:
                    libroService.listarLibros();
                    break;
                case 7:
                    libroService.altaBajaLibroPorISBN();
                    break;
                case 8:
                    libroService.modificarLibroPorISBN();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 0);
    }

}
