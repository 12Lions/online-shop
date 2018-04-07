$(function() {
	
	// menu actif
	switch (menu) {

	case 'A Propos de nous':
		$('#about').addClass('active');
		break;
		
	case 'Contact':
		$('#contact').addClass('active');
		break;
		
	case 'Tous les produits':
		$('#listProducts').addClass('active');
		break;
			
	default:
		if (menu == "Accueil")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// jQuery dataTable
	var $table = $('#productListTable');

		// uniquement dans le table
	if ($table.length) {
		 //console.log('Inside the table!');
		 
		var jsonUrl = '';
		
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/voir/tous/produits';				
		}else{
			jsonUrl = window.contextRoot + '/json/data/voir/categorie/'+ window.categoryId +'/produits';
		}
		
		
		
		 $table.DataTable( {
			 
			 lengthMenu: [ [3,5,10,-1], ['03 Produits','05 Produits','10 Produits','Tous les produits'] ],
			 pageLength: 5,
			 ajax: {				 
				 url: jsonUrl,
				 dataSrc: ''
			 },
			 columns: [		
			           	   {
			           		   data: 'code',
			           		   mRender: function(data, type, row){
			           			   return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
			           		   }
			           	   },
				           {
				        	   data: 'name'			        	   
				           },
				           {
				        	   data: 'brand'			        	   
				           },			           
				           {
				        	   data: 'unitPrice',
				        	   mRender: function(data, type, row){
				        		   return data + ' FCFA'
				        	   }
				           },	
				           {
				        	   data: 'quantity',
				        	   mRender: function(data, type, row){
				        		   
				        		   if(data < 1){
				        			   return '<span style="color:red">En rupture de stock !</span>';				        			   
				        		   }
				        		   
				        		   return data;
				        	   }
				           },
				           {
				        	   data: 'id',
				        	   bSortable: false,
				        	   mRender: function(data, type, row){
				        		   var str = '';
				        		   str += '<a href="'+window.contextRoot+'/voir/'+data+'/produits" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
				        		   
				        		   if(row.quantity < 1){
				        			   
					        		   str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a> &#160;';

				        		   }else{
				        			   
					        		   str += '<a href="'+window.contextRoot+'/panier/ajouter/'+data+'/produits" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a> &#160;';

				        		   }			        		   
				        		   
				        		   
				        		   return str;
				        		   
				        	   }
				           }
			           
			           ]
			 
			 
			 
		 });

	}
	
			
});