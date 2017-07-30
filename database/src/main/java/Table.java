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

public class Table extends HttpServlet 
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
		ArrayList<FacultyModel> faculties = new ArrayList<>();
		ArrayList<ProjectModel> projects = new ArrayList<>();	
		ArrayList<StudentModel> students = new ArrayList<>();	
		
		Connection c = null;
        try
        {
            String url = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s29";
            String username = "cs4222s29";
            String password = "Wh0QcrwJ";
            c = DriverManager.getConnection( url, username, password );
             
            Statement stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from faculty");
            
            while (rs.next()) {
        		
            	FacultyModel entry = new FacultyModel(rs.getInt("id"), rs.getString("ssn"), rs.getString("name"), rs.getInt("age"),
            										  rs.getString("gender"), rs.getString("rank"), rs.getString("res_spec"));
            	
            	faculties.add(entry);
 			}
            
            rs = stmt.executeQuery("select * from project");
            
            while (rs.next()) {
        		
            	ProjectModel entry = new ProjectModel(rs.getInt("project_num"), rs.getString("sponsor_name"), rs.getString("starting_date"), rs.getString("ending_date"));
            	
            	projects.add(entry);
 			}
            
           rs = stmt.executeQuery("select * from student");
            
            while (rs.next()) {
        		
            	StudentModel entry = new StudentModel(rs.getInt("id"), rs.getString("ssn"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"), rs.getString("degree"));
            	
            	students.add(entry);
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
        
        request.setAttribute("faculties", faculties);
        request.setAttribute("projects", projects);
        request.setAttribute("students", students);
        
        request.getRequestDispatcher("Table.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}