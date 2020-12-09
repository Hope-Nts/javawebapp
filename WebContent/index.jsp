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
    <title>FrancistownDigi</title>
  </head>
  <body>
    <header class="home-header">
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
          </ul>
        </nav>
        <div class="profile">
          <div class="profile-links">
            <ul>
              <li>
              <form action="SignOutServlet" method="GET" >
                  <input type="hidden" value="${loginToken.id }" name ="loginId" />
                  <input type="submit" value="SignOut" />
                </form>
			  </li>
              <li>
                <form action="LoadUserProfile" method="GET" >
                  <input type="hidden" value="${loginToken.id }" name ="loginId" />
                  <input type="submit" value="Profile" />
                </form>
              </li>
            </ul>
          </div>
          <img src="./img/profile.png" alt="cart" />
        </div>
      </div>
      <div class="hero-content">
        <div class="intro-text">
          <h2>Francistown Digital City</h2>
          <p class="hero-text">
            Become part of the largest future network of ICT and Software Industry people
            including companies
          </p>
        </div>
        <div class="cta">
        <p>
        <a href="signUp.jsp">Sign Up</a> <a href="signIn.jsp"> Sign In</a>
        </p>
        </div>
      </div>
    </header>
    <main>
      <section class="online-directory">
        <h1 class="section-heading">Online Directory</h1>

        <div class="intro">
          <div class="intro-img">
            <img src="./img/heroimage2.jpg" alt="" />
          </div>
          <div class="intro-txt">
            <h2>Companies</h2>
            <p>
              Francistown Digital City Portal offers a web directory
              where companies can register and become listed in the directory.
              Registration is open to companies offering IT infrastructure and 
              solutions companies offering software development services. The program
              is looking to offer 200+ companies funding and industry education for growth
              in the new developing ICT industry of Francistown 
            </p>
          </div>
        </div>
        <div class="intro">
          <div class="intro-txt">
            <h2>Individuals</h2>
            <p>
              The Francistown Digital City Project Offers opportunities for different
              stake holders within the ICT industry. From Prospective  students looking
              to break into market. Already established industry Professionals and opportunity
              to be scouted. Business advisor well vested in the economics of ICT are welcomed on board.
            </p>
          </div>
          <div class="intro-img">
            <img src="./img/heroimage.jpg" alt="" />
          </div>
        </div>
      </section>
      <section>
        <h1 class="section-heading">Applicant</h1>
        <div class="applicatants-container">
          <div class="applicant">
            <img src="./img/companies.jpg" alt="Applicant" />
            <h4>Companies</h4>
          </div>
          <div class="applicant">
            <img src="./img/profesionals.jpg" alt="Applicant" />
            <h4>Professionals</h4>
          </div>
          <div class="applicant">
            <img src="./img/students.jpg" alt="Applicant" />
             <h4>Students</h4>
          </div>
          <div class="applicant">
            <img src="./img/advisors.jpg" alt="Applicant" />
             <h4>Advisors</h4>
          </div>
        </div>
      </section>
      <section>
        <h1 class="section-heading">What is it?</h1>
        <p class="last-paragraph">
          BIH, has formed a strategic partnership with the Botswana Accountancy College,The Botswana
		  Investment and Trade Center, Francistown City Council and Francistown Investment Forum to 
		  envision scope, plan and implement the project to create:
		  <br>
		  200+ new software jobs
		  <br>
		  2000+ employment opportunities     
		  <br>
		  education and training opportunities in business creation   
        </p>
      </section>
    </main>
<jsp:include page="footer.jsp"></jsp:include>