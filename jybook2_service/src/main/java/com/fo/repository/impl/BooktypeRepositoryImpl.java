package com.fo.repository.impl;

import com.fo.Utils.WhereUtils;
import com.fo.entity.book;
import com.fo.entity.booktype;
import com.fo.repository.BooktypeRepository;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jdd on 2018/6/28.
 */
@Repository
public class BooktypeRepositoryImpl implements BooktypeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public booktype load(Integer id) {
        return (booktype)getCurrentSession().load(booktype.class,id);
    }

    public booktype get(Integer id) {
        return (booktype)getCurrentSession().get(booktype.class,id);
    }

//    public List<booktype> findAll() {
//
//        Query q=getCurrentSession().createQuery("from booktype b order by b.sort ");
//
//        List<booktype> list=q.list();
//
//        return list;
//    }

    public void persist(booktype entity) {
        getCurrentSession().persist(entity);
    }

    public Integer save(booktype entity) {
        return (Integer)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(booktype entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        booktype _booktype = load(id);
        getCurrentSession().delete(_booktype);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    public List<booktype> findAll() {
//        Query q=getCurrentSession().createQuery("from book b where b.type=?");
//        q.setInteger(0,type);
//
//        return q.list();

        String sql="select n_id as id,s_type as type,n_sort as sort,s_remark as remark from jy_booktype ";
        WhereUtils where = WhereUtils.ins(sql);
        where.addOrderBy(" ORDER BY n_sort");

        SQLQuery query=getCurrentSession().createSQLQuery(where.getAllSql());
        List list2 = where.getParms();
        for (int i = 0; i < list2.size(); i++) {
            query.setParameter(i, list2.get(i));
        }
        query.addScalar("id", StandardBasicTypes.INTEGER);
        query.addScalar("type", StandardBasicTypes.STRING);
        query.addScalar("sort", StandardBasicTypes.INTEGER);
        query.addScalar("remark", StandardBasicTypes.STRING);
        query.setResultTransformer(Transformers.aliasToBean(booktype.class));
        query.setFirstResult(2).setMaxResults(2);
//        query.setFirstResult((page - 1) * limit).setMaxResults(limit);

        List<booktype> list3=query.list();

//        List<Object[]> list= query.list();
//        for (Object[] os : list) {
//            for (Object filed: os) {
//                System.out.print(filed+"\t");
//            }
//            System.out.println();
//        }

        return list3;
    }


}
