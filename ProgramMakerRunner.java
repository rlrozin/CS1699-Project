import java.sql.SQLException;
import java.sql.*;

public class ProgramMakerRunner {

	public static void main(String [] args) throws SQLException {
		ProgramMaker pm = new BeginnerProgramMaker();
		pm.generateProgram();
	}
	
}
