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

import model.Beans.Company;
import model.DAO.CompanyDAO;
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
	        Company newCompany = new Company(name, industry, portfolio, password, email, phoneNumber, address, description, displayPicture);
	        CompanyDAO companyDAO = new CompanyDAO();
	        confirmation = companyDAO.insertCompany(newCompany);
	        if(confirmation = true) {
	        	url = "/confirmation.jsp";
	        }else {
	        	url = "TestSignUp.jsp";
	        }
		}

		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}

}
