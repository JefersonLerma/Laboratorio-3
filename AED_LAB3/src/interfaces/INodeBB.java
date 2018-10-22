package interfaces;
import java.util.Collection;
public interface INodeBB<K,T> {
	
	public static final char LEFT='l';
	public static final char RIGHT='r';
	public char getRelativePocision();
	public void setRelativePocision(char pos);
    public void add(INodeBB<K, T> toAdd);
	public INodeBB<K,T> getSupe();
	public void setSupe(INodeBB<K,T> supe);
	public void inOrderN(Collection<INodeBB<K, T>> colection);
	public INodeBB<K,T> getLeft();
	public void setLeft(INodeBB<K,T> left);
	public INodeBB<K,T> getRight();
	public INodeBB<K, T> getMax();
	public INodeBB<K, T> getMin();
	public void setRight(INodeBB<K,T> right);
	public T search(K key);
	public INodeBB<K,T> searchNode(K key);
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
