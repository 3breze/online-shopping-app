$(function() {
	// solving the active menu problem
	switch (menu) {
	case 'About':
		//u navbar ima lista: about,viewP,contact.I oni imaju svoje ids
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
	}

});