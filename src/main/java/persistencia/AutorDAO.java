package persistencia;

import entidad.Autor;

public class AutorDAO extends DAO<Autor>{
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
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre= :nombre")
                .setParameter("nombre",nombre).getSingleResult();
        if (autor!=null){
            System.out.println(autor);
        }
        desconectar();
    }
}
