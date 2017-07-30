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

public class AddStudent extends HttpServlet 
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
		String ssn = request.getParameter("ssn");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String degree = request.getParameter("degree");
		

		if (ssn == null || name == null || age == null || gender == null || degree == null) {
			response.sendRedirect("Table");
		}
		else if (ssn != null && !ssn.isEmpty() && name != null && !name.isEmpty() && age != null && !age.isEmpty() && gender != null && !gender.isEmpty() && degree != null && !degree.isEmpty()) {
		     Connection c = null;
             try
             {
                 String url = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s29";
                 String username = "cs4222s29";
                 String password = "Wh0QcrwJ";
   
                  
                 String sql = "insert into student (ssn, name, age, gender, degree) values (?,?,?,?,?)";
   
                 c = DriverManager.getConnection( url, username, password );
                 PreparedStatement pstmt = c.prepareStatement( sql );
                 
                 pstmt.setString(1, ssn);
                 pstmt.setString(2, name);
                 pstmt.setInt(3, Integer.parseInt(age));
                 pstmt.setString(4, gender);
                 pstmt.setString(5, degree);
                 
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
