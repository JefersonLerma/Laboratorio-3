package world;

import interfaces.*;
import java.util.*;

public class NodeBB<K extends Comparable<K>,T> implements NodeBBJD<K, T>{
	
    private NodeBBJD<K, T> left;
private NodeBBJD<K, T> right;
private NodeBBJD<K, T> supe;
private T element;
private int size;
private K key;
private char relativePosition;	

public NodeBB(K key,T element){
	this.element=element;
	this.key=key;
	setRelativePosition(' ');

}
public NodeBB(K key,T pElement,char rela,NodeBB<K,T> sup) {
	supe=sup;
	element=pElement;
	this.key=key;
	setRelativePosition(rela);
}


public NodeBBJD<K, T> getLeft() {
	return left;
}


public void setLeft(NodeBBJD<K, T> left) {
	this.left = left;
}


public NodeBBJD<K, T> getRight() {
	return right;
}


public void setRight(NodeBBJD<K, T> right) {
	this.right = right;
}


public NodeBBJD<K, T> getSupe() {
	return supe;

}


public void setSupe(NodeBBJD<K, T> supe) {
	this.supe = supe;
}


public T getElement() {
	return element;
}


public void setElement(T element) {
	this.element = element;
}

public void setKey(K key){
	this.key=key;
}
public K getKey() {
	return key;
}

public void add(NodeBBJD<K, T> toAdd) {
	
if(this.key.compareTo(toAdd.getKey())<0){
	if(right==null){
		
		right=toAdd;
		right.setRelativePosition(RIGHT);
		right.setSupe(this);

	}else{
		right.add(toAdd);
	}
}else{
	if(left==null){
		left=toAdd;

		left.setRelativePosition(LEFT);
		left.setSupe(this);

	}else{
		left.add(toAdd);

	}
	
}
	
}

public T search(K key){
	T ret=null;
	if(this.key.compareTo(key)==0){
		ret=element;
	}else if(this.key.compareTo(key)<0){
		if(right!=null){
			ret=right.search(key);

		}

	}else{
		if(left!=null){
			ret=left.search(key);

		}

	}
	return ret;
	
}
public NodeBBJD<K, T> searchNode(K key){
	NodeBBJD<K, T> ret=null;
	if(this.key.compareTo(key)==0){
		ret=this;
	}else if(this.key.compareTo(key)<0){
		if(right!=null){
			ret=right.searchNode(key);

		}

	}else{
		if(left!=null){
			ret=left.searchNode(key);

		}

	}
	return ret;
	
}


public int size() {
	
	return size;
}


public int height() {
	int heigtRight=1;
	int heigtLeft=1;
	if(right!=null){
		
		heigtRight+=right.height();
	}
		
	if(left!=null){
		heigtLeft+=left.height();
	}
	return Math.max(heigtRight, heigtLeft);
}

public void setSize(int size){
	this.size=size;
}


public NodeBBJD<K, T> getMax(){
	NodeBBJD<K, T> max=null;
	if(right !=null){
		max=right.getMax();
	}
	else{
		max=(NodeBBJD<K, T>)this;
	}
	return max;
	
}

public NodeBBJD<K, T> getMin(){
	NodeBBJD<K, T> min=null;
	if(left !=null){
		min=left.getMin();
	}
	else{
		min=this;
	}
	return min;
	
}

public void inOrder(Collection<T> colection) {
	if(left!=null){
		left.inOrder(colection);
	}
	colection.add(element);
	if(right!=null){
		right.inOrder(colection);
	}
	
}
public void inOrderN(Collection<NodeBBJD<K, T>> colection) {
	if(left!=null){
		left.inOrderN(colection);
	}
	colection.add(this);
	if(right!=null){
		right.inOrderN(colection);
	}
	
}
public char getRelativePosition() {
	return relativePosition;
}
public void setRelativePosition(char relativePosition) {
	this.relativePosition = relativePosition;
}
@Override
public void posOrder(Collection<T> colection) {
	if(left!=null){
		left.inOrder(colection);
	}
	if(right!=null){
		right.inOrder(colection);
	}
	colection.add(element);

}
@Override
public void preOrder(Collection<T> colection) {
	colection.add(element);

	if(left!=null){
		left.inOrder(colection);
	}
	if(right!=null){
		right.inOrder(colection);
	}		
}
@Override
public boolean isLeaf() {
	// TODO Auto-generated method stub
	return right==null&&left==null;
}

}
