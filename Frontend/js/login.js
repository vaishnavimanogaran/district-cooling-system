function login(){

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if(username === "admin" && password === "admin123"){
        window.location.href = "dashboard.html";
    }else{
        document.getElementById("msg").innerText =
        "Invalid username or password";
    }

}