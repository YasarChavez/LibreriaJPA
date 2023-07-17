package persistencia;

import entidad.Cliente;
import entidad.Prestamo;

import java.util.List;

public class PrestamoDAO extends DAO<Prestamo> {
    @Override
    public void guardar(Prestamo entidad) {
        super.guardar(entidad);
    }

    @Override
    public void editar(Prestamo entidad) {
        super.editar(entidad);
    }

    @Override
    public void eliminar(Prestamo entidad) {
        super.eliminar(entidad);
    }

    public void listarPrestamosPorCliente(Cliente cliente) {
        conectar();
        List<Prestamo> prestamos;
        try {
            prestamos = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.documento = :documento")
                    .setParameter("documento", cliente.getDocumento())
                    .getResultList();
            if (prestamos.size() > 0) {
                for (Prestamo p : prestamos) {
                    System.out.println(p);
                }
            } else {
                System.out.println("No hay prestamos para este cliente");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        desconectar();
    }

    public Prestamo buscarPrestamoPorID(int id) {
        conectar();
        Prestamo prestamo;
        try {
            prestamo = em.find(Prestamo.class, id);
            if (prestamo != null) {
                System.out.println(prestamo);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        return prestamo;
    }

    public void listarTodosLosPrestamos() {
        conectar();
        List<Prestamo> prestamos;
        try {
            prestamos = em.createQuery("SELECT p FROM Prestamo p").getResultList();
            if (prestamos.isEmpty()) {
                System.out.println("No hay prestamos registrados");
            }else {
                for (Prestamo p : prestamos) {
                    System.out.println(p);
                }
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
