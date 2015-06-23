$(function(){ //this is jQuery's short notation for "fire all this when page is ready"
  $('#updateButton').on('click', updateUser);
  //showRequest();
  addToTable("asd","asd","asd","Asd");
  addToTable("asd","asd","asd","Asd");
  addToTable("asd","asd","asd","Asd");
  
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

function updateCity(){
	var city = $('#city').val();
}

function addToTable(info,phone,city,car){
	var table = document.getElementById("data");
	var row = table.insertRow(1);
	var cell0 = row.insertCell(0);
	var cell1 = row.insertCell(1);
	var cell2 = row.insertCell(2);
	var cell3 = row.insertCell(3);
	cell0.innerHTML = car;
	cell1.innerHTML = city;
	cell2.innerHTML = phone;
	cell3.innerHTML = info;
}

function showRequest(){
	var city = $('#city').val();
	 $.ajax({
		url:'/get_requests',
		type:'GET',
		dataType:'json',
        data:{city:city},
		success:function(data, status, xhr) {
			if (data.status == 'ok')
			{
			alert("ASD");
				var i = 0;
				while(i < data.request.length)
				{
					var phoneReq = data.request[i].phone;
					var infoReq = data.request[i].description;
					var cityReq = data.request[i].city; //addCity(data.request[i].city);
					var carReq = data.request[i].isCarNeeded; //addCar(data.request[i].isCarNeeded);
					
					addToTable(infoReq,phoneReq,cityReq,carReq);
					i = i+1;
				}
			}
		},
		error:function(xhr, status, error) {
            alert(xhr.responseText);
		}
	});	
}
