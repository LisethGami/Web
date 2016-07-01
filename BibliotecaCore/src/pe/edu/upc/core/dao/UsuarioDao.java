package pe.edu.upc.core.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import pe.edu.upc.core.entity.Reserva;
import pe.edu.upc.core.entity.Usuario;

public class UsuarioDao implements BaseDao<Usuario, String>{

    private EntityManager entityManager = null;
    
    private void conectar() throws Exception{
        if(entityManager == null){
            entityManager = Conexion.getEntityManager();
        }
    }
    
    @Override
    public void guardar(Usuario entity) throws Exception {
        conectar();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        entityManager.flush();
        tx.commit();
    }

    @Override
    public void eliminar(String id) throws Exception {
        conectar();
        Usuario usuario = entityManager.find(Usuario.class, id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(usuario);
        entityManager.flush();
        tx.commit();
    }

    @Override
    public Usuario obtener(String id) throws Exception {
        conectar();
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> listar() throws Exception {
        conectar();
        return entityManager.createQuery("FROM Usuario U ORDER BY U.apellido").getResultList();
    }
    
    //---------------
    //NUEVAS CLASES
    //---------------
    public List<Usuario> listar(String apellido) throws Exception{
        conectar();
        Query query = entityManager.createQuery("FROM Usuario U WHERE U.apellido LIKE CONCAT(?1,'%')");
        query.setParameter(1, apellido);
        return query.getResultList();
    }
    
    public Long totalUsuarios() throws Exception{
        conectar();
        Query query = entityManager.createQuery("SELECT COUNT(U.codUsuario) FROM Usuario u",Long.class);
        return (Long)query.getSingleResult();
    }
    
    public List<Usuario> obtenerTodos() throws Exception{
        conectar();
        Query query = entityManager.createQuery("Usuario.findAll");
        return query.getResultList();
    }

    //Clase que sirve para guardar el TIPOUSUARIO seleccionado
    /*public void guardar(Usuario entity, int idTipousuario) throws Exception {
        conectar();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        entityManager.flush();
        
    }*/

}
