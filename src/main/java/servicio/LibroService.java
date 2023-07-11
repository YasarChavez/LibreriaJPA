package servicio;

import entidad.Libro;
import persistencia.LibroDAO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibroService {
    private final LibroDAO DAO;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public LibroService() {
        this.DAO = new LibroDAO();
    }

    public void listarLibros() {
        try {
            DAO.listartodos();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void buscarLibroPorNombre() {
        try {
            System.out.println("Ingrese el nombre del libro que desea buscar:");
            String nombre = leer.next();
            DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No se encontró el libro");
        }
    }

    public void buscarLibroPorISBN() {
        try {
            System.out.println("Ingrese el ISBN del libro que desea buscar:");
            long isbn = leer.nextLong();
            DAO.buscarPorISBN(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No se encontrón el libro");
        }
    }

    public void cargarLibro() {
        Libro libro = new Libro();

        System.out.println("Ingrese Titulo:");
        libro.setTitulo(leer.nextLine());

        int anio = 0;
        while (true) {
            try {
                System.out.println("Ingrese año:");
                anio = leer.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero para el año.");
                leer.nextLine(); // Limpiar el buffer del scanner
            }
        }
        libro.setAnio(anio);

        // Repite el proceso de validación para los otros campos numéricos
        int ejemplares = 0;
        while (true) {
            try {
                System.out.println("Ingrese ejemplares:");
                ejemplares = leer.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero para los ejemplares.");
                leer.nextLine(); // Limpiar el buffer del scanner
            }
        }
        libro.setEjemplares(ejemplares);

        int ejemplaresPrestados = 0;
        while (true) {
            try {
                System.out.println("Ingrese ejemplares prestados:");
                ejemplaresPrestados = leer.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero para los ejemplares prestados.");
                leer.nextLine(); // Limpiar el buffer del scanner
            }
        }
        libro.setEjemplaresPrestados(ejemplaresPrestados);

        int ejemplaresRestantes = 0;
        while (true) {
            try {
                System.out.println("Ingrese ejemplares restantes:");
                ejemplaresRestantes = leer.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero para los ejemplares restantes.");
                leer.nextLine(); // Limpiar el buffer del scanner
            }
        }
        libro.setEjemplaresRestantes(ejemplaresRestantes);

        System.out.println("Ingrese id del autor:");
        libro.setAutor(new AutorService().buscarAutorPorId());

        System.out.println("Ingrese id de la editorial:");
        libro.setEditorial(new EditorialService().buscarEditorialPorId());

        boolean existe = DAO.existeLibro(libro);
        try {
            if (libro.getAutor() != null && libro.getEditorial() != null && !existe) {
                DAO.guardar(libro);
                System.out.println("Se cargó el libro correctamente.");
            } else {
                System.out.println("No se pudo cargar el libro.");
                System.out.println("Por favor, verifique los datos e intente nuevamente.");
                System.out.println("Es posible que el libro ya exista.");
                leer.nextLine(); // Limpiar el buffer del scanner
                cargarLibro();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarLibroPorAutor() {
        try {
            System.out.println("Ingrese el nombre del autor que desea buscar:");
            String nombre = leer.next();
            DAO.buscarLibroPorAutor(nombre);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarLibroPorEditorial() {
        try {
            System.out.println("Ingrese el nombre de la editorial que desea buscar:");
            String nombre = leer.next();
            DAO.buscarLibroPorEditorial(nombre);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
