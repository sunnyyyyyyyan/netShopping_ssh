package com.dao.impl;

import com.dao.DoEvaluateDao;
import com.po.DoEvaluate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DoEvaluateDaoImpl implements DoEvaluateDao {
    private SessionFactory sessionFactory;//接收注入sessonFactory；
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<DoEvaluate> getData(String sql) {
        List<DoEvaluate> list=new ArrayList<>();//接口中只有方法和常量，没有构造方法；类是接口的实现类；隐式转换类型
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
    public boolean addDoEvaluate(DoEvaluate doEvaluate) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //添加用户
            session.save(doEvaluate);
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
    public boolean delDoEvaluate(DoEvaluate doEvaluate) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //删除用户
            session.delete(doEvaluate);
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
    public boolean updateDoEvaluate(DoEvaluate doEvaluate) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //修改用户
            session.update(doEvaluate);
            transaction.commit();
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return isSuccess;
    }
}
