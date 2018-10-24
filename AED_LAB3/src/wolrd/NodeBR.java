package wolrd;

import interfaces.*;
import javafx.scene.Node;


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
	private int verificarI(){
		int ret=0;
       if(isLeaf()){
    	   
			return color==NodeBRJD.COLOR_BLACK?2:1;
		}
       else if(getRight()!=null&&getLeft()!=null){
    	   
       }else{
    	   
       }
		
		return ret;
	}
	public boolean verificar(){
		boolean ret=false;
		if(isLeaf()){
			verificarI();
		}else{
			
		}
		
		return ret;
				
				
	}

}
