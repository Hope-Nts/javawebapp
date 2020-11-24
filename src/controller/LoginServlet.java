package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Beans.LoginToken;
import model.DAO.BusinessAdvisorDAO;
import model.DAO.CompanyDAO;
import model.DAO.InvestorDAO;
import model.DAO.ProfessionalDAO;
import model.DAO.ProspectDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	BusinessAdvisorDAO businessAdvisor = new BusinessAdvisorDAO();
	CompanyDAO company = new CompanyDAO();
	InvestorDAO investor = new InvestorDAO();
	ProfessionalDAO professional = new ProfessionalDAO();
	ProspectDAO prospect = new ProspectDAO();
	LoginToken loginToken = new LoginToken();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userType;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
