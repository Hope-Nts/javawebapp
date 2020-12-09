<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>

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
            		<img src="data:image/jpg;base64,${company.getBase64DisplayPicture()}" alt="" />
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
		<c:forEach var="professional" items="${professionals}">
 			<div class="search-result">
            	<div class="display-picture">
            		<img src="data:image/jpg;base64,${professional.getBase64DisplayPicture()}" alt="" />
            	</div>
                <div class="information">
           	    	<ul>
		              <li>Name: <span><c:out value="${professional.firstName}"  /> </span>  <span><c:out value="${professional.lastName}"  /> </span></li>
		              <li>Industry: <span><c:out value="${professional.industry}"/> </span> </li>
		              <li>Contacts:<span><c:out value="${professional.email}"/> ,<c:out value="${professional.phoneNumber}"/> </span></li>
		              <li>
		                <form action="LoadProfileServlet" method="get">
		                  <input type="hidden" value="${professional.id}" name="id" />
		                  <input type="submit" value="profile" />
		                </form>
		              </li>
		            </ul>
         		</div>
       		</div>
		</c:forEach>
		<c:forEach var="prospect" items="${prospects}">
 			<div class="search-result">
            	<div class="display-picture">
            		<img src="data:image/jpg;base64,${prospect.getBase64DisplayPicture()}" alt="" />
            	</div>
                <div class="information">
           	    	<ul>
		              <li>Name: <span><c:out value="${prospect.firstName}"  /> </span>  <span><c:out value="${prospect.lastName}"  /> </span></li>
		              <li>Level: <span><c:out value="${prospect.level}"/> </span> </li>
		              <li>Contacts:<span><c:out value="${prospect.email}"/> ,<c:out value="${prospect.phoneNumber}"/> </span></li>
		              <li>
		                <form action="LoadProfileServlet" method="get">
		                  <input type="hidden" value="${prospect.id}" name="id" />
		                  <input type="submit" value="profile" />
		                </form>
		              </li>
		            </ul>
         		</div>
       		</div>
		</c:forEach>
		<c:forEach var="investor" items="${investors}">
 			<div class="search-result">
            	<div class="display-picture">
            		<img src="data:image/jpg;base64,${investor.getBase64DisplayPicture()}" alt="" />
            	</div>
                <div class="information">
           	    	<ul>
		              <li>Name: <span><c:out value="${investor.firstName}"  /> </span>  <span><c:out value="${investor.lastName}"  /> </span></li>
		              <li>Industry: <span><c:out value="${investor.industry}"/> </span> </li>
		              <li>Contacts:<span><c:out value="${investor.email}"/> ,<c:out value="${investor.phoneNumber}"/> </span></li>
		              <li>
		                <form action="LoadProfileServlet" method="get">
		                  <input type="hidden" value="${investor.id}" name="id" />
		                  <input type="submit" value="profile" />
		                </form>
		              </li>
		            </ul>
         		</div>
       		</div>
		</c:forEach>
		<c:forEach var="businessAdvisor" items="${businessAdvisors}">
 			<div class="search-result">
            	<div class="display-picture">
            		<img src="data:image/jpg;base64,${businessAdvisor.getBase64DisplayPicture()}" alt="" />
            	</div>
                <div class="information">
           	    	<ul>
		              <li>Name: <span><c:out value="${businessAdvisor.firstName}"  /> </span>  <span><c:out value="${businessAdvisor.lastName}"  /> </span></li>
		              <li>Type: <span><c:out value="${businessAdvisor.advisorType}"/> </span> </li>
		              <li>Contacts:<span><c:out value="${businessAdvisor.email}"/> ,<c:out value="${businessAdvisor.phoneNumber}"/> </span></li>
		              <li>
		                <form action="LoadProfileServlet" method="get">
		                  <input type="hidden" value="${businessAdvisor.id}" name="id" />
		                  <input type="submit" value="profile" />
		                </form>
		              </li>
		            </ul>
         		</div>
       		</div>
		</c:forEach>
      </section>
 <jsp:include page="footer.jsp"></jsp:include>