$(document).ready(function(){
	var photoHeader = document.getElementById("headerPic");
	var photoFooter = document.getElementById("footerPic");
	var imgHeader = new Image();
	var imgFooter = new Image();
	imgHeader.src='';
	imgFooter.src='';
	if(screen.availWidth > 800) //800 is the width of computers and tablets
	{	
		imgHeader.src = "/static/img/indexHeader2.png";
		imgFooter.src = "/static/img/footer2.png";
		document.getElementById("footer").style.background="url('/static/img/footer2.png')";
	}
	else
	{
		imgHeader.src = "/static/img/indexHeader.png";
		imgFooter.src = "/static/img/footer.png";
	}
	photoHeader.src = imgHeader.src;
	photoFooter.src = imgFooter.src;
});