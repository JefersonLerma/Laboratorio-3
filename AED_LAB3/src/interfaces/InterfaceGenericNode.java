package interfaces;
import wolrd.*;

public interface InterfaceGenericNode<T> {
	
	public GenericNode<T> giveRight();
	public GenericNode<T> giveLeft();
	public void changeRigth(GenericNode<T> node);
	public void changeLeft(GenericNode<T> node);
	
}
