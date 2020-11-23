<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap"
      rel="stylesheet"
    />
    <script src="script.js"></script>
    <link rel="stylesheet" href="./style.css" />
    <title>signIn</title>
  </head>
  <body>
    <main class="signin-main">
      <section class="login-section">
        <div class="signIn-logo">
          <img src="img/LOGO.png" alt="logo" />
        </div>
        <div class="sign-in-fields">
          <form action="loginServlet" method="GET">
            <label>Email:</label>
            <input type="email" name="email" />
            <label>Password:</label>
            <input type="password" name="password" />
            <input type="submit" value="Sign In" />
          </form>
          <div class="signUp-redirect">
            <p>Don't have an account? <a href="signUp.jsp">Sign Up</a></p>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
