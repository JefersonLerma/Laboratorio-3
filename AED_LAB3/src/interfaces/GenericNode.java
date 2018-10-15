package interfaces;

public interface GenericNode<T> {
	
	public GenericNode<T> giveRight();
	public GenericNode<T> giveLeft();
	public void changeRigth(GenericNode<T> node);
	public void changeLeft(GenericNode<T> node);
	
}
