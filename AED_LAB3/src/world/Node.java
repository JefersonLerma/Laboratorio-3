package wolrd;

import java.util.ArrayList;
import java.util.Collection;

public class Node<T> {

	private Node<T> parent;
	private ArrayList<Node<T>> sons;
	private T element;
	private int level;

	public Node(T element, Node<T> tParent) {
		this.element = element;
		this.parent = tParent;
		level=1;
	}
	public Node(T element, Node<T> tParent,int level) {
		this.element = element;
		this.parent = tParent;
		this.level=level+1;
	}

	public T getElement() {
		return element;
	}

	public Node<T> getPadre() {
		return parent;
	}

	@SuppressWarnings("unchecked")
	public void reccorerPorNivel(Collection<T> colection,int level){
		if(level==1){
			colection.add(element);
		}else if(level==2){
			colection=(Collection<T>) sons;
		}else if(level-2==this.level){
			for (int i = 0; i < sons.size(); i++) {
				colection.addAll((Collection<? extends T>) sons.get(i).sons);
			}
		}else{
			for (int i = 0; i < sons.size(); i++) {
				sons.get(i).reccorerPorNivel(colection, level);
			}
		}
		
	}
	public Node<T> getElement(T element) {
		if (element.equals(element)) {
			return this;
		} else {
			Node<T> ter = null;
			if (sons != null) {
				for (int i = 0; i < sons.size() && ter == null; i++) {
					ter = sons.get(i).getElement(element);
				}
			}

			return ter;
		}

	}

	public void add(T element) {
		if (sons == null) {
			sons = new ArrayList<>();
		}
		sons.add(new Node<T>(element, this,level));
	}

	public Node<T> containsElement(T element) {
		if (element.equals(element)) {
			return this;
		} else {
			Node<T> ter = null;
			if (sons != null) {
				for (int i = 0; i < sons.size() && ter==null; i++) {
					ter = sons.get(i).containsElement(element);
				}
			}

			return ter;
		}

	}

	public void preOrden(Collection<T> colection) {
		colection.add(element);
		if (sons != null) {
			for (int i = 0; i < sons.size(); i++) {
				sons.get(i).preOrden(colection);
			}
		}

	}

	public int size() {
		int exit = 1;
		if (sons != null) {
			for (int i = 0; i < sons.size(); i++) {
				exit += sons.get(i).size();
			}
		}

		return exit;
	}

	public int height() {
		int exit = 1;
		if (sons != null) {
			int max = 0;
			for (int i = 0; i < sons.size(); i++) {
				int height = sons.get(i).height();
				max = Math.max(max, height);
			}
			exit += max;
		}
		return exit;
	}
	
}
