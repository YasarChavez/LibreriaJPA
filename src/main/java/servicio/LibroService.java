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
            DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void buscarLibroPorNombre() {
        try {
            System.out.println("Ingrese el nombre del libro:");
            String nombre = leer.next();
            DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No se encontró el libro");
        }
    }

    public Libro buscarLibroPorISBN() {
        try {
            System.out.println("Ingrese el ISBN del libro:");
            long isbn = leer.nextLong();
            return DAO.buscarPorISBN(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No se encontrón el libro");
            return null;
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

    public void altaBajaLibroPorISBN() {
        try {
            System.out.println("Ingrese el ISBN del libro que desea dar de baja o alta");
            long isbn = leer.nextLong();
            DAO.altaBajaLibroPorISBN(isbn);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void modificarLibroPorISBN() {
        try {
            System.out.println("Ingrese el ISBN del libro que desea modificar:");
            long isbn = 0;
            while (true) {
                try {
                    System.out.println("Ingrese ISBN:");
                    isbn = leer.nextLong();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debes ingresar un número para el ISBN.");
                    leer.nextLine(); // Limpiar el buffer del scanner
                }
            }
            Libro libro = DAO.buscarPorISBN(isbn);
            if (libro != null) {
                int menu = -1;
                do {
                    System.out.println("1. Modificar título");
                    System.out.println("2. Modificar año");
                    System.out.println("3. Modificar ejemplares");
                    System.out.println("4. Modificar ejemplares prestados");
                    System.out.println("5. Modificar ejemplares restantes");
                    System.out.println("6. Modificar id del autor");
                    System.out.println("7. Modificar id de la editorial");
                    System.out.println("8. Guardar cambios");
                    System.out.println("0. Salir");
                    menu = leer.nextInt();
                    switch (menu) {
                        case 1:
                            System.out.println("Ingrese el nuevo título:");
                            libro.setTitulo(leer.next());
                            break;
                        case 2:
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
                            break;
                        case 3:
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
                            break;
                        case 4:
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
                            break;
                        case 5:
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
                            break;

                        case 6:
                            System.out.println("Ingrese el nuevo id del autor:");
                            libro.setAutor(new AutorService().buscarAutorPorId());
                            break;

                        case 7:
                            System.out.println("Ingrese el nuevo id de la editorial:");
                            libro.setEditorial(new EditorialService().buscarEditorialPorId());
                            break;
                        case 8:
                            boolean existe = DAO.existeLibro(libro);
                            try {
                                if (libro.getAutor() != null && libro.getEditorial() != null && !existe) {
                                    DAO.editar(libro);
                                    System.out.println("Se modificó el libro correctamente.");
                                    leer.nextLine(); // Limpiar el buffer del scanner
                                    break;
                                } else {
                                    System.out.println("No se pudo modificar el libro.");
                                    System.out.println("Por favor, verifique los datos e intente nuevamente.");
                                    System.out.println("Es posible que el libro ya exista.");
                                    leer.nextLine(); // Limpiar el buffer del scanner
                                    modificarLibroPorISBN();
                                }
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case 0:
                            System.out.println("Saliendo del menu de modificación.");
                            break;
                        default:
                            System.out.println("Opción incorrecta.");
                            break;
                    }

                } while (menu != 0);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void editar(Libro libro) {
        DAO.editar(libro);
    }
}
