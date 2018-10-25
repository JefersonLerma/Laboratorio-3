package world;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

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
	
	
	// for name
	private TreeBR<Integer, Player> playersBRN;
	private TreeAvl<Integer, Player> playersAVLN;
	
	//for TS%
	private TreeBR<Integer, Player> playersBRTS;
	
	//For orb%
	private TreeAvl<Integer, Player> playersAVLORB;
	
	
	//For DRB%
	private TreeBR<Integer, Player> playersBRNDRB;
	
	//For AST%
	private TreeAvl<Integer, Player> playersAVLNAST;
	
	
	private boolean isLoad;
	
	public DataBase() {
		// TODO Auto-generated constructor stub
		
		playersAVLN = null;
		playersBRN = null;
		playersBRTS = null;
		playersAVLORB = null;
		isLoad = false;
		playersBRNDRB = null;
		playersAVLNAST = null;
	}
	
	
	
	public void fileUpload() throws IOException{
		
		playersAVLN = new TreeAvl<>();
		playersBRN = new TreeBR<>();
		playersBRTS = new TreeBR<>();
		playersAVLORB = new TreeAvl<>();
		playersBRNDRB = new TreeBR<>();
		playersAVLNAST = new TreeAvl<>();
		
		File file = new File(FILE_PATH);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String a = "";
		
		while (((a = br.readLine()) != null) && a.trim().length() != 0)  {
			
			if (!a.startsWith("Year")) {
				String [] data  = a.split(",");
                Player toAdd = new Player(data[2], Integer.parseInt(data[3]), data[1], Double.parseDouble(data[7]), Double.parseDouble(data[11]), Double.parseDouble(data[12]), Double.parseDouble(data[13]), Double.parseDouble(data[14]));
                playersBRN.add(data[0].hashCode(), toAdd);
                playersBRTS.add(data[7].hashCode(), toAdd);
                playersAVLORB.add(data[11].hashCode(), toAdd);
            	playersBRNDRB.add(data[12].hashCode(), toAdd);
            	playersAVLNAST.add(data[14].hashCode(), toAdd);
			}
			
			
		}
		isLoad = true;
	}



	public boolean isLoad() {
		return isLoad;
	}
	
	
   public String SearchTS(double n) {
	   
   }


	public void setLoad(boolean isLoad) {
		this.isLoad = isLoad;
	}
	
	
}
