import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

public class IntermediateProgramMaker extends ProgramMaker{

	
	@Override
	public String[] generateProgram(Connection c) throws SQLException {
		String squat = "squat", bench = "bench", deadlift = "deadlift";
		String accessory1, accessory2;
		String quad;
		String hamstring;
		
		Random r = new Random();
		
		quad = quads[r.nextInt(quads.length)];
		hamstring = hamstrings[r.nextInt(hamstrings.length)];
		int rand1 = r.nextInt(accessories.length);
		int rand2 = r.nextInt(accessories.length);
		accessory1 = accessories[rand1][r.nextInt(accessories[rand1].length)];
		accessory2 = accessories[rand2][r.nextInt(accessories[rand2].length)];
		
		program = new String[7];
		
		program[0] = squat + " " + RPE8 + " " + high[r.nextInt(high.length)] + " " + low[r.nextInt(low.length)];
		program[1] = bench + " " + RPE8 + " " + high[r.nextInt(high.length)] + " " + low[r.nextInt(low.length)];
		program[2] = deadlift + " " + RPE8 + " " + high[r.nextInt(high.length)] + " " + low[r.nextInt(low.length)];
		program[3] = quad + " " + RPE8 + " " + low[r.nextInt(low.length)] + " " + high[r.nextInt(high.length)];
		program[4] = hamstring + " " + RPE8 + " " + low[r.nextInt(low.length)] + " " + high[r.nextInt(high.length)];
		program[5] = accessory1 + " " + RPE8 + " " + low[r.nextInt(low.length)] + " " + high[r.nextInt(high.length)];
		program[6] = accessory2 + " " + RPE8 + " " + low[r.nextInt(low.length)] + " " + high[r.nextInt(high.length)];
		
		return program;
	}

}
