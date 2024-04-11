package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import daoo.CollegeDaoImpl;
import daoo.ICollegeDao;
import metier.entities.College;

@WebServlet(name = "colServ", urlPatterns = { "/colleges", "/saisieCollege", "/saveCollege", "/supprimercol",
		"/editercol", "/updatecol" })
public class collegesServlet extends HttpServlet {
	ICollegeDao societe;

	@Override
	public void init() throws ServletException {
		societe = new CollegeDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("PATH " + path);
		if (path.equals("/colleges")) {
			List<College> col = societe.getAllCollege();
			CollegeModel model = new CollegeModel();

			model.setColleges(col);
			request.setAttribute("model", model);
			request.getRequestDispatcher("colleges.jsp").forward(request, response);
			
		} else if (path.equals("/saisieCollege")) {
			System.out.println("*************************************************************************************************************");

			request.getRequestDispatcher("saisieCollege.jsp").forward(request, response);
			
		} else if (path.equals("/saveCollege") && request.getMethod().equals("POST")) {
			System.out.println("************eeee*************************************************************************************************");

			Date datecol = new Date();
			String nom = request.getParameter("nom");
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				datecol = simpleDateFormat.parse(request.getParameter("datecol"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			College col = societe.save(new College(nom, datecol));
			request.setAttribute("college", col);
			response.sendRedirect("colleges");
			
			
		} else if (path.equals("/supprimercol")) {
			Long id = Long.parseLong(request.getParameter("id"));
			societe.deleteCollege(id);
			response.sendRedirect("colleges");
			
			
		} else if (path.equals("/editercol")) {
			Long id = Long.parseLong(request.getParameter("id"));
			College col = societe.getCollege(id); 
			request.setAttribute("college", col);
			request.getRequestDispatcher("editerCollege.jsp").forward(request, response);
			
			
		} else if (path.equals("/updatecol")) {
			Date datecol = new Date();
			Long id = Long.parseLong(request.getParameter("id"));
			String nomcol = request.getParameter("nomcol");
			College col = new College();
			col.setIdcol(id);
			col.setNomcol(nomcol);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				datecol = simpleDateFormat.parse(request.getParameter("dateAffection"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			col.setDateAffection(datecol);
			societe.updateCollege(col);
			response.sendRedirect("colleges");
			
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
