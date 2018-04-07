/**
 * 
 */
package cm.tke.onlineshopbackend.dao;

import java.util.List;

import cm.tke.onlineshopbackend.dto.Product;

/**
 * @author 12Lions
 *
 */

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	List<Product> getProductsByParam(String param, int count);	
	
	
	// Methodes particulières
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}
