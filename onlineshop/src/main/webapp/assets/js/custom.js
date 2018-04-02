$(function() {
	
	//Menu actif
	switch(menu){
		
		case 'A Propos de nous':
			$('#about').addClass('nav-link active');
			break;
			
		case 'Contact':
			$('#contact').addClass('nav-link active');
			break;
			
		case 'Tous les produits':
			$('#listProducts').addClass('nav-link active');
			break;
			
		defauft:
			$('#home').addClass('nav-link active');
			$('#a_'+menu).addClass('active');
			break;
	}
	
});