$(function() {  //this is jQuery's short notation for "fire all this when page is ready"
    $('#search').on('click', submitRequest);
});

function submitRequest() {
    var description = $('#description').val();
	var city = $('#city').val();
	var phone = $('#phone').val();
	var car = document.getElementById('carReq').checked;
	
	if(city=="בחר עיר")
	{
		alert("אנא בחר עיר");
		return;
	}
	
	if(phone == "")
	{
		alert("אנא הכנס מספר טלפון");
		return;
	}
	
    $.ajax({
		url:'/add_request',
		type:'GET',
		dataType:'json',
        data:{description:description, city:city, phone:phone, car:car},
		success:function(data, status, xhr) {
			if (data.status == 'ok')
				{
					alert("בקשתך נוספה\nמתנדב מתאים יצור איתך קשר");
					$( "#description" ).val("");
					$( "#city" ).val("בחר עיר");
					$( "#phone" ).val("");
					return;
				}
		},
		error:function(xhr, status, error) {
            alert(xhr.responseText);
		}
	});
}

