package servicio;

import entidad.Libro;
import persistencia.LibroDAO;

import java.util.Scanner;

public class LibroService {
    private final LibroDAO DAO;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public LibroService() {
        this.DAO = new LibroDAO();
    }
    public void listarTodos(){
        try {
            DAO.listartodos();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void buscarPorNombre(){
        try {
            System.out.println("Ingrese el nombre del libro que desea buscar:");
            String nombre = leer.next();
            DAO.buscarporNombre(nombre);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void buscarPorISBN() {
        try {
            System.out.println("Ingrese el ISBN del libro que desea buscar:");
            long isbn  = leer.nextLong();
            DAO.buscarPorISBN(isbn);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void cargarLibro(){
        Libro libro = new Libro();
        System.out.println("Ingrese Titulo:");
        libro.setTitulo(leer.next());
        System.out.println("Ingrese Cantidad de Ejemplares:");
        libro.setEjemplares(leer.nextInt());
        System.out.println("Ingrese el año:");
        libro.setAnio(leer.nextInt());
        try {
            DAO.guardar(libro);
        }catch (Exception e){
            e.getMessage();
        }
    }
    public void buscarLibroPorAutor(){
        try {
            System.out.println("Ingrese el nombre del autor que desea buscar:");
            long id = leer.nextLong();
            DAO.buscarLibroPorAutor(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
