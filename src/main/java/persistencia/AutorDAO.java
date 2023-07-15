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


    public Autor buscarPorNombre(String nombre) {
        conectar();
        Autor autor;
        try {
            autor = (Autor) em.createQuery("SELECT a FROM Autor a where a.nombre = :nombre")
                    .setParameter("nombre", nombre)
                    .getSingleResult();
            if (autor != null) {
                System.out.println(autor);
            } else {
                System.out.println("No se encontro el autor");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        desconectar();
        return autor;
    }

    public Autor buscarPorId(int l) {
        conectar();
        Autor autor = new Autor();
        try {
            autor = em.find(Autor.class, l);
            if (autor != null) {
                System.out.println(autor);
            } else {
                System.out.println("No  se encontro el autor");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        desconectar();
        return autor;
    }

    public void listarAutores() {
        conectar();
        List<Autor> autores;
        try {
            autores = em.createQuery("SELECT a FROM Autor a").getResultList();
            if (autores.isEmpty()) {
                System.out.println("No hay autores");
            } else {
                for (Autor autor : autores) {
                    System.out.println(autor);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        desconectar();
    }

    public boolean existeAutor(Autor autor) {
        conectar();
        Autor autorExiste;
        try {
            autorExiste = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre= :nombre")
                    .setParameter("nombre", autor.getNombre())
                    .getSingleResult();
        } catch (Exception e) {
            return false;
        }
        desconectar();
        return autorExiste != null;
    }

    public void altaBajaAutor(Integer id) {
        conectar();
        Autor autor;
        try {
            autor = em.find(Autor.class, id);
            if (autor != null) {
                if (autor.getAlta()) {
                    autor.setAlta(false);
                    System.out.println("Autor dado de baja");
                } else {
                    autor.setAlta(true);
                    System.out.println("Autor dado de alta");
                }
                em.getTransaction().begin();
                em.merge(autor);
                em.getTransaction().commit();
            } else {
                System.out.println("No se encontro el autor");
            }
        }catch (Exception  e){
            System.out.println("Error: "+e.getMessage());
        }
        desconectar();
    }

    public void eliminarAutor(Integer id) {
        conectar();
        Autor autor;
        try {
            autor = em.find(Autor.class, id);
            if (autor != null) {
                em.getTransaction().begin();
                em.remove(autor);
                em.getTransaction().commit();
            } else {
                System.out.println("No se encontro el autor");
            }
        }catch (Exception  e){
            System.out.println("Error: "+e.getMessage());
        }
        desconectar();
    }

}
