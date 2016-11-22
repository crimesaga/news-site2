package my.spring.security.impl;

import org.hibernate.SessionFactory;

import my.spring.security.entity.User;

//What happens if it is GenericHibernateDAO<Role, Integer> instead, take a look at GenericDAO
public class UserDAOImpl extends GenericHibernateDAO<User, Integer> implements UserDAO{

    public UserDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        // TODO Auto-generated constructor stub
    }

}
