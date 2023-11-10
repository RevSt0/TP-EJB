package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Student;
import entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "STUDENT_EJB")
public class StudentService implements IDao<Student>, IDaoLocal<Student> {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public Student create(Student s) {
		em.persist(s);

		return s;
	}

	@Override
	@PermitAll
	public Student delete(Student s) {
		Student s1 = em.find(Student.class, s.getId());
		if(s1!=null) {
			em.remove(s1);
			return s1;
		}
		return null;
		
	}

	@Override
	@PermitAll
	public Student update(Student s) {
		Student s1 = em.find(Student.class, s.getId());
		if(s1!=null) {
			s1.setFirstname(s.getFirstname());
			s1.setLastname(s.getLastname());
			s1.setLogin(s.getLogin());
			s1.setPassword(s.getPassword());
		
			return s1;
		}
		return null;
	}

	@Override
	@PermitAll
	public Student findById(int id) {
		return em.find(Student.class, id);
	}

	@Override
	@PermitAll
	public List<Student> findAll() {
		Query query = em.createQuery("select s from Student s");
		return query.getResultList();
	}

}
