package interfaces;

public interface Tree<K,T> {
	
	public void add(K key, T element);
	public void add(NodeBB<K, T> toAdd);

}
