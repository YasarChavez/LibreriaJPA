package servicio;

import entidad.Cliente;
import entidad.Libro;
import entidad.Prestamo;
import persistencia.LibroDAO;
import persistencia.PrestamoDAO;

import java.time.LocalDate;
import java.util.Scanner;

public class PrestamoService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final PrestamoDAO DAO;

    public PrestamoService() {
        this.DAO = new PrestamoDAO();
    }

    public void crearPrestamo() {
        Libro libro;
        while (true) {
            try {
                libro = (new LibroService()).buscarLibroPorISBN();
                if (libro != null) {
                    System.out.println("Libro encontrado!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ingrese un valor valido!");
                leer.next();
            }
        }
        Cliente cliente;
        while (true) {
            try {
                cliente = (new ClienteService()).buscarClientePorDocumento();
                if (cliente != null) {
                    System.out.println("Cliente encontrado!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ingrese un valor valido!");
                leer.next();
            }
        }
        LocalDate fechaPrestamo;
        while (true) {
            try {
                System.out.println("Ingrese la fecha del prestamo en formato (yyyy-MM-dd):");
                String fecha = leer.next();
                fechaPrestamo = LocalDate.parse(fecha);
                System.out.println(fechaPrestamo);
                break;
            } catch (Exception e) {
                System.out.println("Ingrese un valor valido!");
            }
        }
        LocalDate fechaDevolucion;
        while (true) {
            try {
                System.out.println("Ingrese la fecha de devolucion en formato (yyyy-MM-dd):");
                String fecha = leer.next();
                fechaDevolucion = LocalDate.parse(fecha);
                System.out.println(fechaDevolucion);
                break;
            } catch (Exception e) {
                System.out.println("Ingrese un valor valido!");
            }
        }
        if(libro.getEjemplaresRestantes() == 0){
            System.out.println("No hay mas ejemplares disponibles!");
        }else {
            LibroService libroService = new LibroService();
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
            libroService.editar(libro);
            Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion, libro, cliente);
            DAO.guardar(prestamo);
            System.out.println("Prestamo creado!");
        }
    }

}
