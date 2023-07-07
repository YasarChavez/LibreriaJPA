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

    public Libro buscarporNombre(String nombre) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo= :nombre")
                .setParameter("nombre",nombre).getSingleResult();
        if (libro!=null){
            System.out.println(libro);
        }
        desconectar();
        return libro;
    }

    public void buscarPorISBN(long isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn")
                .setParameter("isbn",isbn).getSingleResult();
        if (libro!=null){
            System.out.println(libro);
        }
        desconectar();
    }
    public void listartodos() {
        conectar();
        //"SELECT u FROM Usuario u where u.nombre LIKE '%Yas%'").getResultList();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
    public void buscarLibroPorAutor(long idAutor){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.id = :idAutor")
                .setParameter("idAutor",idAutor).getResultList();
        desconectar();
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
    public void buscarLibroPorEditorial(long idEditorial){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.id = :idEditorial")
                .setParameter("idEditorial",idEditorial).getResultList();
        desconectar();
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}

