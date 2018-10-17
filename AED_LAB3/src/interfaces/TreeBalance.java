package interfaces;

public interface TreeBalance<K extends Comparable<K>,T> extends Tree<K, T>{
	
    public void fixAfterDeletion(NodeBB<K, T> x);
    public void fixAfterInsertion(NodeBB<K, T> n);
    public void rotateLeft(NodeBB<K, T> p);
    public void rotateRight(NodeBB<K, T> p);

}
