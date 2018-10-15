package wolrd;

import interfaces.*;

public class GenericNode<T> implements InterfaceGenericNode<T> {
	
	private GenericNode<T> nodeLeft;
	private GenericNode<T> nodeRight;
	private T object;
	
	public GenericNode(T pObject) {
		// TODO Auto-generated constructor stub
		object = pObject;
		nodeLeft = null;
		nodeRight = null;
	}

	@Override
	public GenericNode<T> giveRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericNode<T> giveLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeRigth(GenericNode<T> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeLeft(GenericNode<T> node) {
		// TODO Auto-generated method stub
		
	}

}
