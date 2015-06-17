$(function(){ //this is jQuery's short notation for "fire all this when page is ready"
  $('#updateButton').on('click', updateUser);
});

function changeImg(){
	var img = document.getElementById("imgStatus");
	var st = "true";
	if(img.src.match("ON")){
		img.src="/static/img/OFF.PNG";
		st = "false";
	}
	else{
		img.src="/static/img/ON.PNG";
		st = "true";
	}
	
	 $.ajax({
		url:'/setStatus',
		type:'GET',
		dataType:'json',
        data:{stat:st},
		success:function(data, status, xhr) {
			//alert('סטטוס השתנה');
		},
		error:function(xhr, status, error) {
            alert(xhr.responseText);
		}
	});
}

function updateUser(){
	var name = $('#firstName').val();
	var car = document.getElementById('carReq').checked;
	
	 $.ajax({
		url:'/update_user',
		type:'GET',
		dataType:'json',
        data:{name:name, car:car},
		success:function(data, status, xhr) {
			if (data.status == 'ok')
			{
				alert("פרטיך עודכנו");
				location.reload();
				return;
			}
		},
		error:function(xhr, status, error) {
            alert(xhr.responseText);
		}
	});	
}