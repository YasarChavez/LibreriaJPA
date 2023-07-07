package servicio;

import entidad.Autor;
import entidad.Libro;
import persistencia.AutorDAO;

import java.util.Scanner;

public class AutorService {
    private final AutorDAO DAO;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public AutorService() {
        this.DAO = new AutorDAO();
    }

    public void cargarAutor(){
        Autor autor = new Autor();
        System.out.println("Ingrese el nombre del autor:");
        autor.setNombre(leer.next());
        try {
            DAO.guardar(autor);
        }catch (Exception e){
            e.getMessage();
        }
    }
    public void buscarPorNombre(){
        try {
            System.out.println("Ingrese el nombre del autor que desea buscar:");
            String nombre = leer.next();
            DAO.buscarPorNombre(nombre);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Autor buscarPorId() {
        try {
            System.out.println("Ingrese el id del autor que desea buscar:");
            long l = leer.nextLong();
            return DAO.buscarPorId(l);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("No se encontró el autor");
            return null;
        }
    }
}
