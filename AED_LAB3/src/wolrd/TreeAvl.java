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
	
	@Override
	public void fixAfterInsertion(NodeBBJD<K, T> n) {
		
		((NodeAvlJD<K,T>) getRaiz()).asignFactors();

		NodeAvlJD<K, T> x=(NodeAvlJD<K, T>)n.getSupe();
		NodeAvlJD<K, T> p=x!=null?(NodeAvlJD<K, T>) x.getSupe():null;
		if(p!=null){
			
			if(x.getRelativePosition()==NodeBBJD.LEFT){
				if(n.getRelativePosition()==NodeBBJD.RIGHT&&x.getLeft()==null){
					rotateLeft(x);
					x.setFactor(NodeAvlJD.BALANCED);
					x=(NodeAvlJD<K, T>) x.getSupe();
					x.setFactor(NodeAvlJD.WEIGHT_LEFT);
				}
					if(p.getFactor()>NodeAvlJD.WEIGHT_LEFT){
						rotateRight(p);
						fixAfterInsertion(p);
					}else{
						fixAfterInsertion(x);
					}	
			}else{
				if(n.getRelativePosition()==NodeBBJD.LEFT&&x.getRight()==null){
					rotateRight(x);
					x.setFactor(NodeAvlJD.BALANCED);
					x=(NodeAvlJD<K, T>) x.getSupe();
					x.setFactor(NodeAvlJD.WEIGHT_RIGHT);
				}
					if(p.getFactor()<NodeAvl.WEIGHT_RIGHT){
						rotateLeft(p);

						fixAfterInsertion(p);
					}else{
						fixAfterInsertion(x);

					}		
				
			}

		}
		
	}	
	
	@Override
	public void fixAfterDeletion(NodeBBJD<K, T> n) {
		
		NodeAvlJD<K, T> x=(NodeAvlJD<K, T>)n;
		if(x!=null){
			((NodeAvlJD<K,T>) getRaiz()).asignFactors();

			if(x.getFactor()<NodeAvlJD.WEIGHT_RIGHT){
				if(x.getRight().getLeft()!=null){
					rotateRight(x.getRight());


				}
				rotateLeft(x);

			}else if(x.getFactor()>NodeAvlJD.WEIGHT_LEFT){
				if(x.getLeft().getRight()!=null){
					rotateLeft(x.getLeft());


				}
				rotateRight(x);
			}
			fixAfterDeletion(x.getSupe());


		}

		
	}

	
	
}
