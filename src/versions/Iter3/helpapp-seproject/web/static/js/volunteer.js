$(function(){ //this is jQuery's short notation for "fire all this when page is ready"
  $('#updateButton').on('click', updateUser);
  loadName();
});

function changeImg(){
	var img=document.getElementById("imgStatus");
	if(img.src.match("OFF")){
		document.getElementById("status").innerHTML = "הסטטוס שלך: פעיל";
		img.src="/static/img/OFF.jpg";
	}
	else{
		document.getElementById("status").innerHTML = "הסטטוס שלך: לא פעיל";
		img.src="/static/img/ON.jpg";
	}
}

function loadName(){
	var name = document.getElementById("firstName").value;
	
	if(name!="None")
	{
	name = "{{name}}";
	}
	else
	{
	name = "";
	}
	
	var phone = document.getElementById("phone").value;
	if(phone!="0")
	{
	phone = "{{phone}}";
	}
	else
	{
	phone = "";
	}
}

function updateUser(){
	var name = $('#firstName').val();
	var phone = $('#phone').val();
	var car = document.getElementById('carReq').checked;
	
	 $.ajax({
		url:'/update_user',
		type:'GET',
		dataType:'json',
        data:{name:name, phone:phone, car:car},
		success:function(data, status, xhr) {
			if (data.status == 'ok')
				{
					alert("פרטיך עודכנו");
					return;
				}
		},
		error:function(xhr, status, error) {
            alert(xhr.responseText);
		}
	});	
}