package cm.tke.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cm.tke.onlineshop.exception.ProductNotFound;
import cm.tke.onlineshopbackend.dao.CategoryDAO;
import cm.tke.onlineshopbackend.dao.ProductDAO;
import cm.tke.onlineshopbackend.dto.Category;
import cm.tke.onlineshopbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	

	@RequestMapping(value = {"/", "/accueil", "/index"})
	public ModelAndView index(){		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Accueil");
		
		logger.info("Dans la methode index de PageController - INFO");
		logger.debug("Dans la methode index de PageController - DEBUG");
		
		//parssing de la liste de categories
		mv.addObject("categories", categoryDAO.list()); 
		
		mv.addObject("userClickHome",true);
		
		return mv;
	}
	
	@RequestMapping(value = "/a-propos")
	public ModelAndView about(){		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","A Propos de nous");
		mv.addObject("userClickAbout",true);
		
		return mv;
	}	
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		
		return mv;
	}
	
	/*
	 * Methodes pour charger tous les produits en fonction de la categorie
	 * */
	
	@RequestMapping(value = "/voir/tous/produits")
	public ModelAndView showAllProducts(){		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Tous les produits");
		
		//parssing de la liste de categories
		mv.addObject("categories", categoryDAO.list()); 
		
		mv.addObject("userClickAllProducts",true);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/voir/categorie/{id}/produits")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){		
		ModelAndView mv = new ModelAndView("page");
		
		//categoryDAO pour rechercher une seule categorie
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		//parssing de la liste de categories
		mv.addObject("categories", categoryDAO.list());
		
		//parsing d'une seule categorie
		mv.addObject("category", category);

		
		mv.addObject("userClickCategoryProducts",true);
		
		return mv;
	}
	
	
	/*
	 * Vue pour un seul produit
	 * */
	
	@RequestMapping(value = "/voir/{id}/produits")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFound{
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		//Pour les erreurs d'id de produit de type int
		if (product == null) throw new ProductNotFound();  
		
		
		//mettre à jour le compteur de vue
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//------------------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);		
		
		return mv;
	}
	
	
	
	
}
