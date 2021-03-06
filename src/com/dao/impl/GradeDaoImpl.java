package com.dao.impl;

import com.dao.GradeDao;
import com.po.Grade;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements GradeDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean addGrade(Grade grade) {
        boolean isSuccess=false;
        try{
            //从SessionFactory中创建session
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.save(grade); //仅仅只保存于session
            transaction.commit(); //提交到数据库
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.print(e);
        }
        return isSuccess;
    }

    @Override
    public boolean updateGrade(Grade grade) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //修改用户
            session.update(grade);
            transaction.commit();
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return isSuccess;
    }

    @Override
    public List<Grade> getGrade(String sql) {
        List<Grade> list = new ArrayList<>();
        try{
            //从SessionFactory中创建session
            Session session=sessionFactory.openSession();
            list=session.createQuery(sql).list();
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.print(e);
        }
        return list;
    }

    @Override
    public boolean delGrade(Grade grade) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //删除用户
            session.delete(grade);
            transaction.commit();
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return isSuccess;
    }

    @Override
    public List<Grade> getAllGradeData(int pageNow, int pageSize) {
        Session session = this.sessionFactory.openSession();
        String sql = "from Grade";
        Query query = session.createQuery(sql);
        query.setFirstResult((pageNow - 1) * pageSize);
        query.setMaxResults(pageSize);
        List list = query.list();
        session.close();
        session=null;
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override
    public int findAllGradeSize() {
        Session session = this.sessionFactory.openSession();
        String sql = "from Grade";
        int size = session.createQuery(sql).list().size();
        session.close();
        return size;
    }
}
