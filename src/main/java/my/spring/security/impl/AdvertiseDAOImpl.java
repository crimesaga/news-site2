package my.spring.security.impl;

import org.hibernate.SessionFactory;

import my.spring.security.entity.Advertise;

public class AdvertiseDAOImpl extends GenericHibernateDAO<Advertise, Integer>{

    public AdvertiseDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        // TODO Auto-generated constructor stub
    }

}
