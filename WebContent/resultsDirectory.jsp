<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <main>
      <section>
        <div class="directory-inputs">
          <form action="SearchServlet" class="inputs" method="GET">
            <div class="type-input">
              <label >Company or Individual:</label>
              <select name="type">
                <option value="company">Company</option>
                <option value="prospect">Prospect</option>
                <option value="professional">Professional</option>
                <option value="investor">Investor</option>
                <option value="advisor">Business Advisor</option>
              </select>
            </div>
            <div class="industry-input">
              <label >Industry:</label>
              <select name="industry" >
                <option value="Software Development">Software development</option>
                <option value="IT Infrastructure">IT infrastructure</option>
              </select>
            </div>
            <div class="keyword-input">
            <label >Name</label>
              <input type="text" name="keyword" />
            </div>
            <input type="submit" value="search" />
          </form>
        </div>
      </section>
      <section>
        <h1 class="section-heading">Results</h1>
        <c:forEach var="company" items="${companies}">
 			<div class="search-result">
            	<div class="display-picture">
            		<img src="./img/heroimage.jpg" alt="" />
            	</div>
                <div class="information">
           	    	<ul>
		              <li>Name: <span><c:out value="${company.companyName}"/> </span></li>
		              <li>Industry: <span><c:out value="${company.industry}"/> </span> </li>
		              <li>Contacts:<span><c:out value="${company.email}"/> ,<c:out value="${company.phoneNumber}"/> </span></li>
		              <li>
		                <form action="LoadProfileServlet" method="get">
		                  <input type="hidden" value="${company.id}" name="id" />
		                  <input type="submit" value="profile" />
		                </form>
		              </li>
		            </ul>
         		</div>
       		</div>
		</c:forEach>
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
