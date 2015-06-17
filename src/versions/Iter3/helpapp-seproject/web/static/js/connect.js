$(function(){ //this is jQuery's short notation for "fire all this when page is ready"
	var google = document.getElementById("gconnect");
	var googleLogin = new Image();
	googleLogin.src='';
	if(screen.availWidth > 800) //800 is the width of computers and tablets
	{	
		googleLogin.src = "/static/img/glogin.png";
	}
	else
	{
		googleLogin.src = "/static/img/glogin_mobile.png";
	}
	google.src = googleLogin.src;
});
