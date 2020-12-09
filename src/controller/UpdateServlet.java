package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Beans.BusinessAdvisor;
import model.Beans.Company;
import model.Beans.Investor;
import model.Beans.Professional;
import model.Beans.Prospect;
import model.DAO.BusinessAdvisorDAO;
import model.DAO.CompanyDAO;
import model.DAO.InvestorDAO;
import model.DAO.ProfessionalDAO;
import model.DAO.ProspectDAO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		String url = "";
		boolean confirmation;
		if(action == null) {
			action = "join"; //default action
		}else if(action.equals("updateCompany")) {
			//getting the parameters from the request
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String industry = request.getParameter("industry");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String description = request.getParameter("description");
			CompanyDAO companyDAO = new CompanyDAO();
	        Company newCompany = new Company(id,name, industry, password, email, phoneNumber, address, description);
	        confirmation = companyDAO.updateCompany(newCompany);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}else if(action.equals("updateProfessional")) {
			//getting the parameters from the request
			String id = request.getParameter("id");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");	
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String industry = request.getParameter("industry");
			String experience = request.getParameter("experience");
			String qualifications = request.getParameter("qualification");
			String employmentStatus = request.getParameter("employmentStatus");
			String description = request.getParameter("description");
	        
	        ProfessionalDAO professionalDAO = new ProfessionalDAO();
	        Professional newProfessional = new Professional(id, experience, qualifications, industry, employmentStatus, firstName, lastName, password, email, phoneNumber, address, description);
	        
	        confirmation = professionalDAO.updateProfessional(newProfessional);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}else if(action.equals("updateProspect")) {
			//getting the parameters from the request
			String id = request.getParameter("id");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");	
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String level = request.getParameter("level");
			String currentQualification = request.getParameter("currentQualification");
			String obtainedQualification = request.getParameter("obtainedQualification");
			String expectedDateOfCompletion = request.getParameter("dateOfCompletion");
			String description = request.getParameter("description");
	        
	        ProspectDAO prospectDAO = new ProspectDAO();
	        Prospect newProspect = new Prospect( id, level, currentQualification, obtainedQualification, expectedDateOfCompletion, firstName, lastName, password, email, phoneNumber, address, description);
	        confirmation = prospectDAO.updateProspect(newProspect);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}else if(action.equals("updateInvestor")) {
			//getting the parameters from the request
			String id = request.getParameter("id");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");	
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String industry = request.getParameter("industry");
			String experience = request.getParameter("experience");
			String description = request.getParameter("description");
			String firmName = request.getParameter("firmName");	        
	        
	        InvestorDAO investorDAO = new InvestorDAO();
	        Investor newInvestor = new Investor( id, industry, firmName, firstName, lastName, password, email, phoneNumber, address, description);
	        
	        confirmation = investorDAO.insertInvestor(newInvestor);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}else if(action.equals("updateAdvisor")) {
			//getting the parameters from the request
			String id = request.getParameter("id");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");	
			String advisorType = request.getParameter("advisorType");
			String employmentStatus = request.getParameter("employmentStatus");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String industry = request.getParameter("industry");
			String description = request.getParameter("description");        
	        
	        BusinessAdvisorDAO advisorDAO = new BusinessAdvisorDAO();

	        BusinessAdvisor newAdvisor = new BusinessAdvisor( id, advisorType, employmentStatus, firstName, lastName, password, email, phoneNumber, address, description);
	        
	        confirmation = advisorDAO.insertAdvisor(newAdvisor);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}

}
	

