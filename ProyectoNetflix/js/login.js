
var url = 'http://localhost:3000/api/';
var user = localStorage.getItem("usuario");
if(user != null) {
    window.location.href = "peliculas.html";
}

// esto es para fetch
function btnCambio(num) {
    
    let btnLogin = document.getElementById("btnCambioLogin");
    let btnRegistro = document.getElementById("btnCambioRegistro");
    let Login = document.getElementById("btnLogin");
    let Registro = document.getElementById("btnRegistro");

    if(num == 1) {
        btnLogin.style.display = "none";
        btnRegistro.style.display = "block";
        Registro.style.display = "none";
        Login.style.display = "block";
    }
    if(num == 2) {
        btnLogin.style.display = "block";
        btnRegistro.style.display = "none";
        Login.style.display = "none";
        Registro.style.display = "block";
    }

}
 function login () {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    var data = {
        username: username,
        password: password
    };

    fetch(url + "usuario/login", {
    method: 'POST', // or 'PUT'
    body: JSON.stringify(data), // data can be `string` or {object}!
    headers:{
        'Content-Type': 'application/json'
    }
    }).then(res => res.json())
    .catch(error => {
        alert("usuario no existente")

    }).then(response => {
        if(response.ok == false) {
            alert("usuario no existente")

            return;
        }
        alert("Bienvenido")
        window.location.href = "peliculas.html";
        localStorage.setItem("usuario", JSON.stringify(response.usuario));
        console.log('Success:', response)

    });
 }

 function insert () {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    var data = {
        username: username,
        password: password
    };

    fetch(url + "usuario", {
    method: 'POST', // or 'PUT'
    body: JSON.stringify(data), // data can be `string` or {object}!
    headers:{
        'Content-Type': 'application/json'
    }
    }).then(res => res.json())
    .catch(error => {
        alert("No se pudo llevar acabo el registro")

    }).then(response => {
        if(response.ok == false) {
            alert("No se pudo llevar acabo el registro")

            return;
        }
        alert("Registro Exitoso")
        location.reload();
    });
 }