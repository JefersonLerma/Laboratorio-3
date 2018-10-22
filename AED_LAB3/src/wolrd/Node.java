package wolrd;

import java.util.ArrayList;
import java.util.Collection;

public class Node<T> {

	private Node<T> parent;
	private ArrayList<Node<T>> sons;
	private T element;
	private int level;

	public Node(T element, Node<T> padre) {
		this.element = element;
		this.parent = padre;
		level=1;
	}
	public Node(T element, Node<T> padre,int level) {
		this.element = element;
		this.parent = padre;
		this.level=level+1;
	}

	public T getElement() {
		return element;
	}

	public Node<T> getPadre() {
		return parent;
	}

	@SuppressWarnings("unchecked")
	public void reccorerPorNivel(Collection<T> coleccion,int level){
		if(level==1){
			coleccion.add(element);
		}else if(level==2){
			coleccion=(Collection<T>) sons;
		}else if(level-2==this.level){
			for (int i = 0; i < sons.size(); i++) {
				coleccion.addAll((Collection<? extends T>) sons.get(i).sons);
			}
		}else{
			for (int i = 0; i < sons.size(); i++) {
				sons.get(i).reccorerPorNivel(coleccion, level);
			}
		}
		
	}
	public Node<T> getElement(T elemento) {
		if (element.equals(elemento)) {
			return this;
		} else {
			Node<T> ter = null;
			if (sons != null) {
				for (int i = 0; i < sons.size() && ter == null; i++) {
					ter = sons.get(i).getElement(elemento);
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

	public Node<T> containsElement(T elemento) {
		if (element.equals(elemento)) {
			return this;
		} else {
			Node<T> ter = null;
			if (sons != null) {
				for (int i = 0; i < sons.size() && ter==null; i++) {
					ter = sons.get(i).containsElement(elemento);
				}
			}

			return ter;
		}

	}

	public void preOrden(Collection<T> coleccion) {
		coleccion.add(element);
		if (sons != null) {
			for (int i = 0; i < sons.size(); i++) {
				sons.get(i).preOrden(coleccion);
			}
		}

	}

	public int size() {
		int retorno = 1;
		if (sons != null) {
			for (int i = 0; i < sons.size(); i++) {
				retorno += sons.get(i).size();
			}
		}

		return retorno;
	}

	public int height() {
		int retorno = 1;
		if (sons != null) {
			int max = 0;
			for (int i = 0; i < sons.size(); i++) {
				int altura = sons.get(i).height();
				max = Math.max(max, altura);
			}
			retorno += max;
		}
		return retorno;
	}
	
}
