<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>

    <main class="company-profile-main">
      <h1 class="section-heading">Profile</h1>
      <section>
        <div class="editProfileForm">
          <form action="UpdateServlet" method="POST">
          <input type="hidden" name="action" value="updateProspect" />
          <input type="hidden" name="id" value="${profile.id }"/>
            <input type="submit" value="Update" />
            <label>First Name</label>
            <input type="text" name="firstName" value="${profile.firstName }"/>
            <label>Last Name</label>
            <input type="text" name="lastName" value="${profile.lastName }"/>
            <label>Email</label>
            <input type="email" name="email" value="${profile.email }"/>
            <label>Password</label>
            <input type="password" name="password" value="${profile.password }"/>
            <label>Phone</label>
            <input type="phone" name="phoneNumber" value="${profile.phoneNumber }" />
            <label>Address</label>
            <input type="text" name="address" value="${profile.address }"/>
            <label>Level</label>
            <select name="level" >
              <option value="">${profile.level }</option>
              <option value="Undergraduate">Undergraduate</option>
              <option value="Post-graduate">Post-graduate</option>
            </select>
            <label>Current Qualification</label>
            <input type="text" name="currentQualification" value="${profile.currentQualification }"/>
            <label>Obtained Qualification</label>
            <input type="text" name="obtainedQualification" value="${profile.obtainedQualification }" />
            <label>Expected Date Of Completetion</label>
            <input type="date" name="dateOfCompletion" value="${profile.expectedDateOfCompletion }"/>
            <label>Display Picture</label>
            <input type="file" name="displayPicture"  />
            <label>Description</label>
            <textarea name="description" rows="10" cols="30">
              ${profile.description }
            </textarea>
          </form>
        </div>
      </section>
    </main>
<jsp:include page="footer.jsp"></jsp:include>