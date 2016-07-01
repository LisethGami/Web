package pe.edu.upc.core.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import pe.edu.upc.core.entity.Reserva;

public class ReservaDao implements BaseDao<Reserva, Integer> {

    private EntityManager entityManager = null;

    private void conectar() throws Exception {
        if (entityManager == null) {
            entityManager = Conexion.getEntityManager();
        }
    }

    @Override
    public void guardar(Reserva entity) throws Exception {
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
        Reserva reserva = entityManager.find(Reserva.class, id);
        if (reserva != null) {
            EntityTransaction tx = entityManager.getTransaction();
            entityManager.remove(reserva);
            entityManager.flush();
            tx.commit();
        }
    }

    @Override
    public Reserva obtener(Integer id) throws Exception {
        conectar();
        return entityManager.find(Reserva.class, id);
    }

    @Override
    public List<Reserva> listar() throws Exception {
        conectar();
        return entityManager.createQuery("FROM Reserva r ORDER BY fechaIni").getResultList();
    }

}
