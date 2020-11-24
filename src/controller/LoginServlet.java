package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    
    String url = "/signIn.jsp";
    String message = "Unsuccessfull login,check email or password";
	BusinessAdvisorDAO businessAdvisor = new BusinessAdvisorDAO();
	CompanyDAO company = new CompanyDAO();
	InvestorDAO investor = new InvestorDAO();
	ProfessionalDAO professional = new ProfessionalDAO();
	ProspectDAO prospect = new ProspectDAO();
	LoginToken loginToken = new LoginToken("", false);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//LoginToken advisorLogin = businessAdvisor.login(email, password);
		LoginToken companyLogin = company.login(email, password);
		//LoginToken investorLogin = investor.login(email, password);
		//LoginToken professionalLogin = professional.login(email, password);
		//LoginToken prospectLogin = prospect.login(email, password);
		//LoginToken [] tokens = {advisorLogin,companyLogin,investorLogin,investorLogin,prospectLogin,professionalLogin};
		LoginToken [] tokens = {companyLogin};
		
		for(int i = 0; i < tokens.length; i++) {
			if(tokens[i].isLoggedIn() == true) {
				loginToken = tokens[i];
				url = "/index.jsp";
				message = "";
				break;
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginToken", loginToken);
		request.setAttribute("message", message);
		 getServletContext()
		 	.getRequestDispatcher(url)
		 	.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
