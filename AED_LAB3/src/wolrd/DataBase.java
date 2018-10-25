package wolrd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import interfaces.*;

public class DataBase {
	
    //data path
	public final static String FILE_PATH = "./data/Players/x.txt";
	// Selected statistical criteria
	public final static String TRUE_SHOOTING_PERCENTAGE = "TS%";
	public final static String OFFENSIVE_REBOUND_PERCENTAGE = "ORB%";
	public final static String DEFENSIVE_REBOUND_PERCENTAGE = "DRB%";
	public final static String TOTAL_REBOUND_PERCENTAGE = "TRB%";
	public final static String ASSIST_PERCENTAGE = "ATS%";
	
	private TreeBR<Integer, Player> playersBR;
	private TreeAvl<Integer, Player> playersAVL;
	
	
	
	
	
	public void fileUpload() throws IOException{
		
		playersAVL = new TreeAvl<>();
		playersBR = new TreeBR<>();
		File file = new File(FILE_PATH);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String a = "";
		
		while (((a = br.readLine()) != null) && a.trim().length() != 0)  {
			if (!a.startsWith("Year")) {
				String [] data  = a.split(",");
				System.out.println(data[2]);
				System.out.println(data[3]);
				System.out.println(data[1]);
				System.out.println(data[7]);
				System.out.println(data[11]);
				System.out.println(data[12]);
				System.out.println(data[13]);
				System.out.println(data[14]);
				
				
				
			}
			
			
		}
		
	}
}
