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
        }
        desconectar();
    }
}
