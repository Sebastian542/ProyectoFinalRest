<!DOCTYPE html>
<html lang="en">
<head>

    <title>Login</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="assets/fonts/icomoon/style.css">

    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <!-- Style -->
    <link rel="stylesheet" href="assets/css/stylelogin.css">

    <title>Login #2</title>
</head>
<body>

<div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('assets/img/features-1.png');"></div>
    <div class="contents order-2 order-md-1">

        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-7">
                    <h3>Bienvenido al login</h3>
                    <p class="mb-4">A continuación ingrese sus credenciales .</p>

                    <form id="form" >

                        <div class="form-group first">
                            <label for="email">Email</label>
                            <input type="email" name="email"class="form-control" placeholder="Ingrese su email " id="email" required />

                            <label for="password">Contraseña</label>
                            <input type="password" name="password" class="form-control" placeholder="Ingrese su contraseña" id="password"required >
                        </div>


                        <div class="d-flex mb-5 align-items-center">
                            <label class="control control--checkbox mb-0"><span class="caption">Recordarme</span>
                                <input type="checkbox" checked="checked"/>
                                <div class="control__indicator"></div>
                            </label>
                            <span class="ml-auto"><a href="#" class="forgot-pass">Olvido su contraseña</a></span>
                        </div>

                        <input type="submit" value="Login" class="btn btn-block btn-primary">

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    let avatarForm = document.getElementById("form");

    // Triggering event when submit
    avatarForm.onsubmit = async (e) => {
        e.preventDefault();

        // Making the request
        var data={
            "email": document.getElementById("email").value,
            "password": document.getElementById("password").value,

        }

        let response = await fetch("./api/users/autenticar", {
            method: "POST",
            headers:{
                "Content-type":"application/json"
            },
            body: JSON.stringify(data)

        })
            .then(res => res.json())
            .then(data2 => {
                console.log(data2);


                localStorage.setItem("name",data2.name);
                console.log("Localstorage name: " + localStorage.getItem("name"));
                localStorage.setItem("email",data2.email);
                console.log("Localstorage email: " + localStorage.getItem("email"));
                localStorage.setItem("role",data2.role);
                console.log("Localstorage role: " + localStorage.getItem("role"));


                if(data2.role =="Administrador"){

                    window.location.href = "home.html";

                }else if(data2.role =="Artista"){

                    window.location.href = "home2.html";

                }
            })
    };


</script>



</body>
</html>