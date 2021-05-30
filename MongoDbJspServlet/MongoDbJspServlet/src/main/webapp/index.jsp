<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="../css/dashBoard.css">
    <title>DashBoard</title>
</head>
<body>
     <div class="navbar container-fluid">
         <div class="row icons my-1">
             <a href="dashBoard.html" class="px-4 text-center active Link">
                 <i class="fas fa-home mr-2 mb-2"></i>
                 <b>Home</b>
             </a>
             <a href="#" class="px-4  text-center Link" >
                 <i class="fas fa-sign-in-alt mr-2 mb-2"></i>
                 <b>Login</b>
             </a>
             <a href="#" class="px-4   text-center Link" >
                <i class="fas fa-registered mr-2 mb-2"></i>
                <b>Register</b>
            </a>
            <a href="attemptQuiz.html" class="px-4   text-center Link" >
                <i class="fas fa-atom mr-2 mb-2"></i>
                <b>Take a Quiz</b>
            </a>
            <a href="./createQuiz.html" class=" px-4  text-center Link" >
                <i class="fab fa-quinscape mr-2 mb-2"></i>
                <b>Create Quiz</b>
            </a>
         </div>
     </div>

     <div class="container-fluid cbox">
          <h1 class="row text-center">
              <span class="offset-3 col-6 tittle">
                  Tittle of Web-App
              </span>
          </h1>

          <h4 class="row text-center">
              <a href="attemptQuiz.html" class="offset-3 col-3 mr-2 subTittle ">
                 Attempt A Quiz
              </a>
              <a href="./createQuiz.html" class="ml-2 col-3 subTittle">
                Create A Quiz
              </a>
          </h4>
     </div>

     <footer>
        <div class="container-fluid "> 
           
            <div class="row  ml-4 pt-2 social">
                 <small class="pt-2">Let's Connect with Each other</small>
                <a href="#" class="pl-4 pr-2"><i class="fab fa-instagram"></i></a>
                <a href="#" class="pl-1 pr-2"><i class="fab fa-facebook"></i></a>
                <a href="#" class="pl-1 pr-2"><i class="fab fa-twitter"></i></a>
                <a href="#" class="pl-1 pr-2"><i class="fab fa-github"></i></a>

                <div class="sub">
                    <input class="mt-3 p-1" type="text" placeholder="Enter your Email"><br>
                    <label class="pl-1 pt-1">Subscribe For More</label>
                    <i class="fa fa-paper-plane p py-2   pl-3"></i>
                </div>
            </div>

            <div class="row ml-4 pt-3 pb-5" style="opacity: 0.5;">
                @ All the Copywrites are Reserved and being Issued .
            </div>
        </div>
     </footer>
</body>
</html>