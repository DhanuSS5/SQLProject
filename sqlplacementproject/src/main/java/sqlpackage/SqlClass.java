package sqlpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SqlClass {

	
		public static void main(String[] args) throws SQLException{
			// TODO Auto-generated method stub
			
			 
	            Connection conn = null;
			
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		
				String dbURL = "jdbc:sqlserver://localhost:1433;databasename=student_db";
				
				// String dbURL = "jdbc:sqlserver://localhost:1433;databasename=SOLTraining;integratedSecurity=true";
				String user = "sa";  // username
				//String user = "";
		        String pass = "dhanasree"; //password
				//String pass = "";		

		conn = DriverManager.getConnection(dbURL, user, pass);//Establishing Connection
				
		        if (conn != null) {
		        	Statement st;
				st = conn.createStatement();//Creating Statement
		        	String query = "update student_db set sname = 'Sanu' where name='Anu'";
		        	
		        	String query1 = "select * from student_db";
		        	
		        	int res = st.executeUpdate(query);//Execute statement--when using update,insert commands.. output                                                                                                   comes as integer(1)row affected.. so have to store in integer
		        	if(res>0){
		        		System.out.println("Updated");
		        	}else
		        	{
		        		System.out.println("update unsuccessful");
		        	}
		        	
		        	ResultSet rs = st.executeQuery(query1);//Execute statement gets data from the table
		        	while(rs.next()){
		        		int empid=rs.getInt(1);
		        		String name=rs.getString(2);
		        		String desig=rs.getString(3);
		        		System.out.println(empid + " " +name+ " "+desig);
		        

		       
		        	}
		        }
				}
		        	
		        	

		        	
		        
		        catch(ClassNotFoundException e) 
				{
		
		e.printStackTrace();
	}
		        
	finally{

		try {
	        if (conn != null) {
	            conn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
		}
	}
		        


	    
				
			



	

