package persistencia;

import entidad.Libro;

import java.util.List;

public class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro entidad) {
        super.guardar(entidad);
    }

    @Override
    public void editar(Libro entidad) {
        super.editar(entidad);
    }

    @Override
    public void eliminar(Libro entidad) {
        super.eliminar(entidad);
    }


    public void buscarPorNombre(String nombre) {
        conectar();
       List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :nombre")
               .setParameter("nombre", "%" + nombre + "%").getResultList();
        desconectar();
        if (libros != null) {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        } else {
            System.out.println("No se encontraron libros");
        }
    }


    public void buscarPorISBN(long isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        if (libro != null) {
            System.out.println(libro);
        }
        desconectar();
    }

    public void listartodos() {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void buscarLibroPorAutor(String nombreAutor) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nombreAutor")
                .setParameter("nombreAutor", "%" + nombreAutor + "%").getResultList();
        desconectar();
        if (libros.size() == 0) {
            System.out.println("No se encontraron libros con ese autor");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void buscarLibroPorEditorial(String nombreEditorial) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nombreEditorial")
                .setParameter("nombreEditorial", "%" + nombreEditorial + "%").getResultList();
        desconectar();
        if (libros.size() == 0) {
            System.out.println("No se encontraron libros con ese editorial");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}

