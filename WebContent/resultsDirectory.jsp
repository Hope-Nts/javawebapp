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
 <jsp:include page="footer.jsp"></jsp:include>