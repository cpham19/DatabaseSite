import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewNumberOfPeople extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("org.postgresql.Driver");
		} 
		catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String projNum = request.getParameter("proj_num");
		int count = 0;

		if (projNum == null) {
			response.sendRedirect("Table");
		}
		else if (projNum != null && !projNum.isEmpty()) {
		     Connection c = null;
             try
             {
                 String url = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s29";
                 String username = "cs4222s29";
                 String password = "Wh0QcrwJ";
                 
                 c = DriverManager.getConnection(url, username, password );
                 
                 Statement stmt = c.createStatement();
                 
                 ResultSet rs = stmt.executeQuery("select total_people(" + Integer.parseInt(projNum) + ");");
                 
                 
                 while (rs.next()) {
                	 count = rs.getInt("total_people");
                	 System.out.println(count);
      			}
                 
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
            finally
            {
                try
                {
                    if( c != null ) c.close();
                }
                catch( SQLException e )
                {
                    throw new ServletException( e );
                }
           }
             
		}
		
	      request.setAttribute("count", count);
		
		request.getRequestDispatcher("ViewCount.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
