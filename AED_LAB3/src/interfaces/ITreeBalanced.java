package interfaces;

public interface ITreeBalanced<K extends Comparable<K>,T> extends ITree<K, T>{
	
    public void fixAfterDeletion(INodeBB<K, T> x);
    public void fixAfterInsertion(INodeBB<K, T> n);
    public void rotateLeft(INodeBB<K, T> p);
    public void rotateRight(INodeBB<K, T> p);

}
