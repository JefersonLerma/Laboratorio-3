package world;

import java.util.ArrayList;
import java.util.Collection;

import interfaces.NodeBBJD;
import interfaces.NodeBRJD;
import interfaces.TreeBalancedJD;




public class TreeBR<K extends Comparable<K>, T> extends TreeBB<K, T> implements TreeBalancedJD<K, T>{

	public TreeBR() {
		 
		// TODO Auto-generated constructor stub
	}
	@Override
	public void add(K key, T element) {
		NodeBRJD<K, T> nuevo = new NodeBR<K, T>( key,element);
		super.add(nuevo);
		int s=size();
		fixAfterInsertion(nuevo);
		getRaiz().setSize(s);

	}
	@Override
	public void fixAfterInsertion(NodeBBJD<K, T> n) {
		NodeBRJD<K, T> x=(NodeBRJD<K, T>)n;
		while (x != null && x != getRaiz() && ((NodeBRJD<K, T>) x.getSupe()).getColor() == NodeBRJD.COLOR_RED) {
			NodeBRJD<K, T> padre = (NodeBRJD<K, T>) x.getSupe();
			if (padre.getRelativePosition() == NodeBBJD.LEFT) {
				NodeBRJD<K, T> y = (NodeBRJD<K, T>) padre.getSupe().getRight();
				if (y != null && y.getColor() == NodeBRJD.COLOR_RED) {
					padre.setColor(NodeBRJD.COLOR_BLACK);
					y.setColor(NodeBRJD.COLOR_BLACK);
					((NodeBRJD<K, T>) padre.getSupe()).setColor(NodeBRJD.COLOR_RED);
					x = (NodeBRJD<K, T>) padre.getSupe();
				} else {
					if (x.getRelativePosition() == NodeBBJD.RIGHT) {
						x = padre;

						rotateLeft(x);
					}
					padre=(NodeBRJD<K, T>) x.getSupe();

					 padre.setColor(NodeBRJD.COLOR_BLACK);
					((NodeBRJD<K, T>) padre.getSupe()).setColor(NodeBRJD.COLOR_RED);

					rotateRight((NodeBRJD<K, T>) padre.getSupe());
				}
			} else {
				NodeBRJD<K, T> y = (NodeBRJD<K, T>) padre.getSupe().getLeft();
				if (y != null && y.getColor() == NodeBRJD.COLOR_RED) {
					padre.setColor(NodeBRJD.COLOR_BLACK);
					y.setColor(NodeBRJD.COLOR_BLACK);
					((NodeBRJD<K, T>) padre.getSupe()).setColor(NodeBRJD.COLOR_RED);
					x = (NodeBRJD<K, T>) padre.getSupe();

				} else {
					if (x.getRelativePosition() == NodeBBJD.LEFT) {
						x = padre;
						rotateRight(x);
					}
					padre=(NodeBRJD<K, T>) x.getSupe();

					padre.setColor(NodeBRJD.COLOR_BLACK);
					((NodeBRJD<K, T>) padre.getSupe()).setColor(NodeBRJD.COLOR_RED);
					rotateLeft((NodeBRJD<K, T>) padre.getSupe());

				}
			}
		}
		((NodeBRJD<K, T>) getRaiz()).setColor(NodeBRJD.COLOR_BLACK);
	}
@Override
	public void rotateRight(NodeBBJD<K, T> p) {
		if (p != null) {
			NodeBBJD<K, T> l =  p.getLeft();
			p.setLeft(l.getRight());
			if (l.getRight() != null) {
				l.getRight().setSupe(p);
				p.getLeft().setRelativePosition(NodeBBJD.LEFT);


			}
			l.setSupe(p.getSupe());
			l.setRelativePosition(p.getRelativePosition());

			if (p.getSupe() == null) {
				setRaiz(l);											
			} else if (p.getRelativePosition() == NodeBBJD.RIGHT) {
				p.getSupe().setRight(l);
			} else {
				p.getSupe().setLeft(l);
			}
			l.setRight(p);
			p.setRelativePosition(NodeBBJD.RIGHT);

			p.setSupe(l);
		}
	}
@Override
	public void rotateLeft(NodeBBJD<K, T> p) {
		if (p != null) {
			NodeBBJD<K, T> r =  p.getRight();
			p.setRight(r.getLeft());
			if (r.getLeft() != null) {
				r.getLeft().setSupe(p);
				p.getRight().setRelativePosition(NodeBBJD.RIGHT);

			}
			r.setSupe(p.getSupe());
			r.setRelativePosition(p.getRelativePosition());
			if (p.getSupe() == null) {
				setRaiz(r);

			} else if (p.getRelativePosition() == NodeBBJD.LEFT) {
				p.getSupe().setLeft(r);

			} else {
				p.getSupe().setRight(r);

			}
			r.setLeft(p);
			p.setRelativePosition(NodeBBJD.LEFT);
			p.setSupe(r);
		}
	}
@Override
	public void delete(K key) {
	NodeBRJD<K, T> nodo = (NodeBRJD<K, T>)(getRaiz()!=null?getRaiz().searchNode(key):null);
		if(nodo!=null){
		int size=size();
				if(nodo.getRight()!=null&&nodo.getLeft()!=null){
					NodeBBJD<K,T> min=nodo.getLeft().getMax();
					nodo.setElement(min.getElement());
					nodo.setKey(min.getKey());
					nodo=(NodeBRJD<K, T>) min;
				}
				
				NodeBRJD<K,T> tmp=(NodeBRJD<K,T>)(nodo.getLeft()!=null?nodo.getLeft():nodo.getRight());

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
					if(nodo.getColor()==NodeBRJD.COLOR_BLACK){
						fixAfterDeletion((NodeBRJD<K, T>) tmp);
					}
				}
				else{
					if(nodo.getColor()==NodeBRJD.COLOR_BLACK){
						fixAfterDeletion(nodo);

					}
					if(nodo.getRelativePosition()==NodeBBJD.LEFT){
						nodo.getSupe().setLeft(null);
					}else if(nodo.getRelativePosition()==NodeBBJD.RIGHT){
						nodo.getSupe().setRight(null);
					}else{
						setRaiz(null);
					}
				}
				if(getRaiz()!=null){
					getRaiz().setSize(size-1);

				}
			}
		
	}
