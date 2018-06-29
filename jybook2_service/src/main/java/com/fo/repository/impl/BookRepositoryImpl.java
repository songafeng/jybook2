package com.fo.repository.impl;

import com.fo.Utils.WhereUtils;
import com.fo.entity.Person;
import com.fo.entity.book;
import com.fo.repository.BookRepository;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public book load(Integer id) {
        return (book)getCurrentSession().load(book.class,id);
    }

    public book get(Integer id) {
        return (book)getCurrentSession().get(book.class,id);
    }

    public List<book> findAll() {
        return null;
    }

    public void persist(book entity) {
        getCurrentSession().persist(entity);
    }

    public Integer save(book entity) {
        return (Integer)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(book entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        book _book = load(id);
        getCurrentSession().delete(_book);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    public List<book> findByType(Integer type) {
//        Query q=getCurrentSession().createQuery("from book b where b.type=?");
//        q.setInteger(0,type);
//
//        return q.list();

        String sql="select n_id as id,s_name as name,s_profile as profile,n_type as type,s_remark as remark,n_chapternum as chapternum,s_url as url,n_size as size,n_sort as sort,d_create_time as create_time " +
                " from jy_book "+
                " where 1=1";
        WhereUtils where = WhereUtils.ins(sql).andEq("n_type",type);
        where.addOrderBy(" ORDER BY n_sort asc");

        SQLQuery query=getCurrentSession().createSQLQuery(where.getAllSql());
        List list = where.getParms();
        for (int i = 0; i < list.size(); i++) {
            query.setParameter(i, list.get(i));
        }
        query.addScalar("id", StandardBasicTypes.INTEGER);
        query.addScalar("name", StandardBasicTypes.STRING);
        query.addScalar("profile", StandardBasicTypes.STRING);
        query.addScalar("type", StandardBasicTypes.INTEGER);
        query.addScalar("remark", StandardBasicTypes.STRING);
        query.addScalar("chapternum", StandardBasicTypes.INTEGER);
        query.addScalar("url", StandardBasicTypes.STRING);
        query.addScalar("size", StandardBasicTypes.INTEGER);
        query.addScalar("sort", StandardBasicTypes.INTEGER);
        query.addScalar("create_time", StandardBasicTypes.TIMESTAMP);
        query.setResultTransformer(Transformers.aliasToBean(book.class));
//        query.setFirstResult((page - 1) * limit).setMaxResults(limit);

        return query.list();
    }
}
