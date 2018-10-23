package interfaces;

public interface NodeBRJD<K extends Comparable<K>,T> extends NodeBBJD<K, T>{
	
	public static char COLOR_BLACK='b';
	public static char COLOR_RED='r';
	public char getColor();
	public void setColor(char color);

}
