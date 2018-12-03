import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdvancedRawProgramMaker extends ProgramMaker{

	public static final String RPE8 = "@8";
	
	//Movement - Intensity - Sets - Reps
	public String[][]Program;
	
	@Override
	public void generateProgram() throws SQLException {
		String squat, bench, deadlift;
		String squatVar, benchVar, deadliftVar;
		String triceps1, triceps2;
		String quads;
		String hamstrings;
		
		String host = "fq-wifi-10-215-205-87.wireless.pitt.edu";
		String username = "liftingpal";
		String password = "liftingiscool";
		
		Connection con = DriverManager.getConnection(host, username, password);
		
		
	}

}
