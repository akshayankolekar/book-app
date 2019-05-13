package user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import user.model.User;

@Repository
public class UserImpl implements IUser{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public User getUserById(int id) {
		NativeQuery<User> query = (NativeQuery<User>) em.createNamedQuery("getUserById", User.class);
		query.setParameter("id", id);
		User user = (User) query.getResultList().get(0);
		return user;
	}

	@Override
	@Transactional
	public void registerUser(User user) {
		try {
			em.persist(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public User getUserByUserID(String id) {
		NativeQuery<User> query = (NativeQuery<User>) em.createNamedQuery("getUserByUserID", User.class);
		query.setParameter("userID", id);
		List<User> users = (List<User>) query.getResultList();
		if(users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
