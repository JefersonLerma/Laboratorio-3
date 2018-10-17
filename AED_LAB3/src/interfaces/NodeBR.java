package interfaces;

public interface NodeBR<K extends Comparable<K>,T> extends NodeBB<K, T>{
	
	public static char COLOR_BLACK='b';
	public static char COLOR_RED='r';
	public char getColor();
	public void setColor(char color);

}
