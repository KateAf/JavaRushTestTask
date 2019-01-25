package app.repository;

import app.dao.DaoImpl;
import app.entity.CompPart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AppRepository {
    String queryAccess = "SELECT * FROM parts";

    private final SessionFactory sessionFactory;

    @Autowired
    public AppRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public  Serializable create(final CompPart entity) {
        return sessionFactory.getCurrentSession().save(entity);
    }

    public CompPart update(final CompPart entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }

    public  void delete(final CompPart entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<CompPart> uploadAll() {
        List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(queryAccess).list();
        List<CompPart> compparts = new ArrayList<>();
        DaoImpl.createListFromObjectArray(list, compparts);
        return compparts;
    }

    @SuppressWarnings("rawtypes")
    public <T> List uploadAll(String query) {
        return sessionFactory.getCurrentSession().createSQLQuery(query).list();
    }

    @SuppressWarnings("unchecked")
    public <T> T uploadOnId(Serializable id, Class<T> entityClass) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }
}
