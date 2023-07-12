package persistencia;

import entidad.Editorial;

import java.util.List;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial entidad) {
        super.guardar(entidad);
    }

    @Override
    public void editar(Editorial entidad) {
        super.editar(entidad);
    }

    @Override
    public void eliminar(Editorial entidad) {
        super.eliminar(entidad);
    }

    public void listarEditoriales() {
        conectar();
        List<Editorial> editoriales = (List<Editorial>) em.createQuery("SELECT e FROM Editorial e").getResultList();
        if (editoriales != null) {
            for (Editorial editorial : editoriales) {
                System.out.println(editorial);
            }
        }else {
            System.out.println("No se encontraron resultados");
        }
        desconectar();
    }

    public Editorial buscarPorId(int id) {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            System.out.println(editorial);
        }else {
            System.out.println("No se encontro la editorial");
        }
        desconectar();
        return editorial;
    }

    public boolean existeEditorial(Editorial editorial) {
        conectar();
        Editorial editorialExiste;
        try {
            editorialExiste = (Editorial) em.createQuery(
                            "SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
                    .setParameter("nombre", editorial.getNombre())
                    .getSingleResult();
        }catch (Exception e){
            return false;
        }
        desconectar();
        return editorialExiste != null;
    }

    public void buscarPorNombre(String nombre) {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
                .setParameter("nombre", nombre)
                .getResultList();
        desconectar();
        if (editoriales.size()>0){
            for (Editorial e : editoriales) {
                System.out.println(e);
            }
        }else{
            System.out.println("No se encontraron resultados");
        }
    }

    public void eliminarEditorial(Integer id) {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            em.getTransaction().begin();
            editorial.setAlta(false);
            em.merge(editorial);
            em.getTransaction().commit();
        }else {
            System.out.println("No se encontro la editorial");
        }
        desconectar();
    }
}
