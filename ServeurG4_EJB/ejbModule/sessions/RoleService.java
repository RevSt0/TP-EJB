package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "ROLE_EJB")
public class RoleService implements IDao<Role>, IDaoLocal<Role> {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public Role create(Role r) {
		em.persist(r);

		return r;
	}

	@Override
	@PermitAll
	public Role delete(Role r) {
		Role r1 = em.find(Role.class, r.getId());
		if(r1!=null) {
			em.remove(r1);
			return r1;
		}
		return null;
		
	}

	@Override
	@PermitAll
	public Role update(Role r) {
		Role r1 = em.find(Role.class, r.getId());
		if(r1!=null) {
			r1.setName(r.getName());
			r1.setUsers(r.getUsers());
		
			return r1;
		}
		return null;
	}

	@Override
	@PermitAll
	public Role findById(int id) {
		return em.find(Role.class, id);
	}

	@Override
	@PermitAll
	public List<Role> findAll() {
		Query query = em.createQuery("select r from Role r");
		return query.getResultList();
	}

}
