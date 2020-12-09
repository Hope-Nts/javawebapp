<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>

    <main class="company-profile-main">
      <section class="profile-section">
      <h1 class="section-heading">Profile</h1>
        <div class="profile-user-info">
          <div class="profile-img">
            <img src="data:image/jpg;base64,${profile.getBase64DisplayPicture()}" alt="" />
          </div>
          <div class="profile-info">
            <div class="edit-btn">
              <form action="LoadEditProfileServlet">
                <input type="hidden" name="edit" action="edit" />
                <input type="submit" value="Edit" />
              </form>
            </div>
            <h2>Investor</h2>
            <p><span>Name: ${profile.firstName} ${profile.lastName}</span> </p>
            <p><span>Email: ${profile.email}</span></p>
            <p><span>Industry: ${profile.industry}</span></p>
            <p><span>Firm Name: ${profile.firmName}</span></p>
            <p><span>Phone: ${profile.phoneNumber}</span></p>
            <p><span>Address: ${profile.address}</span></p>
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
<jsp:include page="footer.jsp"></jsp:include>