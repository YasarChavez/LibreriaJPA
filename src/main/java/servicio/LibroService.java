package servicio;

import entidad.Libro;
import persistencia.LibroDAO;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LibroService {

    private final LibroDAO DAO;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorService autorService = new AutorService();
    EditorialService editorialService = new EditorialService();

    public LibroService() {
        this.DAO = new LibroDAO();
    }

    public void listarLibros() {
        try {
            DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    public void cargarLibro() throws InterruptedException {
        Libro libro = new Libro();

        System.out.println("Ingrese Titulo:");
        libro.setTitulo(leer.nextLine());

        int anio;
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
        int ejemplares;
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

        int ejemplaresPrestados;
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

        int ejemplaresRestantes;
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

        while (true) {
            System.out.println("Buscar Autor...");
            autorService.buscarAutorPorNombre();
            System.out.println("Ingrese 0 si no se encontró Autor o un *Espacio* para continuar.");
            String id;
            int id2 = -1;
            while (true) {

                try {
                    id = leer.next();
                    if (id.equals(" ")) {
                        break;
                    }
                    id2 = Integer.parseInt(id);
                    break;
                } catch (Exception e) {
                    System.out.println("Error: Debes ingresar un numero entero para el ID.");
                    leer.nextLine(); // Limpiar el buffer del scanner
                }
            }
            if (id2 == 0) {
                leer.nextLine(); // Limpiar el buffer del scanner
            } else {
                libro.setAutor(autorService.buscarAutorPorId());
                break;
            }
        }

        while (true) {
            System.out.println("Buscar Editorial...");
            editorialService.buscarEditorialPorNombre();
            System.out.println("Ingrese 0 si no se encontró Editorial o un *Espacio* para continuar.");
            String id;
            int id2 = -1;
            while (true) {
                try {
                    id = leer.next();
                    if (id.equals(" ")) {
                        break;
                    }
                    id2 = Integer.parseInt(id);
                    break;
                } catch (Exception e) {
                    System.out.println("Error: Debes ingresar un numero entero para el ID.");
                    leer.nextLine(); // Limpiar el buffer del scanner
                }
            }
            if (id2 == 0) {
                leer.nextLine(); // Limpiar el buffer del scanner
            } else {
                libro.setEditorial(editorialService.buscarEditorialPorId());
                break;
            }
        }


        boolean existe = DAO.existeLibro(libro);

        try {
            if (libro.getAutor() != null && libro.getEditorial() != null && !existe) {
                DAO.guardar(libro);
                System.out.println("Se cargó el libro correctamente.");
                leer.nextLine();
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
            long isbn;
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
                            int anio;
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
                            int ejemplares;
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
                            int ejemplaresPrestados;
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
                            int ejemplaresRestantes;
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
                            System.out.println("Buscar Autor...");
                            autorService.buscarAutorPorNombre();
                            libro.setAutor(autorService.buscarAutorPorId());
                            break;

                        case 7:
                            System.out.println("Buscar editorial...");
                            editorialService.buscarEditorialPorNombre();
                            libro.setEditorial(editorialService.buscarEditorialPorId());
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
