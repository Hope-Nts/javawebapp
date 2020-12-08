<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>

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
            <textarea name="Description" rows="10" cols="30">
              Description
            </textarea>
          </form>
        </div>
      </section>
    </main>
<jsp:include page="footer.jsp"></jsp:include>