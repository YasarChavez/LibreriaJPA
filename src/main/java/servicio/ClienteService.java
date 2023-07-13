package servicio;

import entidad.Cliente;
import persistencia.ClienteDAO;

import java.util.Scanner;

public class ClienteService {
    private final ClienteDAO DAO;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ClienteService() {
        this.DAO = new ClienteDAO();
    }

    public void crearCliente() {
        Cliente cliente = new Cliente();
        try {
            System.out.println("Ingrese el documento del cliente");
            cliente.setDocumento(leer.nextLong());
            System.out.println("Ingrese el nombre del cliente");
            cliente.setNombre(leer.next());
            System.out.println("Ingrese el apellido del cliente");
            cliente.setApellido(leer.next());
            System.out.println("Ingrese el telefono del cliente");
            cliente.setTelefono(leer.next());
            if (cliente.getDocumento() != 0 && cliente.getNombre() != null && cliente.getApellido() != null && cliente.getTelefono() != null) {
                DAO.guardar(cliente);
                System.out.println("Cliente creado");
            } else {
                System.out.println("Error al ingresar los datos");
                crearCliente();
            }
        } catch (
                Exception e) {
            System.out.println("Error al ingresar los datos");
        }
    }

    public void listarClientes() {
        try {
            DAO.listarClientes();
        } catch (Exception e) {
            System.out.println("Error al listar los clientes");
        }
    }

    public Cliente buscarClientePorDocumento() {
        long documento = 0;
        while (true) {
           try {
               System.out.println("Ingrese el documento del cliente a buscar");
               documento = leer.nextLong();
               return DAO.buscarClientePorDocumento(documento);
           }catch (Exception e){
               System.out.println("Error al ingresar el documento");
               leer.nextLine(); // Limpiar el buffer del scanner
           }
        }
    }
}
