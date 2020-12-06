package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.*;
import model.Beans.*;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	BusinessAdvisorDAO businessAdvisor = new BusinessAdvisorDAO();
	CompanyDAO company = new CompanyDAO();
	InvestorDAO investor = new InvestorDAO();
	ProfessionalDAO professional = new ProfessionalDAO();
	ProspectDAO prospect = new ProspectDAO();
	String url = "/resultsDirectory.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String type = request.getParameter("type");
		String industry = request.getParameter("industry");
		String keyword = request.getParameter("keyword");
		
		ArrayList<Company> companies = company.getCompanies();
		//ArrayList<BusinessAdvisor> businessAdvisors = businessAdvisor.getAdvisors();
		//ArrayList<Professional> professionals = professional.getProfessionals();
		//ArrayList<Investor> investors = investor.getInvestors();
		//ArrayList<Prospect> prospects = prospect.getProspects();
		ArrayList<User> users = new ArrayList<>();
		
		if(keyword == null || keyword.isEmpty()) {
			keyword = "";
			if(type.equals("Company")) {
				for(int i = 0; i < companies.size(); i++) {
					if(companies.get(i).getIndustry().equals(industry)) {
						Company tempCompany = companies.get(i);
						users.add(tempCompany);
					}
				}
			}/*else if(type.equals("advisor")) {
				for(int i = 0; i < businessAdvisors.size(); i++) {
						BusinessAdvisor tempAdvisor = businessAdvisors.get(i);
						users.add(tempAdvisor);
				}
				
			}else if(type.equals("professional")) {
				for(int i = 0; i < professionals.size(); i++) {
					if(professionals.get(i).getIndustry().equals(industry)) {
						Professional tempProfessional = professionals.get(i);
						users.add(tempProfessional);
					}
				}
			}else if(type.equals("prospect")) {
				for(int i = 0; i < companies.size(); i++) {
						Prospect tempProspect = prospects.get(i);
						users.add(tempProspect);
				}
			}else if(type.equals("investor")) {
				for(int i = 0; i < investors.size(); i++) {
					if(investors.get(i).getIndustry().equals(industry)) {
						Investor tempInvestor = investors.get(i);
						users.add(tempInvestor);
					}
				}
			}*/
			
		}else{
			//use only the keyword as the search
			if(type.equals("Company")) {
				for(int i = 0; i < companies.size(); i++) {
					if(companies.get(i).getIndustry().equals(industry) || companies.get(i).getCompanyName().contains(keyword)) {
						Company tempCompany = companies.get(i);
						users.add(tempCompany);
					}
				}
			}/*else if(type.equals("advisor")) {
				for(int i = 0; i < businessAdvisors.size(); i++) {
					if(businessAdvisors.get(i).getFirstName().contains(keyword) || businessAdvisors.get(i).getLastName().contains(keyword) || businessAdvisors.get(i).getAdvisorType().contains(keyword) ) {
						BusinessAdvisor tempAdvisor = businessAdvisors.get(i);
						users.add(tempAdvisor);
					}
				}
				
			}else if(type.equals("professional")) {
				for(int i = 0; i < professionals.size(); i++) {
					if(professionals.get(i).getIndustry().equals(industry) || professionals.get(i).getFirstName().contains(keyword) || professionals.get(i).getLastName().contains(keyword)) {
						Professional tempProfessional = professionals.get(i);
						users.add(tempProfessional);
					}
				}
			}else if(type.equals("prospect")) {
				for(int i = 0; i < companies.size(); i++) {
					if(prospects.get(i).getFirstName().contains(keyword) || prospects.get(i).getLastName().contains(keyword)) {
						Prospect tempProspect = prospects.get(i);
						users.add(tempProspect);
					}
				}
			}else if(type.equals("investor")) {
				for(int i = 0; i < investors.size(); i++) {
					if(investors.get(i).getIndustry().equals(industry) || investors.get(i).getFirstName().contains(keyword) || investors.get(i).getLastName().contains(keyword)) {
						Investor tempInvestor = investors.get(i);
						users.add(tempInvestor);
					}
				}
			}*/
		}
		
		request.setAttribute("users", users);
		 getServletContext()
		 	.getRequestDispatcher(url)
		 	.forward(request, response);
		/*if(!(keyword.isEmpty()) || keyword != null || !(type.isEmpty()) || type != null || !(industry.isEmpty()) || industry != null){
			//search by type by all the criterea
		}else if(keyword.isEmpty() || keyword == null && (!(type.isEmpty()) || type != null || !(industry.isEmpty()) || industry != null)) {
			//search by type and industry
		}else if(industry.isEmpty() || industry == null && (!(keyword.isEmpty()) || keyword != null || !(type.isEmpty()) || type != null)) {
			//search by type and keyword
		}else if(type.isEmpty() || type == null && (!(keyword.isEmpty()) || keyword != null || !(industry.isEmpty()) || industry != null)) {
			//sear by industry and keyword
		}else if((keyword.isEmpty() || keyword == null || type.isEmpty()) || type == null || industry.isEmpty() || industry != null) {
			//search by keyword
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
