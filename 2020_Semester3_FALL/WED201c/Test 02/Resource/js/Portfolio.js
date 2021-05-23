var x = true;

function show(){
	if (x){
		document.getElementById('team').style.display = "inline-block";
		document.getElementById('myform').style.display  = "inline-block";
		document.getElementById('showmore').innerHTML = "SHOW LESS";
		x = false ;
}
	else{
		document.getElementById('team').style.display = "none";
		document.getElementById('myform').style.display  = "none";
		document.getElementById('showmore').innerHTML = "SHOW MORE";
		x = true ;
	} 
	
}

function check(){
        var email = document.getElementById('email').value;

        if (email == "" || email == null){
        	alert("Please fill your email");       	
        }
}