package pe.edu.upc.core.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import pe.edu.upc.core.entity.Libro;

public class LibroDao implements BaseDao<Libro, Integer>{

    private EntityManager entityManager = null;
    
    private void conectar() throws Exception{
        if(entityManager == null){
            entityManager = Conexion.getEntityManager();
        }
    }
    
    @Override
    public void guardar(Libro entity) throws Exception {
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
        Libro libro = entityManager.find(Libro.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(libro);
        entityManager.flush();
        tx.commit();
    }

    @Override
    public Libro obtener(Integer id) throws Exception {
        conectar();
        return entityManager.find(Libro.class, id);
    }

    @Override
    public List<Libro> listar() throws Exception {
        conectar();
        return entityManager.createQuery("FROM Libro L ORDER BY L.nombreLibro").getResultList();
    }
    
    
    //---------------
    //NUEVAS CLASES
    //---------------
    public List<Libro> listar(String nombre) throws Exception{
        conectar();
        Query query = entityManager.createQuery("FROM Libro L WHERE L.apellido LIKE CONCAT(?1,'%')");
        query.setParameter(1, nombre);
        return query.getResultList();
    }
    
    public Long totalLibros() throws Exception{
        conectar();
        Query query = entityManager.createQuery("SELECT COUNT(L.Libro) FROM Libro L",Long.class);
        return (Long)query.getSingleResult();
    }
    
    public List<Libro> obtenerTodos() throws Exception{
        conectar();
        Query query = entityManager.createQuery("Libro.findAll");
        return query.getResultList();
    }
    
}
