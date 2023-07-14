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


    public Libro buscarPorISBN(long isbn) {
        conectar();
        Libro libro;
        try {
            libro = em.find(Libro.class, isbn);
            if (libro != null) {
                System.out.println(libro);
            } else {
                System.out.println("No se encontro el libro");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        desconectar();
        return libro;
    }

    public void listarTodos() {
        conectar();
        try{
            List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                    .getResultList();
            if (libros != null) {
                for (Libro libro : libros) {
                    System.out.println(libro);
                }
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        desconectar();
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
        Libro libroExiste;
        try {
            libroExiste = (Libro) em.createQuery(
                            "SELECT l FROM Libro l WHERE l.titulo = :titulo AND l.anio = :anio AND l.editorial.nombre = :editorial AND l.autor.nombre = :autor")
                    .setParameter("titulo", libro.getTitulo())
                    .setParameter("anio", libro.getAnio())
                    .setParameter("editorial", libro.getEditorial().getNombre())
                    .setParameter("autor", libro.getAutor().getNombre()).getSingleResult();
        } catch (Exception e) {
            return false;
        }
        desconectar();
        return libroExiste != null;
    }

    public void altaBajaLibroPorISBN(long isbn) {
        conectar();
        Libro libro = em.find(Libro.class, isbn);
        if (libro != null) {
            if (libro.getAlta()) {
                libro.setAlta(false);
                System.out.println("Libro dado de baja");
            } else {
                libro.setAlta(true);
                System.out.println("Libro dado de alta");
            }
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } else {
            System.out.println("No se encontro el libro");
        }
        desconectar();
    }

}

