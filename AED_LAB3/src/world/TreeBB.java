package wolrd;

import java.util.Collection;

import interfaces.NodeBBJD;
import interfaces.TreeJD;


public class TreeBB<K extends Comparable<K>, T> implements TreeJD<K, T> {
	private NodeBBJD<K, T> root;

	public TreeBB() {

	}


	@Override
	public void add(K key, T elemento) {
		
			NodeBB<K, T> nue=new NodeBB<K,T>(key,elemento);
			add(nue);
		
	}

	@Override
	public int size() {
      		if (root == null) {
			return 0;

		} else {
			return root.size();
		}
	}

	@Override
	public int height() {
		if (root == null) {
			return 0;

		} else {
			return root.height()-1;
		}
	}

	@Override
	public void delete(K key) {
		NodeBBJD<K,T> nodo=null;
		if(root!=null){
			nodo=root.searchNode(key);
			if(nodo!=null){
				int s=size();
				delete(nodo);
				root.setSize(s-1);
			}
		
		
				
		}
	}

	@Override
	public boolean exist(K key) {
		boolean a=search(key)==null?false:true;
		
		return a;
	}

	@Override
	public void inOrder(Collection<T> colection) {
		if(colection!=null){
			if(root!=null){
				root.inOrder(colection);
			}
		}

	}
	public void inOrderN(Collection<NodeBBJD<K, T>> colection) {
		if(colection!=null){
			if(root!=null){
				root.inOrderN(colection);
			}
		}

	}

	@Override
	public T search(K key) {
		// TODO Auto-generated method stub
		T ret=null;
		if(root!=null){
			ret=root.search(key);
		}
		return ret;
	}
	


	@Override
	public void posOrder(Collection<T> collection) {
			if(collection!=null){
		if(root!=null){
			root.posOrder(collection);
		}
	}
		
	}

	@Override
	public void preOrder(Collection<T> collection) {
		if(collection!=null){
			if(root!=null){
				root.preOrder(collection);
			}
		}		
	}

	@Override
	public NodeBBJD<K, T> getRaiz() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public void setRaiz(NodeBBJD<K, T> nu) {
		root= nu;
		
	}

	@Override
	public void add(NodeBBJD<K, T> nuevo) {
		if (root == null) {
			root =nuevo;

		} else {	
			root.add(nuevo);
		}
		root.setSize(root.size()+1);

	}

	@Override
	public void delete(NodeBBJD<K, T> nodo) {
		if(nodo!=null){
		if(nodo.getRight()!=null&&nodo.getLeft()!=null){
			NodeBBJD<K,T> min=nodo.getRight().getMin();
			nodo.setElement(min.getElement());
			nodo.setKey(min.getKey());
			nodo=min;
		}
		
		NodeBBJD<K,T> tmp=nodo.getLeft()!=null?nodo.getLeft():nodo.getRight();

		if(tmp!=null){
			tmp.setSupe(nodo.getSupe());
			tmp.setRelativePosition(nodo.getRelativePosition());
			if(nodo.getRelativePosition()==NodeBBJD.LEFT){
				nodo.getSupe().setLeft(tmp);
			}else if(nodo.getRelativePosition()==NodeBBJD.RIGHT){
				nodo.getSupe().setRight(tmp);
			}else{
				setRaiz(tmp);
			}
			nodo=tmp;
		}
		else{
			if(nodo.getRelativePosition()==NodeBBJD.LEFT){
				nodo.getSupe().setLeft(null);
			}else if(nodo.getRelativePosition()==NodeBBJD.RIGHT){
				nodo.getSupe().setRight(null);
			}else{
				setRaiz(null);
			}
		}
		
	}
		
	}


}
