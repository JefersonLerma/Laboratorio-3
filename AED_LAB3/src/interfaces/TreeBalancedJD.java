package interfaces;

public interface TreeBalancedJD<K extends Comparable<K>,T> extends TreeJD<K, T>{
	
    public void fixAfterDeletion(NodeBBJD<K, T> x);
    public void fixAfterInsertion(NodeBBJD<K, T> n);
    public void rotateLeft(NodeBBJD<K, T> p);
    public void rotateRight(NodeBBJD<K, T> p);

}
