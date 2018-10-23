package wolrd;
import interfaces.*;


public class NodeAvl<K extends Comparable<K>,T> extends NodeBB<K, T> implements NodeAvlJD<K, T>{
	
	private int factor;
	public NodeAvl( K key,T element) {
		super(key, element);
		setFactor(BALANCED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getFactor() {
		// TODO Auto-generated method stub
		return factor;

	}
	
	@Override
	public void setFactor(int fa) {
		// TODO Auto-generated method stub
		factor=fa;
	}
	
	
	public void asignFactors(){
		int aI=0;
		int aD=0;
		if(getRight()!=null){
			aD=getRight().height();
			((NodeAvlJD<K, T>) getRight()).asignFactors();
			
		}
		if(getLeft()!=null){
			aI=getLeft().height();
			((NodeAvlJD<K, T>) getLeft()).asignFactors();

		}
		factor=aI-aD;
	}

	
}
