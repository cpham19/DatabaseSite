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

public class AddProjectToStud extends HttpServlet 
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
		String studSsn = request.getParameter("stud_ssn");
		String projNum = request.getParameter("proj_num");

		if (studSsn == null || projNum == null) {
			response.sendRedirect("Table");
		}
		else if (studSsn != null && !studSsn.isEmpty() && projNum != null && !projNum.isEmpty()) {
		     Connection c = null;
             try
             {
                 String url = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s29";
                 String username = "cs4222s29";
                 String password = "Wh0QcrwJ";
   
                 String sql = "insert into stud_work (stud_ssn, proj_num) values (?,?)";
   
                 c = DriverManager.getConnection(url, username, password );
                 PreparedStatement pstmt = c.prepareStatement(sql);
                 
                 pstmt.setString(1, studSsn);
                 pstmt.setInt(2, Integer.parseInt(projNum));
                 
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
