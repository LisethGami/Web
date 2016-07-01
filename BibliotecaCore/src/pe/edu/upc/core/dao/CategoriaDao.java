package pe.edu.upc.core.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import pe.edu.upc.core.entity.Categoria;

public class CategoriaDao implements BaseDao<Categoria, Integer>{

    EntityManager entityManager = null;
    
    private void conectar() throws Exception{
        if(entityManager == null){
            entityManager = Conexion.getEntityManager();
        }
    }
    
    @Override
    public void guardar(Categoria entity) throws Exception {
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
        Categoria categoria = entityManager.find(Categoria.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(categoria);
        entityManager.flush();
        tx.commit();
    }

    @Override
    public Categoria obtener(Integer id) throws Exception {
        conectar();
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public List<Categoria> listar() throws Exception {
        conectar();
        return entityManager.createQuery("FROM Categoria C ORDER BY C.nombreCategoria").getResultList();
    }
    
}
