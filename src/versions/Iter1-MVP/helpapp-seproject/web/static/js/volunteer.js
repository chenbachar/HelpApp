function changeImg(){
	var img=document.getElementById("imgStatus");
	if(img.src.match("OFF")){
		document.getElementById("status").innerHTML = "הסטטוס שלך: פעיל";
		img.src="/static/img/ON.jpg";
	}
	else{
		document.getElementById("status").innerHTML = "הסטטוס שלך: לא פעיל";
		img.src="/static/img/OFF.jpg";
	}
}

