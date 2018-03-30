$(function() {
	
	//Menu actif
	switch(menu){
		
		case 'A Propos de nous':
			$('#about').addClass('active');
			break;
			
		case 'Nous contacter':
			$('#contact').addClass('active');
			break;
			
		defauft:
			$('#home').addClass('active');
			break;
	}
}
		
);