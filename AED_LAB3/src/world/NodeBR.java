package world;

import interfaces.*;



public class NodeBR<K extends Comparable<K>,T> extends NodeBB<K, T> implements NodeBRJD<K, T> {

	private char color;
	public NodeBR( K key,T element) {
		super(key, element);
	
		setColor(COLOR_RED);
		
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	private int checkI(){
		int ret=0;
       if(isLeaf()){
    	   
			return color==NodeBRJD.COLOR_BLACK?2:1;
		}
       else if(getRight()!=null&&getLeft()!=null){
    	   
       }else{
    	   
       }
		
		return ret;
	}
	public boolean check(){
		boolean ret=false;
		if(isLeaf()){
			checkI();
		}else{
			
		}
		
		return ret;
				
				
	}

}
