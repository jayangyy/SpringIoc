package com.commmon.domains;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("deprecation")
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    
    static
    {
        try
        {
            Configuration config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
        }
        catch(Throwable e)
        {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static final ThreadLocal session = new ThreadLocal();
    
    public static Session currentSession() throws HibernateException
    {
        Session s = (Session)session.get();
        //Open a new Session,if this Thread has none yet
        if(s == null || !s.isOpen())
        {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }
    
    public static void closeSession() throws HibernateException
    {
        Session s = (Session)session.get();
        session.set(null);
        if(s != null)
            s.close();
    }

}