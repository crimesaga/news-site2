package my.spring.security.impl;

import org.hibernate.SessionFactory;

import my.spring.security.entity.Role;
import my.spring.security.entity.User;

public class RoleDAOImpl extends GenericHibernateDAO<Role, Integer> implements RoleDAO{

    public RoleDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        // TODO Auto-generated constructor stub
    }

}
