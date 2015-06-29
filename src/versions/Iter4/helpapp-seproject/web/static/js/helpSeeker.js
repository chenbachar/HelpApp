$(function() {  //this is jQuery's short notation for "fire all this when page is ready"
    $('#search').on('click', submitRequest);
});

function submitRequest() {
    var description = $('#description').val();
	var city = $('#city').val();
	var phone = $('#phone').val();
	var car = document.getElementById('carReq').checked;
	
	if(phone == "")
	{
		new Messi('אנא הכנס מספר טלפון', {title: 'טלפון לא תקין', titleClass: 'info', buttons: [{id: 0, label: 'סגור', val: 'X'}]});
		return;
	}
	
	if(phone.length < 9)
	{
		new Messi('אנא הכנס מספר טלפון עם 9-10 ספרות', {title: 'טלפון לא תקין', titleClass: 'anim error', buttons: [{id: 0, label: 'סגור', val: 'X'}]});
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
					new Messi('מתנדב מתאים יצור איתך קשר', {title: 'בקשתך נוספה', titleClass: 'success', buttons: [{id: 0, label: 'סגור', val: 'X'}]});
					$( "#description" ).val(""); //resetting input values
					$( "#city" ).val("100");
					$( "#phone" ).val("");
					return;
				}
		},
		error:function(xhr, status, error) {
            alert(xhr.responseText);
		}
	});
}

