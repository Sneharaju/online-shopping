$(function(){
	
	//solving active menu problem
	
	switch(menu){
	
	case 'About us':
		$('#about').addClass('active');
		break;
		
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	case 'All products':
		$('#listProducts').addClass('active');
		break;
		
	default:
		if(menu=="Home") break;
		$('#listProducts').addClass('active');
		
		$('#a_'+menu).addClass('active');
		break;
	
	}
	
});