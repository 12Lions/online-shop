/**
 * 
 */
package cm.tke.onlineshopbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cm.tke.onlineshopbackend.dao.CategoryDAO;
import cm.tke.onlineshopbackend.dto.Category;

/**
 * @author 12Lions
 *
 */
public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass 
	public static void init(){		
		context = new AnnotationConfigApplicationContext();
		context.scan("cm.tke.onlineshopbackend");
		context.refresh();		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");		
	}
		 
	
/*	@Test
	public void testAddCategory(){
		
		category = new Category();	
		
		category.setName("Laptop");
		category.setDescription("Laptop television");
		category.setImageURL("CAT_3.png");
		
		assertEquals("Catégorie ajoutée avec succès !",true,categoryDAO.add(category));
		
	}
*/
	
/*	@Test
	public void testGetCategory(){
		
		category = categoryDAO.get(1);
		
		assertEquals("Catégorie trouvée avec succès !","Laptop",category.getName());
	}
*/
	
/*	@Test
	public void testUpdateCategory(){
		
		category = categoryDAO.get(1);
		
		category.setName("TV");
		
		assertEquals("Catégorie mofifier avec succès !",true,categoryDAO.update(category));
	}
*/
	
/*	@Test
	public void testDeleteCategory(){
		
		category = categoryDAO.get(1);				
		assertEquals("Catégorie supprimée avec succès !",true,categoryDAO.delete(category));
	}
	
*/	
	
/*	@Test
	public void testListCategory(){
		
		assertEquals("Liste des catégories trouvée avec succès !",3,categoryDAO.list().size());
	}
*/
	
	@Test
	public void testCRUDCategory(){
		
		//ajout 
		category = new Category();	
		
		category.setName("Laptop");
		category.setDescription("Description Laptop");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Catégorie ajoutée avec succès !",true,categoryDAO.add(category));
		
		
		category = new Category();	
		
		category.setName("Television");
		category.setDescription("Description Television");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Catégorie ajoutée avec succès !",true,categoryDAO.add(category));
		
		
		//Recherche et modification d'une catégorie
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Catégorie mofifier avec succès !",true,categoryDAO.update(category));
		
		
		//suppression d'une catégorie
		assertEquals("Catégorie supprimée avec succès !",true,categoryDAO.delete(category));
		
		
		//recherche de la liste
		assertEquals("Liste des catégories trouvée avec succès !",1,categoryDAO.list().size());
		
	}
	
}
