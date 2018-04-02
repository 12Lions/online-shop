/**
 * 
 */
package cm.tke.onlineshopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cm.tke.onlineshopbackend.dao.CategoryDAO;
import cm.tke.onlineshopbackend.dto.Category;

/**
 * @author 12Lions
 *
 */

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		
		//ajout de la catégorie 1 ******************
		category.setId(1);
		category.setName("Television");
		category.setDescription("Television de tres bonne qualite et a petit prix !");
		category.setImageURL("CAT_1.png");
		
		//ajout à la liste
		categories.add(category);
		
		
		// catégorie 2 ***************************
		category = new Category();
		category.setId(2);
		category.setName("Telephone");
		category.setDescription("Telephone de tres bonne qualite et a petit prix !");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		
		// catégorie 3 ***********************
		category = new Category();
		category.setId(3);
		category.setName("Ordinateur");
		category.setDescription("Ordinateur de tres bonne qualite et a petit prix !");
		category.setImageURL("CAT_3.png");
				
		categories.add(category);
		
		
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category category : categories){			
			if(category.getId() == id) return category;			
		}
		return null;		
	}
	
	

}
