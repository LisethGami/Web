package pe.edu.upc.core.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import pe.edu.upc.core.entity.Tipousuario;

public class TipousuarioDao implements BaseDao<Tipousuario, Integer>{

    private EntityManager entityManager = null;
    
    private void conectar() throws Exception{
        if(entityManager == null){
            entityManager = Conexion.getEntityManager();
        }
    }
    
    @Override
    public void guardar(Tipousuario entity) throws Exception {
        conectar();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        entityManager.flush();
        tx.commit();
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        conectar();
        Tipousuario tipoUsuario = entityManager.find(Tipousuario.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(tipoUsuario);
        entityManager.flush();
        tx.commit();
    }

    @Override
    public Tipousuario obtener(Integer id) throws Exception {
        conectar();
        return entityManager.find(Tipousuario.class, id);
    }

    @Override
    public List<Tipousuario> listar() throws Exception {
        conectar();
        return  entityManager.createQuery("FROM Tipousuario t ORDER BY nombreTUsuario").getResultList();
    }
    
}
