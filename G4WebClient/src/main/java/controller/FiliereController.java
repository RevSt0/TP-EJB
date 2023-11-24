package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.IDaoLocal;
import entities.Filiere;

/**
 * Servlet implementation class FiliereController
 */
@WebServlet("/FiliereController")
public class FiliereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(beanName = "FILIERE_EJB")
	private IDaoLocal<Filiere> dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiliereController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action==null) {
			request.setAttribute("listFilieres", dao.findAll());
		
			request.getRequestDispatcher("indexF.jsp").forward(request, response);
		}
		
		else {
			if(action.equalsIgnoreCase("add")) {
				
				request.getRequestDispatcher("addFiliere.jsp").forward(request, response);
			}
			
			else if(action.equalsIgnoreCase("update")) {
			
				
				int filiereId = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("filiere", dao.findById(filiereId));
				
			    request.getRequestDispatcher("editFiliere.jsp").forward(request, response);
			    
			}
			
			else if(action.equalsIgnoreCase("delete")) {
				String idString = request.getParameter("id");
			    int id = Integer.parseInt(idString);
			    dao.delete(dao.findById(id));
			    response.sendRedirect("FiliereController");
			   
				
		
			}
		}
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");
	if(action.equalsIgnoreCase("add")) {
		try {
			
		Filiere filiere = new Filiere();
		filiere.setName(request.getParameter(("name")));
		filiere.setCode(request.getParameter(("code")));
		
		
		dao.create(filiere);
		response.sendRedirect("FiliereController");
		}
		catch(Exception e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("addFiliere.jsp").forward(request, response);
		}
	}

		else if(action.equalsIgnoreCase("update")) {
			try {
				
			int id=Integer.parseInt(request.getParameter("id"));
			
			Filiere filiere = dao.findById(id);
			filiere.setName(request.getParameter(("name")));
			filiere.setCode(request.getParameter(("code")));
			dao.update(filiere);
			response.sendRedirect(request.getContextPath() + "/FiliereController");
			}
			catch(Exception e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("editFiliere.jsp").forward(request, response);
			}
	}


}

}
