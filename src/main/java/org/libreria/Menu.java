package org.libreria;

import servicio.*;

import java.util.Scanner;

public class Menu {
    public static void menu() throws InterruptedException {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorService autorService = new AutorService();
        EditorialService editorialService = new EditorialService();
        LibroService libroService = new LibroService();
        PrestamoService prestamoService = new PrestamoService();
        ClienteService clienteService = new ClienteService();

        int opcion = -1;
        do {
            System.out.println();
            System.out.println("1. Gestión de Autores");
            System.out.println("2. Gestión de Editoriales");
            System.out.println("3. Gestión de Libros");
            System.out.println("4. Gestión de Clientes");
            System.out.println("5. Gestión de Prestamos");
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
                case 4:
                    gestionCliente(clienteService, leer);
                    break;
                case 5:
                    gestionPrestamo(prestamoService, leer);
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

    private static void gestionLibros(LibroService libroService, Scanner leer) throws InterruptedException {
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

    public static void gestionCliente(ClienteService clienteService, Scanner leer) {
        int opcion = -1;
        do {
            System.out.println();
            System.out.println("----- GESTIÓN DE CLIENTES -----");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Buscar Cliente Por Documento");
            System.out.println("0. Volver al Menú Principal");
            try {
                opcion = leer.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.fillInStackTrace());
                leer.next();
            }
            switch (opcion) {
                case 1:
                    clienteService.crearCliente();
                    break;
                case 2:
                    clienteService.listarClientes();
                    break;
                case 3:
                    clienteService.buscarClientePorDocumento();
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

    public static void gestionPrestamo(PrestamoService prestamoService, Scanner leer) {
        int opcion = -1;
        do {
            System.out.println();
            System.out.println("----- GESTIÓN DE PRESTAMOS -----");
            System.out.println("1. Agregar Prestamo");
            System.out.println("2. Listar Prestamos por Cliente");
            System.out.println("3. Devolver Prestamo");
            System.out.println("4. Listar Prestamos");
            System.out.println("0. Volver al Menú Principal");
            try {
                opcion = leer.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " + e.fillInStackTrace());
                leer.next();
            }
            switch (opcion) {
                case 1:
                    prestamoService.crearPrestamo();
                    break;
                case 2:
                    prestamoService.listarPrestamos();
                    break;
                case 3:
                    prestamoService.devolverPrestamo();
                    break;
                case 4:
                    prestamoService.listarTodosLosPrestamos();
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
