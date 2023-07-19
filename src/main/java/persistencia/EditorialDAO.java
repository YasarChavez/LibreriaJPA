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
        List<Editorial> editoriales;
        try {
            editoriales  = em.createQuery("SELECT e FROM Editorial e").getResultList();
            if (editoriales.isEmpty()) {
                System.out.println("No se encontraron resultados");
            } else {
                for (Editorial editorial : editoriales) {
                    System.out.println(editorial);
                }
            }
        }catch (Exception e) {
            System.out.println("Error en la busqueda: " + e.getMessage());
        }
        desconectar();
    }

    public Editorial buscarPorId(int id) {
        conectar();
        Editorial editorial = new Editorial();
        try {
            editorial = em.find(Editorial.class, id);
            if (editorial != null) {
                System.out.println(editorial);
            } else {
                System.out.println("No se encontro la editorial");
            }
        } catch (Exception e) {
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
        } catch (Exception e) {
            return false;
        }
        desconectar();
        return editorialExiste != null;
    }

    public List buscarPorNombre(String nombre) {
        conectar();
        List<Editorial> editoriales;
        try {
            editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
                    .setParameter("nombre", "%"+nombre+"%")
                    .getResultList();
            if (editoriales.size() > 0) {
                for (Editorial e : editoriales) {
                    System.out.println(e);
                }
                return editoriales;
            } else {
                System.out.println("No se encontraron editoriales");
            }
        } catch (Exception e) {
            System.out.println("Error en la busqueda: " + e.getMessage());
        }
        desconectar();
        return null;
    }

    public void altaBajaEditorial(Integer id) {
        conectar();
        Editorial editorial;
        try {
            editorial = em.find(Editorial.class, id);
            if (editorial != null) {
                if (editorial.getAlta()) {
                    editorial.setAlta(false);
                    System.out.println("Se dio de baja la Editorial");
                } else {
                    editorial.setAlta(true);
                    System.out.println("Se dio de alta la Editorial");
                }
                em.getTransaction().begin();
                em.merge(editorial);
                em.getTransaction().commit();
            } else {
                System.out.println("No se encontro la editorial");
            }
        }catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
        desconectar();
    }
}
