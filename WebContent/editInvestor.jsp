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
    <header>
      <div class="nav-bar" id="navbar">
        <div class="logo-container">
          <a class="nav-link" href="index.jsp"
            ><img src="./img/LOGO.png" alt="logo"
          /></a>
        </div>
        <nav>
          <ul class="nav-links">
            <li><a class="nav-link" href="index.jsp">Home</a></li>
            <li><a class="nav-link" href="directory.jsp">Directory</a></li>
            <li><a class="nav-link" href="aboutUs.jsp">About Us</a></li>
            <li><a class="nav-link" href="#">Contact Us</a></li>
          </ul>
        </nav>
        <div class="search">
          <form action="" method="get">
            <input type="text" name="" id="" />
          </form>
        </div>
        <div class="profile">
          <div class="profile-links">
            <ul>
              <li><a class="nav-link" href="signIn.jsp">Sign out</a></li>
              <li>
                <form action="profileServlet">
                  <input type="hidden" action="profile" value="" />
                  <input type="submit" value="Profile" />
                </form>
              </li>
            </ul>
          </div>
          <img src="./img/profile.png" alt="cart" />
        </div>
      </div>
    </header>
    <main class="company-profile-main">
      <h1 class="section-heading">Profile</h1>
      <section>
        <div class="editProfileForm">
          <form action="updateServlet" method="POST">
            <input type="submit" value="Update" />
            <label>First Name</label>
            <input type="text" name="firstName" />
            <label>Last Name</label>
            <input type="text" name="lastName" />
            <label>Email</label>
            <input type="email" name="email" />
            <label>Password</label>
            <input type="password" name="password" />
            <label>Industry</label>
            <select name="industry" name="industry">
              <option value="IT Infrastructure">IT Infrastructure</option>
              <option value="Software Development">Software Development</option>
            </select>
            <label>Phone</label>
            <input type="phone" name="phoneNumber" placeholder="+267" />
            <label>Addres</label>
            <input type="text" name="address" />
            <label>Experience *Years</label>
            <input type="text" name="Experience" />
            <label>Display Picture</label>
            <input type="file" name="displayPicture" />
            <label>Description</label>
            <textarea name="Description" rows="10" cols="30">
              Description
            </textarea>
          </form>
        </div>
      </section>
    </main>
    <footer>
      <div class="footer">
        <ul>
          <li>content</li>
          <li>content</li>
          <li>content</li>
          <li>content</li>
          <li>content</li>
          <li>content</li>
          <li>content</li>
        </ul>
      </div>
    </footer>
  </body>
</html>
