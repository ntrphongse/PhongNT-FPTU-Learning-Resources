function Show() {
    var myForm = document.getElementById("myform");
    var textShow = document.getElementById("mytext");
    if (myForm.style.display === "block") {
        myForm.style.display = "none";
        textShow.innerHTML = "Show Register Form";
    } else {
        myForm.style.display = "block";
        textShow.innerHTML = "Hide Register Form";
    }
}

function checkForm() {
    var name = document.getElementById("t1");
    var email = document.getElementById("t2");
    var result = document.getElementById("result");
    if (name.value == "") {
        result.innerHTML = "Name cannot be empty!";
    } else if (email.value == "") {
        result.innerHTML = "Email cannot be empty!!";
    }
    else {
        result.innerHTML = "";
    }
}

