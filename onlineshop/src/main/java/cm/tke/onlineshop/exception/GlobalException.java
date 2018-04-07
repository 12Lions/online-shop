package cm.tke.onlineshop.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	/*
	 * Gestion d'erreur du type 404 Not Found
	 * */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Erreur lors de la construction de la page !");
		
		mv.addObject("errorDescription", "Cette page n'est pas disponible");
		
		mv.addObject("title", "404 Page Not Found !");
		
		return mv;
	}
	
	/*
	 * Gestion d'erreur liée à la recherche d'un produit dont l'id est erroné mais de type int
	 * */
	@ExceptionHandler(ProductNotFound.class)
	public ModelAndView handlerProductNotFound(){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Produit non disponible");
		
		mv.addObject("errorDescription", "Le produit que vous demandez n'est pas disponible pour le moment");
		
		mv.addObject("title", "Produit non disponible");
		
		return mv;
	}
	
	/*
	 * Gestion d'erreur liée à la recherche d'un produit dont l'id est erroné mais de type String
	 * */
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Bien vouloir contacter l'administrateur");
		
		//uniquement pour le deboggage 
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription", sw.toString());
		
		mv.addObject("title", "Produit non disponible");
		
		return mv;
	}
	
	

}
