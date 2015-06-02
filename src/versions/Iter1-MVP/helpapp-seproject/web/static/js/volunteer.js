function getName(){
	document.getElementById("title").innerHTML = "ברוך הבא";
}

function changeImg(){
	var img=document.getElementById("imgStatus");
	if(img.src.match("OFF")){
		img.src="/static/img/ON.jpg";
	}
	else{
		img.src="/static/img/OFF.jpg";
	}
}

