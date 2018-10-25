package wolrd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import interfaces.*;

public class DataBase {
	
    //data path
	public final static String FILE_PATH = "./data/Players/NBA_DATA.csv";
	// Selected statistical criteria
	public final static String TRUE_SHOOTING_PERCENTAGE = "TS%";
	public final static String OFFENSIVE_REBOUND_PERCENTAGE = "ORB%";
	public final static String DEFENSIVE_REBOUND_PERCENTAGE = "DRB%";
	public final static String TOTAL_REBOUND_PERCENTAGE = "TRB%";
	public final static String ASSIST_PERCENTAGE = "ATS%";
	
	private TreeBR<Integer, Player> playersBR;
	private TreeAvl<Integer, Player> playersAVL;
	
	public DataBase() {
		// TODO Auto-generated constructor stub
		
		playersAVL = null;
		playersBR = null;
	}
	
	
	
	public void fileUpload() throws IOException{
		
		playersAVL = new TreeAvl<>();
		playersBR = new TreeBR<>();
		File file = new File(FILE_PATH);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String a = "";
		int contador = 0;
		while (((a = br.readLine()) != null) && a.trim().length() != 0)  {
			
			if (!a.startsWith("Year")) {
				contador ++;
				String [] data  = a.split(",");
				System.out.println(contador+"" + " - " +data[2] +" "+ data[3]+ " "+data[1] + " " + data[7] + " " + data[11] + " " + data[12] + " " + data[13] + " " + data[14]);
                Player toAdd = new Player(data[2], Integer.parseInt(data[3]), data[1], Double.parseDouble(data[7]), Double.parseDouble(data[11]), Double.parseDouble(data[12]), Double.parseDouble(data[13]), Double.parseDouble(data[14]));
                playersAVL.add(data[0].hashCode(), toAdd);
                playersBR.add(data[0].hashCode(), toAdd);
		
			
			}
			
			
		}
		
	}
}
