package interfaces;
import java.util.Collection;
public interface NodeBB<K,T> {
	
	public static final char LEFT='l';
	public static final char RIGHT='r';
	public char getRelativePocision();
	public void setRelativePocision(char pos);
    public void add(NodeBB<K, T> toAdd);
	public NodeBB<K,T> getSupe();
	public void setSupe(NodeBB<K,T> supe);
	public void inOrderN(Collection<NodeBB<K, T>> colection);
	public NodeBB<K,T> getLeft();
	public void setLeft(NodeBB<K,T> left);
	public NodeBB<K,T> getRight();
	public NodeBB<K, T> getMax();
	public NodeBB<K, T> getMin();
	public void setRight(NodeBB<K,T> right);
	public T search(K key);
	public NodeBB<K,T> searchNode(K key);
	public void inOrder(Collection<T> coleccion);
	public void posOrder(Collection<T> colection);
	public void preOrder(Collection<T> colection);
	public int size();
	public void setSize(int size);
	public int height();
	public T getElement();
	public K getKey();
	public void setKey(K key);
	public void setElement(T element);
	public boolean isLeaf();

}
