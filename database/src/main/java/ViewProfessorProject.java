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

public class ViewProfessorProject extends HttpServlet 
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
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		ArrayList<Integer> listOfProjNum = new ArrayList<>();
		ArrayList<ProjectModel> projects = new ArrayList<>();		
		
		Connection c = null;
        try
        {
            String url = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s29";
            String username = "cs4222s29";
            String password = "Wh0QcrwJ";
            c = DriverManager.getConnection( url, username, password );
             
            Statement stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from prof_work");
            
            while (rs.next()) {
        		if(rs.getString("wkr_ssn").equals(ssn)) {
        			System.out.println(rs.getString("wkr_ssn") + " " + ssn);
        			listOfProjNum.add(rs.getInt("proj_num"));
        		}
 			}
                      
            rs = stmt.executeQuery("select * from project");
            
	             while (rs.next()) {
	        		
	            	ProjectModel entry = new ProjectModel(rs.getInt("project_num"), rs.getString("sponsor_name"), rs.getString("starting_date"), rs.getString("ending_date"));
	            	
	                for (int i = 0; i < listOfProjNum.size(); i++) {
		            	if (entry.getProjectNum() == listOfProjNum.get(i)) {
		            		projects.add(entry);
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
        
        request.setAttribute("name", name);
        request.setAttribute("projects", projects);
        
        request.getRequestDispatcher("ViewProfessorProject.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
