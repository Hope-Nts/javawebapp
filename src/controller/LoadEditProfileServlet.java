package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beans.BusinessAdvisor;
import model.Beans.Company;
import model.Beans.Investor;
import model.Beans.LoginToken;
import model.Beans.Professional;
import model.Beans.Prospect;
import model.DAO.BusinessAdvisorDAO;
import model.DAO.CompanyDAO;
import model.DAO.InvestorDAO;
import model.DAO.ProfessionalDAO;
import model.DAO.ProspectDAO;

/**
 * Servlet implementation class LoadEditProfileServlet
 */
@WebServlet("/LoadEditProfileServlet")
public class LoadEditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadEditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
    BusinessAdvisorDAO businessAdvisor = new BusinessAdvisorDAO();
	CompanyDAO company = new CompanyDAO();
	InvestorDAO investor = new InvestorDAO();
	ProfessionalDAO professional = new ProfessionalDAO();
	ProspectDAO prospect = new ProspectDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = request.getHeader("referer");
		System.out.print(url);
		HttpSession session = request.getSession();
		LoginToken token = (LoginToken)request.getAttribute("loginToken");
		
		if(token != null) {
			if(token.isLoggedIn() == true) {
				String id = token.getId();
				if(id.contains("CO")) {
					Company profile = company.searchCompany(id);
					url = "/editCompany.jsp";
					request.setAttribute("profile", profile);
					getServletContext()
					.getRequestDispatcher(url)
					.forward(request, response);
				}else if(id.contains("PF")) {
					Professional profile = professional.searchProfessional(id);
					url = "/editProfessional.jsp";
					request.setAttribute("profile", profile);
					getServletContext()
					.getRequestDispatcher(url)
					.forward(request, response);
				}else if(id.contains("BI")) {
					//businessAdvisor
					BusinessAdvisor profile = businessAdvisor.searchAdvisor(id);
					url = "/editAdvisor.jsp";
					request.setAttribute("profile", profile);
					getServletContext()
					.getRequestDispatcher(url)
					.forward(request, response);
				}else if(id.contains("IN")) {
					//investor
					Investor profile = investor.searchAdvisor(id);
					url = "/editInvestor.jsp";
					request.setAttribute("profile", profile);
					getServletContext()
					.getRequestDispatcher(url)
					.forward(request, response);
				}else if(id.contains("PR")) {
					//prospect
					Prospect profile = prospect.searchProspect(id);
					url = "/editProspect.jsp";
					request.setAttribute("profile", profile);
					getServletContext()
					.getRequestDispatcher(url)
					.forward(request, response);
				}
			
			}
		}
		
		response.sendRedirect(url);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
