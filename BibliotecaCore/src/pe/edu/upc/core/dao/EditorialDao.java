package pe.edu.upc.core.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import pe.edu.upc.core.entity.Editorial;

public class EditorialDao implements BaseDao<Editorial, Integer>{

    private EntityManager entityManager = null;
    
    private void conectar() throws Exception{
        if(entityManager == null){
            entityManager = Conexion.getEntityManager();
        }
    }
    
    @Override
    public void guardar(Editorial entity) throws Exception {
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
        Editorial editorial = entityManager.find(Editorial.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(editorial);
        entityManager.flush();
        tx.commit();
    }

    @Override
    public Editorial obtener(Integer id) throws Exception {
        conectar();
        return entityManager.find(Editorial.class, id);
    }

    @Override
    public List<Editorial> listar() throws Exception {
        conectar();
        return entityManager.createQuery("FROM editorial e ORDER BY nombreEditorial").getResultList();
    }
    
}
