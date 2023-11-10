package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Filiere;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "FILIERE_EJB")
public class FiliereService implements IDao<Filiere>, IDaoLocal<Filiere> {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public Filiere create(Filiere f) {
		em.persist(f);

		return f;
	}

	@Override
	@PermitAll
	public Filiere delete(Filiere f) {
		Filiere f1 = em.find(Filiere.class, f.getId());
		if(f1!=null) {
			em.remove(f1);
			return f1;
		}
		return null;
		
	}

	@Override
	@PermitAll
	public Filiere update(Filiere f) {
		Filiere f1 = em.find(Filiere.class, f.getId());
		if(f1!=null) {
			f1.setCode(f.getCode());
			f1.setName(f.getName());
				
		
			return f1;
		}
		return null;
	}

	@Override
	@PermitAll
	public Filiere findById(int id) {
		return em.find(Filiere.class, id);
	}

	@Override
	@PermitAll
	public List<Filiere> findAll() {
		Query query = em.createQuery("select f from Filiere f");
		return query.getResultList();
	}

}
