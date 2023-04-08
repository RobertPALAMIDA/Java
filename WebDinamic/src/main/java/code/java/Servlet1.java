package code.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    List<Persoana>listaPersoane=new ArrayList<Persoana>();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("btnAdauga")!=null)
		{
			PrintWriter out=response.getWriter();
			String nume=request.getParameter("txtNume");
			String prenume=request.getParameter("txtPrenume");
			String cod=request.getParameter("txtCod");
			Persoana pers=new Persoana(nume,prenume,cod);
			listaPersoane.add(pers);
			out.println("<html><head>Test</head><body>");
			out.println("<table align='center' width='50%' border='1'>");
			out.println("<tr><th>Nume</th><th>Prenume</th><th>Cod matricol</th></tr>");
			for(Persoana persoana:listaPersoane)
				out.println("<tr><td>"+persoana.getNume()+"</td><td>"+persoana.getNume()+"</td><td>"+persoana.getCod()+"</td></tr>");
			out.println("</table></body></html>");
		}
	}

}
