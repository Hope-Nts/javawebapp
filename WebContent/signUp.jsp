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
    <title>Document</title>
  </head>
  <body>
    <main class="signUp-main">
      <div class="signUp-section">
        <div class="signUp-logo">
          <img src="./img/LOGO.png" alt="" />
        </div>
        <div class="tab-menu">
          <button
            class="tabButtons"
            onclick="showUserForm(event, 'Company')"
            id="defaultOpen"
          >
            Company
          </button>
          <button class="tabButtons" onclick="showUserForm(event, 'Prospect')">
            Prospect
          </button>
          <button
            class="tabButtons"
            onclick="showUserForm(event, 'Professional')"
          >
            Professional
          </button>
          <button class="tabButtons" onclick="showUserForm(event, 'Advisor')">
            Advisor
          </button>
          <button class="tabButtons" onclick="showUserForm(event, 'Investor')">
            Investor
          </button>
        </div>
        <div id="Company" class="signUpForm">
          <form action="signUpServlet" method="POST">
            <label>Name</label>
            <input type="text" />
            <label>Industry</label>
            <select name="industry" id="">
              <option value="IT Infrastructure">IT Infrastructure</option>
              <option value="Software Development">Software Development</option>
            </select>
            <label>Email</label>
            <input type="text" />
            <label>Password</label>
            <input type="text" />
            <label>Phone</label>
            <input type="text" />
            <label>Address</label>
            <input type="text" />
            <label>Porfolio</label>
            <input type="file" />
            <label>Display Picture</label>
            <input type="file" />
            <label>Description</label>
            <textarea name="Description" rows="10" cols="30">
Description</textarea
            >
            <input type="submit" name="" id="" />
          </form>
        </div>
        <div id="Prospect" class="signUpForm">
          <form action="signUpServlet" method="POST">
            <label>Company</label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <input type="submit" name="" id="" />
          </form>
        </div>
        <div id="Professional" class="signUpForm">
          <form action="signUpServlet" method="POST">
            <label>Company</label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <input type="submit" name="" id="" />
          </form>
        </div>
        <div id="Advisor" class="signUpForm">
          <form action="signUpServlet" method="POST">
            <label>Company</label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <input type="submit" name="" id="" />
          </form>
        </div>
        <div id="Investor" class="signUpForm">
          <form action="signUpServlet" method="POST">
            <label>Company</label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <label></label>
            <input type="text" />
            <input type="submit" name="" id="" />
          </form>
        </div>
      </div>
    </main>
  </body>
</html>
