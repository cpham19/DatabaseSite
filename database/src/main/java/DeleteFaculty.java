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

public class DeleteFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
        	Class.forName("org.postgresql.Driver");
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String ssn = request.getParameter("ssn");
		Connection c = null;
		try{
            String url = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s29";
            String username = "cs4222s29";
            String password = "Wh0QcrwJ";
			
			c = DriverManager.getConnection(url,username,password);

	        String sql = "delete from faculty where id = ?";
	        PreparedStatement pstmt = c.prepareStatement(sql);
	        pstmt.setInt(1,id);
	        
			pstmt.executeUpdate();
	        
	        String sql2 = "delete from proj_work where wkr_ssn = '" + ssn + "'";
	        pstmt = c.prepareStatement(sql2);
	    
	        pstmt.executeUpdate();
	            
		}catch(SQLException ex){
			throw new ServletException(ex);
		}
	    finally{
            try{
                if( c != null ) c.close();
            }
            catch( SQLException e ){
                throw new ServletException( e ); 
            }
        }
		
		response.sendRedirect("Table");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
