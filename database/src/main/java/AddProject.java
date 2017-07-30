import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProject extends HttpServlet 
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
		String sponsorName = request.getParameter("sponsorName");
		String startingDate = request.getParameter("startingDate");
		String endingDate = request.getParameter("endingDate");

		if (sponsorName == null || startingDate == null || endingDate == null) {
			response.sendRedirect("Table");
		}
		else if (sponsorName != null && !sponsorName.isEmpty() && startingDate != null && !startingDate.isEmpty() && endingDate != null && !endingDate.isEmpty()) {
		     Connection c = null;
             try
             {
                 String url = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s29";
                 String username = "cs4222s29";
                 String password = "Wh0QcrwJ";
   
                  
                 String sql = "insert into project (sponsor_name, starting_date, ending_date) values (?,?,?)";
   
                 c = DriverManager.getConnection(url, username, password );
                 PreparedStatement pstmt = c.prepareStatement(sql);
                 
                 pstmt.setString(1, sponsorName);
                 pstmt.setString(2, startingDate);
                 pstmt.setString(3, endingDate);
                 
                 pstmt.executeUpdate();
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
		
		response.sendRedirect("Table");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