public boolean verificar() {
		boolean ret = false;
		if (getRaiz() != null) {

		} else {
			ret = true;
		}
		return ret;
	}
@Override
	public void fixAfterDeletion(NodeBBJD<K, T> n) {
	NodeBRJD<K, T> x=(NodeBRJD<K, T>)n;
		while (x != getRaiz() && x.getColor() == NodeBRJD.COLOR_BLACK) {
			if (x.getRelativePosition() == NodeBRJD.LEFT) {
				NodeBRJD<K, T> sib = (NodeBRJD<K, T>) x.getSupe().getRight();

				if (sib.getColor() == NodeBRJD.COLOR_RED) {
					sib.setColor(NodeBRJD.COLOR_BLACK);
					((NodeBRJD<K, T>) x.getSupe()).setColor(NodeBRJD.COLOR_RED);

					rotateLeft((NodeBRJD<K, T>) x.getSupe());
					sib = (NodeBRJD<K, T>) x.getSupe().getRight();
				}
				boolean nul=sib.getRight()!=null&&sib.getLeft()!=null;
				boolean entro=false;

				if(!nul&&sib.getRight()==null&&sib.getLeft()==null){
					sib.setColor(NodeBRJD.COLOR_RED);
					x = (NodeBRJD<K, T>) x.getSupe();
					entro=true;
				}else if(!nul){
					NodeBRJD<K, T> tmp=(NodeBRJD<K, T>)(sib.getLeft()==null?sib.getRight():sib.getLeft());
					if(tmp.getColor()==NodeBRJD.COLOR_BLACK){
						sib.setColor(NodeBRJD.COLOR_RED);
						x = (NodeBRJD<K, T>) x.getSupe();
						entro=true;

					}
					
					
				}
				if (nul&&((NodeBRJD<K, T>) sib.getLeft()).getColor() == NodeBRJD.COLOR_BLACK
						&& ((NodeBRJD<K, T>) sib.getRight()).getColor() == NodeBRJD.COLOR_BLACK) {
					sib.setColor(NodeBRJD.COLOR_RED);
					x = (NodeBRJD<K, T>) x.getSupe();
					entro=true;

				} else if(!entro) {
					if(sib.getRight()==null){
						((NodeBRJD<K, T>) sib.getLeft()).setColor(NodeBRJD.COLOR_BLACK);
						sib.setColor(NodeBRJD.COLOR_RED);
						rotateRight(sib);
						sib = (NodeBRJD<K, T>) x.getSupe().getRight();
					}
					else if (((NodeBRJD<K, T>) sib.getRight()).getColor() == NodeBRJD.COLOR_BLACK) {
						sib.setColor(NodeBRJD.COLOR_RED);
						rotateRight(sib);
						sib = (NodeBRJD<K, T>) x.getSupe().getRight();
					}
					sib.setColor(((NodeBRJD<K, T>) x.getSupe()).getColor());
					((NodeBRJD<K, T>) x.getSupe()).setColor(NodeBRJD.COLOR_BLACK);
					((NodeBRJD<K, T>) sib.getRight()).setColor(NodeBRJD.COLOR_BLACK);
					rotateLeft((NodeBRJD<K, T>) x.getSupe());
					x = (NodeBRJD<K, T>) getRaiz();
				}
			} else {
				NodeBRJD<K, T> sib = (NodeBRJD<K, T>) x.getSupe().getLeft();

				if (sib.getColor() == NodeBRJD.COLOR_RED) {
					sib.setColor(NodeBRJD.COLOR_BLACK);
					((NodeBRJD<K, T>) x.getSupe()).setColor(NodeBRJD.COLOR_RED);
					rotateRight((NodeBRJD<K, T>) x.getSupe());
					sib = (NodeBRJD<K, T>) x.getSupe().getLeft();
				}
				boolean nul=sib.getRight()!=null&&sib.getLeft()!=null;
				boolean entro=false;
				if(!nul&&sib.getRight()==null&&sib.getLeft()==null){
					sib.setColor(NodeBRJD.COLOR_RED);
					x = (NodeBRJD<K, T>) x.getSupe();
					entro=true;
				}else if(!nul){
					NodeBRJD<K, T> tmp=(NodeBRJD<K, T>)(sib.getLeft()==null?sib.getRight():sib.getLeft());
					if(tmp.getColor()==NodeBRJD.COLOR_BLACK){
						sib.setColor(NodeBRJD.COLOR_RED);
						x = (NodeBRJD<K, T>) x.getSupe();
						entro=true;

					}

				}
				if (nul&&((NodeBRJD<K, T>) sib.getLeft()).getColor() == NodeBRJD.COLOR_BLACK
						&& ((NodeBRJD<K, T>) sib.getRight()).getColor() == NodeBRJD.COLOR_BLACK) {
					sib.setColor(NodeBRJD.COLOR_RED);
					x = (NodeBRJD<K, T>) x.getSupe();
					entro=true;

				} else if(!entro){
					if(sib.getLeft()==null){
						
						((NodeBRJD<K, T>) sib.getRight()).setColor(NodeBRJD.COLOR_BLACK);
						sib.setColor(NodeBRJD.COLOR_RED);
						rotateLeft(sib);
						sib = (NodeBRJD<K, T>) x.getSupe().getLeft();
						
					}
					else if (((NodeBRJD<K, T>) sib.getLeft()).getColor() == NodeBRJD.COLOR_BLACK) {
						sib.setColor(NodeBRJD.COLOR_RED);
						rotateLeft(sib);
						sib = (NodeBRJD<K, T>) x.getSupe().getLeft();
					}
					sib.setColor(((NodeBRJD<K, T>) x.getSupe()).getColor());
					
					((NodeBRJD<K, T>) x.getSupe()).setColor(NodeBRJD.COLOR_BLACK);
					((NodeBRJD<K, T>) sib.getLeft()).setColor(NodeBRJD.COLOR_BLACK);
					rotateRight((NodeBRJD<K, T>) x.getSupe());
					x = (NodeBRJD<K, T>) getRaiz();
				}
			}
		}

		x.setColor(NodeBRJD.COLOR_BLACK);
	}


	
	
	
	
	
	
	
	
}