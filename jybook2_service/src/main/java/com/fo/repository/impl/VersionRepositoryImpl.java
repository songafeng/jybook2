package com.fo.repository.impl;

import com.fo.entity.image;
import com.fo.entity.version;
import com.fo.repository.VersionRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
@Repository
public class VersionRepositoryImpl implements VersionRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public version load(Integer id) {
        return (version)getCurrentSession().load(version.class,id);
    }

    public version get(Integer id) {
        return (version)getCurrentSession().get(version.class,id);
    }

    public List<version> findAll() {
        return null;
    }

    public void persist(version entity) {
        getCurrentSession().persist(entity);
    }

    public Integer save(version entity) {
        return (Integer)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(version entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        version _version = load(id);
        getCurrentSession().delete(_version);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    public version findByClienttype(Integer client_type)
    {
        Query q=getCurrentSession().createQuery("from version where client_type=? and status=1 order by version desc");
        q.setInteger(0,client_type);
        q.setFirstResult(0);
        q.setMaxResults(1);

        return (version)q.uniqueResult();
    }
}
