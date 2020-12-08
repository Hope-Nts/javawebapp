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
            <textarea name="Description" rows="10" cols="30">
              Description
            </textarea>
          </form>
        </div>
      </section>
    </main>
<jsp:include page="footer.jsp"></jsp:include>