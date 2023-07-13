package persistencia;

import entidad.Cliente;

import java.util.List;

public class ClienteDAO extends DAO<Cliente> {
    @Override
    public void guardar(Cliente entidad) {
        super.guardar(entidad);
    }

    @Override
    public void editar(Cliente entidad) {
        super.editar(entidad);
    }

    @Override
    public void eliminar(Cliente entidad) {
        super.eliminar(entidad);
    }

    public void listarClientes() {
        conectar();
        try {
            List clientes = em.createQuery("SELECT c FROM Cliente c").getResultList();
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes");
            }else {
                System.out.println("Lista de clientes:");
                for (Object cliente : clientes) {
                    System.out.println(cliente);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        desconectar();
    }

    public Cliente buscarClientePorDocumento(long documento) {
        conectar();
        Cliente cliente;
        try {
            cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.documento = :documento")
                    .setParameter("documento", documento)
                    .getSingleResult();
            if (cliente != null) {
                System.out.println(cliente);
            }
        }catch (Exception e){
            System.out.println("Error al buscar cliente por documento: "+e.getMessage());
            return null;
        }
        desconectar();
        return cliente;
    }
}
