package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

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
 * Servlet implementation class SignUpServlet
 */
@MultipartConfig(maxFileSize = 16177215)  // upload file's size up to 16MB
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		//doGet(request, response);
		//getting the action of the form 
		String action = request.getParameter("action");
		String url = "";
		boolean confirmation;
		if(action == null) {
			action = "join"; //default action
		}else if(action.equals("companySignUp")) {
			//getting the parameters from the request
			String name = request.getParameter("name");
			String industry = request.getParameter("industry");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String description = request.getParameter("description");
			
			//getting the portfolio file from the request
			InputStream portfolio = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part portfolioFilePart = request.getPart("portfolio");
	        if (portfolioFilePart  != null) {
	            // prints out some information for debugging
	            System.out.println(portfolioFilePart .getName());
	            System.out.println(portfolioFilePart .getSize());
	            System.out.println(portfolioFilePart .getContentType());
	             
	            // obtains input stream of the upload file
	            portfolio = portfolioFilePart.getInputStream();
	        }
	        
	      //getting the displayPicure file from the request
			InputStream displayPicture = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part displayPictureFilePart = request.getPart("displayPicture");
	        if (displayPictureFilePart != null) {
	            // prints out some information for debugging
	            System.out.println(displayPictureFilePart.getName());
	            System.out.println(displayPictureFilePart.getSize());
	            System.out.println(displayPictureFilePart.getContentType());
	             
	            // obtains input stream of the upload file
	            displayPicture = displayPictureFilePart.getInputStream();
	        }
	        
	        CompanyDAO companyDAO = new CompanyDAO();
	        String id = companyDAO.createId();
	        Company newCompany = new Company(id,name, industry, portfolio, password, email, phoneNumber, address, description, displayPicture);
	        
	        confirmation = companyDAO.insertCompany(newCompany);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}else if(action.equals("professionalSignUp")) {
			//getting the parameters from the request
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
				        
	       //getting the displayPicure file from the request
			InputStream displayPicture = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part displayPictureFilePart = request.getPart("displayPicture");
	        if (displayPictureFilePart != null) {
	            // prints out some information for debugging
	            System.out.println(displayPictureFilePart.getName());
	            System.out.println(displayPictureFilePart.getSize());
	            System.out.println(displayPictureFilePart.getContentType());
	             
	            // obtains input stream of the upload file
	            displayPicture = displayPictureFilePart.getInputStream();
	        }
	        
	        ProfessionalDAO professionalDAO = new ProfessionalDAO();
	        String id = professionalDAO.createId();
	        Professional newProfessional = new Professional(id, experience, qualifications, industry, employmentStatus, firstName, lastName, password, email, phoneNumber, address, description, displayPicture);
	        
	        confirmation = professionalDAO.insertProfessional(newProfessional);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}else if(action.equals("prospectSignUp")) {
			//getting the parameters from the request
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
	       //getting the displayPicure file from the request
			InputStream displayPicture = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part displayPictureFilePart = request.getPart("displayPicture");
	        if (displayPictureFilePart != null) {
	            // prints out some information for debugging
	            System.out.println(displayPictureFilePart.getName());
	            System.out.println(displayPictureFilePart.getSize());
	            System.out.println(displayPictureFilePart.getContentType());
	             
	            // obtains input stream of the upload file
	            displayPicture = displayPictureFilePart.getInputStream();
	        }
	        
	        ProspectDAO prospectDAO = new ProspectDAO();
	        String id = prospectDAO.createId();
	        Prospect newProspect = new Prospect( id, level, currentQualification, obtainedQualification, expectedDateOfCompletion, firstName, lastName, password, email, phoneNumber, address, description, displayPicture);
	        confirmation = prospectDAO.insertProspect(newProspect);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}else if(action.equals("investorSignUp")) {
			//getting the parameters from the request
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
	       //getting the displayPicure file from the request
			InputStream displayPicture = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part displayPictureFilePart = request.getPart("displayPicture");
	        if (displayPictureFilePart != null) {
	            // prints out some information for debugging
	            System.out.println(displayPictureFilePart.getName());
	            System.out.println(displayPictureFilePart.getSize());
	            System.out.println(displayPictureFilePart.getContentType());
	             
	            // obtains input stream of the upload file
	            displayPicture = displayPictureFilePart.getInputStream();
	        }
	        
	        InvestorDAO investorDAO = new InvestorDAO();
	        String id = investorDAO.createId();
	        Investor newInvestor = new Investor( id, industry, firmName, firstName, lastName, password, email, phoneNumber, address, description, displayPicture);
	        
	        confirmation = investorDAO.insertInvestor(newInvestor);
	        if(confirmation = true) {
	        	url = "/index.jsp";
	        }else {
	        	url = "/index.jsp";
	        }
		}else if(action.equals("advisorSignUp")) {
			//getting the parameters from the request
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
	       //getting the displayPicure file from the request
			InputStream displayPicture = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part displayPictureFilePart = request.getPart("displayPicture");
	        if (displayPictureFilePart != null) {
	            // prints out some information for debugging
	            System.out.println(displayPictureFilePart.getName());
	            System.out.println(displayPictureFilePart.getSize());
	            System.out.println(displayPictureFilePart.getContentType());
	             
	            // obtains input stream of the upload file
	            displayPicture = displayPictureFilePart.getInputStream();
	        }
	        
	        BusinessAdvisorDAO advisorDAO = new BusinessAdvisorDAO();
	        String id = advisorDAO.createId();
	        BusinessAdvisor newAdvisor = new BusinessAdvisor( id, advisorType, employmentStatus, firstName, lastName, password, email, phoneNumber, address, description, displayPicture);
	        
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
