/**
 * 
 */
package cm.tke.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cm.tke.onlineshopbackend.dao.ProductDAO;
import cm.tke.onlineshopbackend.dto.Product;

/**
 * @author 12Lions
 *
 */

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/voir/tous/produits")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();		
	} 
	
	@RequestMapping("/voir/categorie/{id}/produits")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id){
		
		return productDAO.listActiveProductsByCategory(id);		
	} 
	
	
	
	
	
	
	
	
}
