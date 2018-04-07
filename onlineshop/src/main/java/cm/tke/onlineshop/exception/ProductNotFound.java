/**
 * 
 */
package cm.tke.onlineshop.exception;

import java.io.Serializable;

/**
 * @author 12Lions
 *
 */
public class ProductNotFound extends Exception implements Serializable{
	
	/**
	 * Serial default id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Getter
	 */
	public String getMessage() {
		return message;
	}

	
	/*
	 * Atributs et methodes 
	 * */
	private String message;
	
	public ProductNotFound(){
		 this("Produit non disponible");
	}
	
	public ProductNotFound(String message){
		 this.message = System.currentTimeMillis() + ": " + message;
	}
	
	
	
}
