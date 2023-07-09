package persistencia;

import entidad.Autor;

import java.util.List;

public class AutorDAO extends DAO<Autor> {
    @Override
    public void guardar(Autor entidad) {
        super.guardar(entidad);
    }

    @Override
    public void editar(Autor entidad) {
        super.editar(entidad);
    }

    @Override
    public void eliminar(Autor entidad) {
        super.eliminar(entidad);
    }


    public void buscarPorNombre(String nombre) {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre= :nombre")
                .setParameter("nombre", nombre).getResultList();
        desconectar();
        if (autores.size() > 0) {
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        } else {
            System.out.println("No se encontraron autores con ese nombre");
        }
    }

    public Autor buscarPorId(long l) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id= :id")
                .setParameter("id", l).getSingleResult();
        if (autor != null) {
            System.out.println(autor);
        }
        desconectar();
        return autor;
    }

    public void listarAutores() {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        if (autores != null) {
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        }
        desconectar();
    }

    public boolean existeAutor(Autor autor) {
        conectar();
        Autor autorExiste = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre= :nombre")
                .setParameter("nombre", autor.getNombre())
                .getSingleResult();
        desconectar();
        return autorExiste != null;
    }
}
