<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>

    <main class="company-profile-main">
      <h1 class="section-heading">Profile</h1>
      <section>
        <div class="editProfileForm">
          <form action="UpdateServlet" method="POST">
            <input type="submit" value="Update" />
            <input type="hidden" name="action" value="updateCompany" />
            <input type="hidden" name="id" value="${profile.id }"/>
            <label>Name</label>
            <input type="text" name="name" value="${profile.companyName }"/>
            <label>Industry</label>
            <select name="industry" >
              <option value="${profile.industry }">${profile.industry }</option>
              <option value="IT Infrastructure">IT Infrastructure</option>
              <option value="Software Development">Software Development</option>
            </select>
            <label>Email</label>
            <input type="email" name="email" value="${profile.email }"/>
            <label>Password</label>
            <input type="password" name="password" value="${profile.password }"/>
            <label>Phone</label>
            <input type="text" name="phoneNumber" value="${profile.phoneNumber }" />
            <label>Address</label>
            <input type="text" name="address" value="${profile.address }"/>
            <label>Porfolio</label>
            <input type="file" name="portfolio"/>
            <label>Display Picture</label>
            <input type="file" name="displayPicture" />
            <label>Description</label>
            <textarea name="description" rows="10" cols="30">
            	${profile.description}
          </textarea
            >
          </form>
        </div>
      </section>
    </main>
<jsp:include page="footer.jsp"></jsp:include>