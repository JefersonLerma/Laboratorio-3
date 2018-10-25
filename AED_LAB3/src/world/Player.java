package world;


public class Player {
 
  private String name;
  private int age;
  private String team;
  private double Ts;
  private double Orb;
  private double Drb;
  private double Trb;
  private double Ast;
  
  public Player(String pName, int pAge, String pTeam, double pTs, double pOrb, double pDrb, double pTrb, double pAst) {
	  
	  name = pName;
	  age = pAge;
	  team = pTeam;
	  Ts = pTs;
	  Orb = pOrb;
	  Drb = pDrb;
	  Trb = pTrb;
	  Ast = pAst;
	  
  }
  
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getTeam() {
	return team;
}

public void setTeam(String team) {
	this.team = team;
}

public double getTs() {
	return Ts;
}

public void setTs(double ts) {
	Ts = ts;
}

public double getOrb() {
	return Orb;
}

public void setOrb(double orb) {
	Orb = orb;
}

public double getDrb() {
	return Drb;
}

public void setDrb(double drb) {
	Drb = drb;
}

public double getTrb() {
	return Trb;
}

public void setTrb(double trb) {
	Trb = trb;
}

public double getAst() {
	return Ast;
}

public void setAst(double ast) {
	Ast = ast;
}

  
 
 
 
	
}
