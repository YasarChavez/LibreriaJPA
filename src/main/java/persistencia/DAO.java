package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO <T>{
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreriaPU");
    protected EntityManager em = emf.createEntityManager();

    protected void conectar(){
        if (!em.isOpen()){
           em = emf.createEntityManager();
        }
    }

    protected void desconectar(){
        if (em.isOpen()){
            em.close();
        }
    }

    public void guardar(T entidad){
        conectar();
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
        desconectar();
    }


    public void editar(T entidad){
        conectar();
        em.getTransaction().begin();
        em.merge(entidad);
        em.getTransaction().commit();
        desconectar();
    }


    public void eliminar(T entidad){
        conectar();
        em.getTransaction().begin();
        em.remove(entidad);
        em.getTransaction().commit();
        desconectar();
    }

}
