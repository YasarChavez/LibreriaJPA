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
    public void cargarEditorial(){
        try {
            Editorial editorial = new Editorial();
            System.out.println("Ingrese el nombre de la editorial:");
            editorial.setNombre(leer.next());
            DAO.guardar(editorial);
        }catch (Exception e){
            e.getMessage();
        }
    }
    public void listarEditoriales(){
        try {
            DAO.listarEditoriales();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public Editorial buscarPorId() {
        System.out.println("Ingrese el id de la editorial que desea buscar:");
        int id = leer.nextInt();
        return DAO.buscarPorId(id);
    }
}
