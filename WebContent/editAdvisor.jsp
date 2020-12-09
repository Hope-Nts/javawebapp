<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>

    <main class="company-profile-main">
      <h1 class="section-heading">Profile</h1>
      <section>
        <div class="editProfileForm">
          <form action="UpdateServlet" method="POST">
            <input type="submit" value="Update" />
            <input type="hidden" name="action" value="updateAdvisor" />
            <input type="hidden" name="id" value="${profile.id }"/>
            <label>First Name</label>
            <input type="text" name="firstName" value="${profile.firstName }"/>
            <label>Last Name</label>
            <input type="text" name="lastName" value="${profile.lastName }"/>
            <label>Email</label>
            <input type="email" name="email" value="${profile.email }" />
            <label>Password</label>
            <input type="password" name="password" value="${profile.password }"/>
            <label>Advisor Type</label>
            <select name="advisorType" value="${profile.advisorType }">
              <option value="Generic Business">Generic Business</option>
              <option value="Tech Business">Tech Business</option>
            </select>
            <label>Phone</label>
            <input type="phone" name="phoneNumber" value="${profile.phoneNumber }" />
            <label>Address</label>
            <input type="text" name="address" value="${profile.address }" />
            <label>Employment Status</label>
            <select name="employmentStatus" value="${profile.employmentStatus }">
              <option value="Employed">Employed</option>
              <option value="Free-agent">Free-agent</option>
            </select>
            <label>Display Picture</label>
            <input type="file" name="displayPicture" />
            <label>Description</label>
            <textarea name="description" rows="10" cols="30">
              ${profile.description }
            </textarea>
          </form>
        </div>
      </section>
    </main>
<jsp:include page="footer.jsp"></jsp:include>