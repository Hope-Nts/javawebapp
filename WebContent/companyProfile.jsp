<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
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
      <section class="profile-section">
      <h1 class="section-heading">Profile</h1>
        <div class="profile-user-info">
          <div class="profile-img">
            <img src="./img/profile.png" alt="" />
          </div>
          <div class="profile-info">
            <div class="edit-btn">
              <form action="editServlet">
                <input type="hidden" name="edit" action="edit" />
                <input type="submit" value="Edit" />
              </form>
            </div>
            <h2>Company</h2>
            <p><span>Name: ${profile.companyName}</span></p>
            <p><span>Industry: ${profile.industry}</span></p>
            <p><span>Email: ${profile.email}</span></p>
            <p><span>Phone: ${profile.phoneNumber}</span>Phone:</p>
            <p><span>Address: ${profile.address}</span></p>
            <p><a href="portfolio">Portfolio</a></p>
          </div>
        </div>
        <br />
        <div class="profile-description">
          <h2>Description</h2>
          <p>
            ${profile.description}
          </p>
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
