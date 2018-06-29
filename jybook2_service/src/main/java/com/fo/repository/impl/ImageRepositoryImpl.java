package com.fo.repository.impl;

import com.fo.entity.booktype;
import com.fo.entity.image;
import com.fo.repository.ImageRepository;
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
public class ImageRepositoryImpl implements ImageRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public image load(Integer id) {
        return (image)getCurrentSession().load(image.class,id);
    }

    public image get(Integer id) {
        return (image)getCurrentSession().get(image.class,id);
    }

    public List<image> findAll() {
        return null;
    }

    public void persist(image entity) {
        getCurrentSession().persist(entity);
    }

    public Integer save(image entity) {
        return (Integer)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(image entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        image _image = load(id);
        getCurrentSession().delete(_image);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    public image findSingleByPlace(String place) {
        Query q=getCurrentSession().createQuery("from image b where b.place=? order by b.sort asc");
        q.setString(0,place);
        q.setFirstResult(0);
        q.setMaxResults(1);

        return (image)q.uniqueResult();
    }

    public List<image> findByPlace(String place) {
        Query q=getCurrentSession().createQuery("from image b where b.place=? order by b.sort");
        q.setString(0,place);

        return q.list();
    }
}
