package pe.edu.upc.core.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import pe.edu.upc.core.entity.Autor;

public class AutorDao implements BaseDao<Autor, Integer>{

    EntityManager entityManager = null;
    
    private void conectar() throws Exception{
        if(entityManager == null){
            entityManager = Conexion.getEntityManager();
        }
    }
    
    @Override
    public void guardar(Autor entity) throws Exception {
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
        Autor autor = entityManager.find(Autor.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(autor);
        entityManager.flush();
        tx.commit();
    }

    @Override
    public Autor obtener(Integer id) throws Exception {
        conectar();
        return entityManager.find(Autor.class, id);
    }

    @Override
    public List<Autor> listar() throws Exception {
        conectar();
        return entityManager.createQuery("FROM Autor A ORDER BY A.apellido").getResultList();
    }
    
}
