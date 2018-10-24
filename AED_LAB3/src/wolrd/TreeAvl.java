package wolrd;

import interfaces.*;

public class TreeAvl<K extends Comparable<K>,T> extends TreeBR<K, T> implements TreeBalancedJD<K, T> {

	@Override
	public void add(K key, T element) {
		NodeAvlJD<K, T> toAdd=new NodeAvl<K, T>(key, element);
		super.add(toAdd);
		int s=size();
		fixAfterInsertion(toAdd);
		getRaiz().setSize(s);
	}
	
	
	
}
