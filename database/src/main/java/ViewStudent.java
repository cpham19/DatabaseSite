import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewStudent extends HttpServlet 
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
		String sponsorName = request.getParameter("spon_name");
		ArrayList<String> listOfStudSSN = new ArrayList<>();
		ArrayList<StudentModel> students = new ArrayList<>();		
		
		Connection c = null;
        try
        {
            String url = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s29";
            String username = "cs4222s29";
            String password = "Wh0QcrwJ";
            c = DriverManager.getConnection( url, username, password );
             
            Statement stmt = c.createStatement();
            
            
            ResultSet rs = stmt.executeQuery("select * from stud_work");
            
            while (rs.next()) {
        		if(rs.getString("proj_num").equals(projNum)) {
        			listOfStudSSN.add(rs.getString("stud_ssn"));
        		}
 			}
                      
            rs = stmt.executeQuery("select * from student");
            
	             while (rs.next()) {
	        		
	            	StudentModel entry = new StudentModel(rs.getInt("id"), rs.getString("ssn"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"), rs.getString("degree"));
	              
	                for (int i = 0; i < listOfStudSSN.size(); i++) {
		            	if (entry.getSsn().equals(listOfStudSSN.get(i))) {
		            		students.add(entry);
		            	}
	                }
           }      
                
        }
         
        catch( SQLException e ) {
        	 
            throw new ServletException( e );
             
        }
         
        finally {
        	 
            try {
            	 
                if( c != null ) c.close();
                
            }
            
            catch( SQLException e ) {
            	 
                throw new ServletException( e );
                 
            }
             
        }
        
        
        request.setAttribute("students", students);
        request.setAttribute("sponsor", sponsorName);
        
        request.getRequestDispatcher("ViewStudent.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
