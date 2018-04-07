/**
 * 
 */
package cm.tke.onlineshopbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cm.tke.onlineshopbackend.dao.CategoryDAO;
import cm.tke.onlineshopbackend.dto.Category;

/**
 * @author 12Lions
 *
 */

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);		
		
		return query.getResultList();
	}

	/*
	 * Récupérer une catégorie en fonction de l'ID
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {
			// ajouter une categorie à la base de donnée
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Mettre à jour une catégorie
	 */
	@Override
	public boolean update(Category category) {

		try {
			// ajouter une categorie à la base de donnée
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// ajouter une categorie à la base de donnée
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}
	
	
	

}
