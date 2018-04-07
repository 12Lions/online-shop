/**
 * 
 */
package cm.tke.onlineshopbackend.dao;

import java.util.List;

import cm.tke.onlineshopbackend.dto.Category;

/**
 * @author 12Lions
 *
 */

public interface CategoryDAO {
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);	
	boolean update(Category category);
	boolean delete(Category category);
	
}
