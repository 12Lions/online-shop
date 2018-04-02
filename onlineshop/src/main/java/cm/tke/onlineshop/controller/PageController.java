package cm.tke.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cm.tke.onlineshopbackend.dao.CategoryDAO;
import cm.tke.onlineshopbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	

	@RequestMapping(value = {"/", "/accueil", "/index"})
	public ModelAndView index(){		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Accueil");
		
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
	 * Methodes pour cherger tous les produits en fonction de la categorie
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
	
	
	
	
	
	
	
	
}
