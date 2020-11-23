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
    <link rel="directoryStylesheet" href="./style.css" />
    <title>Document</title>
  </head>
  <body>
    <header>
      <div class="nav-bar" id="navbar">
        <div class="logo-container">
          <a class="nav-link" href="index.html"
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
              <li><a class="nav-link" href="signIn.html">Sign out</a></li>
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

    <main>
      <section>
        <div class="directory-inputs">
          <form class="inputs">
            <div class="type-input">
              <label for="cars">Company or Individual:</label>
              <select id="cars" name="type">
                <option value="company">Company</option>
                <option value="prospect">Prospect</option>
                <option value="professional">Professional</option>
                <option value="investor">Investor</option>
                <option value="advisor">Business Adivisor</option>
              </select>
            </div>
            <div class="industry-input">
              <label for="cars">Industry:</label>
              <select id="industry" name="cars">
                <option value="volvo">Software development</option>
                <option value="saab">IT infrastructure</option>
              </select>
            </div>
            <div class="keyword-input">
              <input type="text" name="keyword" />
            </div>
            <input type="submit" value="search" />
          </form>
        </div>
      </section>
      <section>
        <h1 class="section-heading">Results</h1>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information">
            <ul>
              <li>Name: </li>
              <li>Industry: </li>
              <li>Contacts:</li>
              <li>
                <form action="somethingServlet" method="get">
                  <input type="hidden" value="$" />
                  <input type="submit" value="profile" />
                </form>
              </li>
            </ul>
          </div>
        </div>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information">
            <ul>
              <li>Name: </li>
              <li>Industry: </li>
              <li>Contacts: </li>
              <li><a>profile</a></li>
            </ul>
          </div>
        </div>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information"></div>
        </div>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information">
            <ul>
              <li>Name: </li>
              <li>Industry: </li>
              <li>Contacts: </li>
              <li><a>profile</a></li>
            </ul>
          </div>
        </div>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information"></div>
        </div>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information"></div>
        </div>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information"></div>
        </div>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information"></div>
        </div>
        <div class="search-result">
          <div class="display-picture">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
          <div class="information"></div>
        </div>
      </section>
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
    </main>
  </body>
</html>
