package com.dao.impl;

import com.dao.SubjectDao;
import com.po.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    private SessionFactory sessionFactory;//接收注入sessonFactory；
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Subject> getData(String sql) {
        List<Subject> list=new ArrayList<>();//接口中只有方法和常量，没有构造方法；类是接口的实现类；隐式转换类型
        try{
            Session session=sessionFactory.openSession();
            //执行hql,将结果存入list
            list=session.createQuery(sql).list();
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.print(e);
        }

        return list;
    }

    @Override
    public boolean addSubject(Subject subject) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //添加用户
            session.save(subject);
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
    public boolean delSubject(Subject subject) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //删除用户
            session.delete(subject);
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
    public boolean updateSubject(Subject subject) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //修改用户
            session.update(subject);
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
    public List<Subject> getAllSubjectData(int pageNow, int pageSize) {
        Session session = this.sessionFactory.openSession();
        String sql = "select new Subject(s.subjectNo, s.subjectName, s.userId, u.username) from Subject s,User u where s.userId=u.userId";
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
    public int findAllSubjectSize() {
        Session session = this.sessionFactory.openSession();
        String sql = "from Subject";
        int size = session.createQuery(sql).list().size();
        session.close();
        return size;
    }
}
