package wolrd;

public class BSTNode<K extends Comparable<K>,V>{

	private K key;
	private V value;
	
	
	private BSTNode p = new BSTNode(null, null);
	private BSTNode left = new BSTNode(null,null);
	private BSTNode right = new BSTNode(null,null);
	
	public BSTNode(K nKey, V nValue) {
		key= nKey;
		value= nValue;
		p= null;
		left = null;
		right = null;
	}

	public BSTNode getP() {
		return p;
	}

	public void setP(BSTNode p) {
		this.p = p;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	
	
	
}
