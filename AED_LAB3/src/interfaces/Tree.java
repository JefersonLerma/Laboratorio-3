package interfaces;

import java.util.Collection;

public interface Tree<K,T> {
	
	public void add(K key, T element);
	public void add(NodeBB<K, T> toAdd);
	public int size();
	public int height();
	public void delete(K key);
	public void delete(NodeBB<K, T> key);
	public boolean exist(K elemento);
	public void inOrden(Collection<T> colection);
	public void posOrden(Collection<T> colection);
	public void preOrden(Collection<T> colection);
	public T search(K key);
	public NodeBB<K,T> getRaiz();
	public void setRaiz(NodeBB<K,T> nu);
}
