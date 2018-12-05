import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class ProgramMakerRunner {

	public static void main(String [] args) throws SQLException, FileNotFoundException{

		String host = "jdbc:mysql://localhost:3306/users";
		String username = "liftingpal";
		String password = "liftingiscool";
		
		Connection con = DriverManager.getConnection(host, username, password);
		
		Statement smt = con.createStatement();
		
		String sql = "select * from users where username = '" + username + "'";
		
		ResultSet rs = smt.executeQuery(sql);
		
		rs.next();
		
		String difficulty = rs.getString(9);
		
		ProgramMaker pm = new BeginnerProgramMaker();
		
		if(difficulty.equals( "beginner")){

		} else if(difficulty.equals("intermediate")){
			pm = new IntermediateProgramMaker();
		} else if(difficulty.equals("advanced")){
			if(rs.getString(8).equals("raw")){
				pm = new AdvancedRawProgramMaker();
			}
		} else {
			pm = new AdvancedEquippedProgramMaker();
		}
		
		
		String[] p = pm.generateProgram(con);
		
		File f = new File("program.html");
		
		PrintWriter pw = new PrintWriter(f);
		
		pw.println("<!doctype html> <html lang=\"en\"> <head> <!-- Required meta tags --> <meta charset=\"utf-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">  <!-- Bootstrap CSS --> <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">  <link rel=\"stylesheet\" type=\"text/css\" href=\"model/main.css\"> "
				+ "<title>LiftingPal Login</title> </head> <body> <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">   <a class=\"navbar-brand\" href=\"login.html\">LiftingPal</a> <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">  <span class=\"navbar-toggler-icon\"></span> </button> <div class=\"collapse navbar-collapse\" id=\"navbarNav\">  <ul class=\"navbar-nav\">  <li class=\"nav-item\">  <a class=\"nav-link\" href=\"dashboard.html\">Dashboard</a>  </li>  <li class=\"nav-item nav-item dropdown\">  <a class=\"nav-link dropdown-toggle\" href=\"calculators.html\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">   Questionnaires   </a>  <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">    <a class=\"dropdown-item\" href=\"questionnaire.html\"> Pre-Block Questionnaire </a>  <a class=\"dropdown-item\" href=\"post-block questionnaire.html\"> Post-Block Questionnaire </a>  </div> </li>   <li class=\"nav-item nav-item dropdown\"> <a class=\"nav-link dropdown-toggle\" "
						+ "href=\"calculators.html\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">  Calculators   </a>  <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">  <a class=\"dropdown-item\" href=\"macros.html\">Macronutrient Calculator</a>  <a class=\"dropdown-item\" href=\"ORM.html\">One Rep Max Calculator</a>  </div> </li>  <li class=\"nav-item\">  <a class=\"nav-link\" href=\"socialmedia.html\">Social Media</a> </li>  <li class=\"nav-item\">  <a class=\"nav-link\" href=\"dictionary.html\">Dictionary</a>  </li>  </ul>  <ul class=\"navbar-nav ml-auto\">  <li class=\"nav-item\">  <a class=\"nav-link\" href=\"login.html\">Login</a>  </li> </ul> </div> </nav>");
		
		pw.println("<h1> Workout Generated </h1> <div>");
		
		pw.println("Exercise    RPE    Sets    Reps  <br>");
		
		for(int x = 0; x < p.length; x++){
			pw.println(p[x] + "<br>");
		}
		
		pw.println("</div>");
		
		pw.flush();
		
		pw.close();
		
		con.close();
	}
	
}
