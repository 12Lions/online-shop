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
	
	List<Category> list();
	
	Category get(int id);
}
