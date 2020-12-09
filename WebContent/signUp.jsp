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
          <a href="index.jsp"><img src="./img/LOGO.png" alt="" /></a>
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
          <form action="SignUpServlet" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="action" value="companySignUp" >
            <label>Name</label>
            <input type="text" name="name" />
            <label>Industry</label>
            <select name="industry" name="industry">
              <option value="IT Infrastructure">IT Infrastructure</option>
              <option value="Software Development">Software Development</option>
            </select>
            <label>Email</label>
            <input type="email" name="email" />
            <label>Password</label>
            <input type="password" name="password" />
            <label>Phone</label>
            <input type="text" name="phoneNumber" />
            <label>Address</label>
            <input type="text" name="address" />
            <label>Porfolio</label>
            <input type="file" name="portfolio" />
            <label>Display Picture</label>
            <input type="file" name="displayPicture" />
            <label>Description</label>
            <textarea name="description" rows="10" cols="30">
              Description
            </textarea>
            <input type="submit" value="Sign Up" />
          </form>
        </div>
        <div id="Prospect" class="signUpForm">
          <form action="SignUpServlet" method="POST" enctype="multipart/form-data">
          	<input type="hidden" name="action" value="prospectSignUp" >
            <label>First Name</label>
            <input type="text" name="firstName" />
            <label>Last Name</label>
            <input type="text" name="lastName" />
            <label>Email</label>
            <input type="email" name="email" />
            <label>Password</label>
            <input type="password" name="password" />
            <label>Phone</label>
            <input type="phone" name="phoneNumber" placeholder="+267" />
            <label>Address</label>
            <input type="text" name="address" />
            <label>Level</label>
            <select name="level">
              <option value="Undergraduate">Undergraduate</option>
              <option value="Post-graduate">Post-graduate</option>
            </select>
            <label>Current Qualification</label>
            <input type="text" name="currentQualification" />
            <label>Obtained Qualification</label>
            <input type="text" name="obtainedQualification" />
            <label>Expected Date Of Completetion</label>
            <input type="date" name="dateOfCompletion" value="2020-11-23" />
            <label>Display Picture</label>
            <input type="file" name="displayPicture" />
            <label>Description</label>
            <textarea name="description" rows="10" cols="30">
              Description
            </textarea>
            <input type="submit" value="Sign Up" />
          </form>
        </div>
        <div id="Professional" class="signUpForm">
          <form action="SignUpServlet" method="POST" enctype="multipart/form-data">
          	<input type="hidden" name="action" value="professionalSignUp" >
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
            <label>Address
            </label>
            <input type="text" name="address" />
            <label>Experience *Years</label>
            <input type="text" name="experience" />
            <label>Qualification</label>
            <input type="text" name="qualification" />
            <label>Employment Status</label>
            <select name="employmentStatus">
              <option value="Employed">Employed</option>
              <option value="Free-agent">Free-agent</option>
            </select>
            <label>Display Picture</label>
            <input type="file" name="displayPicture" />
            <label>Description</label>
            <textarea name="description" rows="10" cols="30">
              Description
            </textarea>
            <input type="submit" value="Sign Up" />
          </form>
        </div>
        <div id="Advisor" class="signUpForm">
          <form action="SignUpServlet" method="POST" enctype="multipart/form-data">
            <label>First Name</label>
            <input type="hidden" name="action" value="advisorSignUp" >
            <input type="text" name="firstName" />
            <label>Last Name</label>
            <input type="text" name="lastName" />
            <label>Email</label>
            <input type="email" name="email" />
            <label>Password</label>
            <input type="password" name="password" />
            <label>Advisor Type</label>
            <select name="advisorType">
              <option value="Generic Business">Generic Business</option>
              <option value="Tech Business">Tech Business</option>
            </select>
            <label>Phone</label>
            <input type="phone" name="phoneNumber" placeholder="+267" />
            <label>Addres</label>
            <input type="text" name="address" />
            <label>Experience *Years</label>
            <input type="text" name="experience" />
            <label>Employment Status</label>
            <select name="employmentStatus">
              <option value="Employed">Employed</option>
              <option value="Free-agent">Free-agent</option>
            </select>
            <label>Display Picture</label>
            <input type="file" name="displayPicture" />
            <label>Description</label>
            <textarea name="description" rows="10" cols="30">
              Description
            </textarea>
            <input type="submit" value="Sign Up" />
          </form>
        </div>
        <div id="Investor" class="signUpForm">
          <form action="SignUpServlet" method="POST" enctype="multipart/form-data">
          	<input type="hidden" name="action" value="investorSignUp" >
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
            <label>Address</label>
            <input type="text" name="address" />
            <label>FirmName</label>
            <input type="text" name="firmName" />
            <label>Experience *Years</label>
            <input type="text" name="experience" />
            <label>Display Picture</label>
            <input type="file" name="displayPicture" />
            <label>Description</label>
            <textarea name="description" rows="10" cols="30">
              Description
            </textarea>
            <input type="submit" value="Sign Up" />
          </form>
        </div>
      </div>
    </main>
    <footer class="signing-footer">
      <div class="signing-footer-text">
        <p>
          Enter website as guest without registering
          <a href="index.jsp">Home</a>
          <a href="signIn.jsp">  SignIn</a>
        </p>
      </div>
    </footer>
  </body>
</html>

