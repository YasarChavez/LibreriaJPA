package servicio;

import entidad.Editorial;
import persistencia.EditorialDAO;

import java.util.Scanner;

public class EditorialService {
    private final EditorialDAO DAO;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public EditorialService() {
        this.DAO = new EditorialDAO();
    }

    public void cargarEditorial() {
        try {
            Editorial editorial = new Editorial();
            System.out.println("Ingrese el nombre de la editorial:");
            editorial.setNombre(leer.next());
            boolean existe = DAO.existeEditorial(editorial);
            if (!existe) {
                DAO.guardar(editorial);
                System.out.println("Editorial cargada correctamente");
            } else {
                System.out.println("La editorial ya existe");
                cargarEditorial();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listarEditoriales() {
        try {
            DAO.listarEditoriales();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Editorial buscarEditorialPorId() {
        try {
            System.out.println("Ingrese el id de la editorial que desea buscar:");
            int id = leer.nextInt();
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void buscarEditorialPorNombre() {
        try {
            System.out.println("Ingrese el nombre de la editorial que desea buscar:");
            String nombre = leer.next();
            DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarEditorialPorId() {
        try {
            System.out.println("Ingrese el id de la editorial que desea eliminar:");
            Integer id = leer.nextInt();
            DAO.eliminarEditorial(id);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
