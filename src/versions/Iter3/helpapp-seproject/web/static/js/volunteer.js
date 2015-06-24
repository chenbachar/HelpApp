$( document ).ready(function() {
	$('#updateButton').on('click', updateUser);  
	showRequest();
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

function setCity(){
	var city = $('#city').val();
	$.ajax({
		url:'/setCity',
		type:'GET',
		dataType:'json',
		data:{city:city},
		success:function(data, status, xhr) {
			location.reload();
		},
		error:function(xhr, status, error) {
			alert(xhr.responseText);
		}
	});
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

function addCity(city) {
	if(city == "100")
		return "כל האזורים";
	else if(city == "1")
		return "צפון";
	else if(city == "2")
		return "חיפה והסביבה";	
	else if(city == "3")
		return "קריות והסביבה";
	else if(city == "4")
		return "עכו - נהריה והסביבה";
	else if(city == "5")
		return "גליל עליון";
	else if(city == "6")
		return "הכנרת והסביבה";
	else if(city == "7")
		return "כרמיאל והסביבה";
	else if(city == "8")
		return "נצרת - שפרעם והסביבה";
	else if(city == "9")
		return "ראש פינה החולה";
	else if(city == "10")
		return "גליל תחתון";
	else if(city == "11")
		return "הגולן";
	else if(city == "12")
		return "חדרה זכרון ועמקים";
	else if(city == "13")
		return "זכרון וחוף הכרמל";
	else if(city == "14")
		return "חדרה והסביבה";
	else if(city == "15")
		return "קיסריה והסביבה";
	else if(city == "16")
		return "יקנעם טבעון והסביבה";
	else if(city == "17")
		return "עמק בית שאן";
	else if(city == "18")
		return "עפולה והעמקים";
	else if(city == "19")
		return "רמת מנשה";
	else if(city == "20")
		return "השרון";
	else if(city == "21")
		return "נתניה והסביבה";
	else if(city == "22")
		return "רמת השרון - הרצליה";
	else if(city == "23")
		return "רעננה - כפר סבא";
	else if(city == "24")
		return "הוד השרון והסביבה";
	else if(city == "25")
		return "דרום השרון";
	else if(city == "26")
		return "צפון השרון";
	else if(city == "27")
		return "מרכז";
	else if(city == "28")
		return "תל אביב";
	else if(city == "29")
		return "ראשון לציון והסביבה";
	else if(city == "30")
		return "חולון - בת ים";
	else if(city == "31")
		return "רמת גן - גבעתיים";
	else if(city == "32")
		return "פתח תקווה והסביבה";
	else if(city == "33")
		return "ראש העין והסביבה";
	else if(city == "34")
		return "בקעת אונו";
	else if(city == "35")
		return "רמלה - לוד";
	else if(city == "36")
		return "בני ברק - גבעת שמואל";
	else if(city == "37")
		return "עמק  איילון";
	else if(city == "38")
		return "שוהם והסביבה";
	else if(city == "39")
		return "מודיעין והסביבה";
	else if(city == "40")
		return "אזור ירושלים";
	else if(city == "41")
		return "ירושלים";
	else if(city == "42")
		return "בית שמש והסביבה";
	else if(city == "43")
		return "הרי יהודה - מבשרת והסביבה";
	else if(city == "44")
		return "מעלה אדומים והסביבה";
	else if(city == "45")
		return "יהודה שומרון ובקעת הירדן";
	else if(city == "46")
		return "ישובי דרום ההר";
	else if(city == "47")
		return "ישובי שומרון";
	else if(city == "48")
		return "גוש עציון";
	else if(city == "49")
		return "בקעת הירדן וצפון ים המלח";
	else if(city == "50")
		return "אריאל וישובי יהודה";
	else if(city == "51")
		return "שפלה מישור חוף דרומי";
	else if(city == "52")
		return "נס ציונה - רחובות";
	else if(city == "53")
		return "אשדוד - אשקלון והסביבה";
	else if(city == "54")
		return "גדרה - יבנה והסביבה";
	else if(city == "55")
		return "קרית גת והסביבה";
	else if(city == "56")
		return "שפלה";
	else if(city == "57")
		return "דרום";
	else if(city == "58")
		return "באר שבע והסביבה";
	else if(city == "59")
		return "אילת וערבה";
	else if(city == "60")
		return "ישובי הנגב";
	else if(city == "61")
		return "הנגב המערבי";
	else if(city == "62")
		return "דרום ים המלח";	
}

function addCar(needCar) {
	if(needCar == true)
		return "V";
	else
		return "X";
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
			document.getElementById(data.city).selected = true;
		},
		error:function(xhr, status, error) {
            alert(xhr.responseText);
		}
	});	
}
