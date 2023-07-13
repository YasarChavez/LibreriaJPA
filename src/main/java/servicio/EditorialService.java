package servicio;

import entidad.Autor;
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
    public void modificarEditorialPorId() {
        try {
            System.out.println("Ingrese el id de la editorial que desea modificar:");
            int l = leer.nextInt();
            Editorial editorial = DAO.buscarPorId(l);
            if (editorial != null) {
                System.out.println("Ingrese el nuevo nombre de la editorial:");
                editorial.setNombre(leer.next());
                if (!DAO.existeEditorial(editorial)){
                    DAO.editar(editorial);
                    System.out.println("Editorial modificada correctamente");
                }else {
                    System.out.println("La editorial ya existe");
                    modificarEditorialPorId();
                }
            }else {
                modificarEditorialPorId();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void altaBajaEditorialPorId() {
        try {
            System.out.println("Ingrese el id de la editorial que desea eliminar:");
            Integer id = leer.nextInt();
            DAO.altaBajaEditorial(id);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
