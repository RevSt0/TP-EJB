package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "USER_EJB")
public class UserService implements IDao<User>, IDaoLocal<User> {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public User create(User u) {
		em.persist(u);

		return u;
	}

	@Override
	@PermitAll
	public User delete(User u) {
		User u1 = em.find(User.class, u.getId());
		if(u1!=null) {
			em.remove(u1);
			return u1;
		}
		return null;
		
	}

	@Override
	@PermitAll
	public User update(User u) {
		User u1 = em.find(User.class, u.getId());
		if(u1!=null) {
			u1.setLogin(u.getLogin());
			u1.setPassword(u.getPassword());
			u1.setRoles(u.getRoles());
		
		
			return u1;
		}
		return null;
	}

	@Override
	@PermitAll
	public User findById(int id) {
		return em.find(User.class, id);
	}

	@Override
	@PermitAll
	public List<User> findAll() {
		Query query = em.createQuery("select u from User u");
		return query.getResultList();
	}

}
