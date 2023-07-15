package servicio;

import entidad.Autor;
import persistencia.AutorDAO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AutorService {
    private final AutorDAO DAO;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public AutorService() {
        this.DAO = new AutorDAO();
    }

    public void cargarAutor() {
        Autor autor = new Autor();
        System.out.println("Ingrese el nombre del autor:");
        autor.setNombre(leer.next());

        boolean existe = DAO.existeAutor(autor);
        try {
            if (!existe) {
                DAO.guardar(autor);
                System.out.println("Autor cargado correctamente");
            } else {
                System.out.println("El autor ya existe");
                cargarAutor();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Autor buscarAutorPorNombre() {
        try {
            System.out.println("Ingrese el nombre del autor que desea buscar:");
            String nombre = leer.next();
            return DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Autor buscarAutorPorId() {
        try {
            System.out.println("Ingrese el id del autor que desea buscar:");
            int l = leer.nextInt();
            return DAO.buscarPorId(l);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No se encontró el autor");
            return null;
        }
    }

    public void listarAutores() {
        try {
            DAO.listarAutores();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarAutorPorId() {
        try {
            System.out.println("Ingrese el id del autor que desea modificar:");
            int l = 0;
            try {
                while (true) {
                    l = leer.nextInt();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
            Autor autor = DAO.buscarPorId(l);
            if (autor != null) {
                System.out.println("Ingrese el nuevo nombre del autor:");
                autor.setNombre(leer.next());
                if (!DAO.existeAutor(autor)) {
                    DAO.editar(autor);
                    System.out.println("Autor modificado correctamente");
                } else {
                    System.out.println("El autor ya existe");
                    modificarAutorPorId();
                }
            } else {
                leer.next();
                modificarAutorPorId();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void altaBajaAutorPorId() {
        try {
            System.out.println("Ingrese el id del autor que desea dar de Alta/Baja:");
            Integer l = leer.nextInt();
            DAO.altaBajaAutor(l);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//    public void eliminarAutorPorId() {
//        try {
//            System.out.println("Ingrese el id del autor que desea eliminar:");
//            Integer l = leer.nextInt();
//            DAO.eliminarAutor(l);
//            System.out.println("Se elimino el autor");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
