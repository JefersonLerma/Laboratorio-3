package interfaces;

public interface NodeAvlJD<K extends Comparable<K>,T> extends NodeBBJD<K, T>{

	public static final int WEIGHT_LEFT=1;
	public static final int WEIGHT_RIGHT=-1;
	public static final int BALANCED=0;
	public int getFactor();
	public void setFactor(int fa);
	public void asignFactors();

	
}
