package my.spring.security.impl;

import org.hibernate.SessionFactory;

import my.spring.security.entity.ViewCount;

public class ViewCountDAOImpl extends GenericHibernateDAO<ViewCount, Integer> implements ViewCountDAO{

    public ViewCountDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        // TODO Auto-generated constructor stub
    }

}
