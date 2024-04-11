package daoo;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.College;
import metier.entities.College;
import util.JPAutil;

public class CollegeDaoImpl implements ICollegeDao {
// TP6_JEE à replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
	private EntityManager entityManager = JPAutil.getEntityManager("TP6.college_JEE2");

	public College save(College col) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(col);
		tx.commit();
		return col;
	}

	public College getEnseignant(Long id) {
		return entityManager.find(College.class, id);
	}




	public College updateEnseignant(College col) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(col);
		tx.commit();
		return col;
	}


	
	public List<College> getAllEnseignant() {
		List<College> col = entityManager.createQuery("select c from College c").getResultList();
		return col;
	}

	@Override
	public College getCollege(Long id) {
		return entityManager.find(College.class, id);

	}

	@Override
	public College updateCollege(College col) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(col);
		tx.commit();
		return col;
	}

	@Override
	public void deleteCollege(Long id) {
		College college = entityManager.find(College.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(college);
		 entityManager.getTransaction().commit();
		
		
	}

	@Override
	public List<College> getAllCollege() {
		List<College> col = entityManager.createQuery("select c from College c").getResultList();
		return col;
	}
}
