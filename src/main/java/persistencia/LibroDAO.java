package persistencia;

import entidad.Libro;

import java.util.List;
import java.util.Objects;

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

    public boolean existeLibro(Libro libro) {
        conectar();
        //listar todos
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        //Comparar si existe
        for (Libro libro1 : libros) {
            if (libro1.getTitulo().equals(libro.getTitulo())
                    && libro1.getAnio().equals(libro.getAnio())
                    && libro1.getAutor().getNombre().equals(libro.getAutor().getNombre())
                    && libro1.getEditorial().getNombre().equals(libro.getEditorial().getNombre()))
            {
                return true;
            }
        }
        return false;
    }
}

