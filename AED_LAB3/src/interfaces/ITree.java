package interfaces;

import java.util.Collection;

public interface ITree<K,T> {
	
	public void add(K key, T element);
	public void add(INodeBB<K, T> toAdd);
	public int size();
	public int height();
	public void delete(K key);
	public void delete(INodeBB<K, T> key);
	public boolean exist(K elemento);
	public void inOrder(Collection<T> colection);
	public void posOrder(Collection<T> colection);
	public void preOrder(Collection<T> colection);
	public T search(K key);
	public INodeBB<K,T> getRaiz();
	public void setRaiz(INodeBB<K,T> nu);
}
