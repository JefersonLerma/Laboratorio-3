package interfaces;
import java.util.Collection;
public interface NodeBBJD<K,T> {
	
	public static final char LEFT='l';
	public static final char RIGHT='r';
	public char getRelativePosition();
	public void setRelativePosition(char pos);
    public void add(NodeBBJD<K, T> toAdd);
	public NodeBBJD<K,T> getSupe();
	public void setSupe(NodeBBJD<K,T> supe);
	public void inOrderN(Collection<NodeBBJD<K, T>> colection);
	public NodeBBJD<K,T> getLeft();
	public void setLeft(NodeBBJD<K,T> left);
	public NodeBBJD<K,T> getRight();
	public NodeBBJD<K, T> getMax();
	public NodeBBJD<K, T> getMin();
	public void setRight(NodeBBJD<K,T> right);
	public T search(K key);
	public NodeBBJD<K,T> searchNode(K key);
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
