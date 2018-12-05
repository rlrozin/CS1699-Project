import java.sql.Connection;
import java.sql.SQLException;

public abstract class ProgramMaker {

	public String[] benchVars = {"pin press" , 
	                            "board press",
	                            "spoto press",
	                            "3/0/3 bench press",
	                            "banded bench press",
	                            "bench press with chains",
	                            "3 count pause"};
	
	public String[] squatVars = {"pause squat",
		    					"banded squat",
		    					"reverse banded squat",
		    					"squat with chains",
		    					"3/0/3 squat",
		    					"front squat"};
	
	public String[] deadliftVars = {"deadlift paused off the floor",
		    						"deadlift with chains",
		    						"banded deadlift",
		    						"reverse banded deadlift",
		    						"romanian deadlift",
		    						"snatch grip deadlift",
		    						"stiff leg deadlift"};
	
	public String[] triceps = {"lying tricep extension",
		    					"french press",
		    					"skull crusher",
		    					"tricep pushdowns"};
	
	public String[] chest = {"dumbbell flyes",
							"cable flyes",
							"dumbbell bench press"};
	
	public String[] quads = {"leg press",
		    				"hack squat machine",
		    				"leg extensions",
		    				"goblet squats"};
	
	public String[] hamstrings = {"glute ham raise machine",
		    						"nordic curls",
		    						"hamstring curl machine",
		    						"barbell good mornings"};
	
	public String[] glutes = {"lunges",
		    					"barbell glute bridges",
		    					"barbell good mornings"};
	
	public String[] shoulders = {"dumbbell shoulder press",
		    						"z press",
		    						"3 way shoulder raise complex",
		    						"rear delt flyes",
		    						"lateral raises",
		    						"front raises"};
	
	public String[] back = {"barbell rows",
		    				"dumbbell rows",
		    				"t bar rows",
		    				"lat pull downs",
		    				"pull ups",
		    				"chin ups"};
	
	public String[][] accessories = {triceps, chest, glutes, shoulders, back};
	
	public static final String RPE8 = "@8";
	
	//Movement - Intensity - Sets - Reps
	public String[] program;
	
	public int[] low = {1,2,3};
	public int[] med = {4,5,6};
	public int[] high = {7,8,9,10};
	
	public int[][] values = {low, med, high};
	
	public abstract String[] generateProgram(Connection c) throws SQLException;
}
