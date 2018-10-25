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

	public static void main(String[] args) {
		TreeBR<Integer, Integer> abr = new TreeBR<>();
		int[] are = { 6,4,12,2,5,10,14,1,3,9,11,13,15,20,50,100,60};
		for (int i = 0; i < are.length; i++) {
		
			abr.add(are[i], are[i]);
		}
		System.out.println(abr.size());
		ArrayList<NodeBBJD<Integer, Integer>> lis = new ArrayList<>();
		abr.inOrderN(lis);
		for (int i = 0; i < abr.size(); i++) {
			System.out.println(lis.get(i).getElement()+" "+lis.get(i).getRelativePosition()+" "+(lis.get(i).getSupe()!=null?lis.get(i).getSupe().getKey():"null")+" "+((NodeBRJD<Integer, Integer>) lis.get(i)).getColor());
		}
		abr.delete(20);
		abr.delete(6);
		abr.delete(14);
		abr.delete(13);
		abr.delete(3);
		abr.delete(1);
		abr.delete(4);
		abr.delete(2);
		abr.delete(12);
		abr.delete(50);
		abr.delete(15);
		abr.delete(100);
		abr.delete(60);
		abr.delete(9);
		abr.delete(5);
		abr.delete(10);
		abr.delete(11);


		abr.add(400, 400);






		System.out.println("/////");
		System.out.println("/////");

		System.out.println("/////");
		System.out.println("/////");

		lis = new ArrayList<>();
		abr.inOrderN(lis);
		System.out.println(abr.size());

		for (int i = 0; i < abr.size(); i++) {
			System.out.println(lis.get(i).getElement()+" "+lis.get(i).getRelativePosition()+" "+(lis.get(i).getSupe()!=null?lis.get(i).getSupe().getKey():"null")+" "+((NodeBRJD<Integer, Integer>) lis.get(i)).getColor());
		}
	}


	
	
	
	
	
	
	
	
//	/*********************************************************
//	* Archivo:     arbolRojiNegro.java
//	* Lenguaje:    Java
//	* Estudiantes: Qaser Awan Ruiz
//	* Institución: Instituto Tecnológico de Costa Rica
//	* Notas:
//	*				-Restricciones:
//	*					No me hago responsable del uso que le den
//	*					a los algoritmos.
//	*
//	*        		-Observaciones:
//	*		  			El prototipo del trabajo fue brindado
//	*					en el curso de estructuras de datos.
//	*********************************************************/
//	import java.io.*;
//
//	//definicion del arbol roji-negro
//	class arbolRojiNegro{
//		String outm;
//		String rota;
//		public nodoRojiNegro raiz;
//		public static final int rojo=0;
//		public static final int negro=1;
//		
//		//crea el arbol
//		public arbolRojiNegro(){
//		}
//		
//		//crea el arbol con la llave
//		public arbolRojiNegro(int codcu,int codca,String nom,int req){
//			raiz = new nodoRojiNegro(codcu,codca,nom,req);
//			raiz.color = negro;
//		}
//		
//		//Inserta una llave en el arbol roji-negro
//		public nodoRojiNegro Insertar(int codcu,int codca,String nom,int req, nodoRojiNegro t,String out){
//			raiz=t;
//			try{
//				outm=out;           
//				if (estaVacio()){
//			  		raiz = new nodoRojiNegro(codcu,codca,nom,req);
//			  		raiz.color = negro;
//			  		FileWriter fw = new FileWriter (outm+".txt", true);
//					BufferedWriter bw = new BufferedWriter (fw);
//					PrintWriter salida = new PrintWriter (bw);
//					salida.println("Elemento: " + codcu);
//					rota=rota+"Elemento: " +codcu+"\n";
//					salida.close();
//				}
//				else
//			  		raiz = insertaraux(codcu,codca,nom,req,t);
//			}
//			catch(Exception e){
//			}
//			return raiz;
//		}
//		
//		//Ayuda al metodo de insertar
//		public nodoRojiNegro insertaraux(int codcu,int codca,String nom,int req, nodoRojiNegro t) {
//			try{
//				//Insercion normal, y le asigna el padre en otra referencia
//				nodoRojiNegro y=null;
//				nodoRojiNegro x = t;
//				while (x != null){
//			  	y = x;
//			  	if (codcu < x.Codcur)
//			    	x = x.hIzq;
//			  	else
//			    	x = x.hDer;
//				}
//				nodoRojiNegro z = new nodoRojiNegro(codcu,codca,nom,req,y);
//				if (codcu < y.Codcur)
//			 		y.hIzq = z;
//				else
//			  		y.hDer = z;
//			  	FileWriter fw = new FileWriter (outm+".txt", true);
//				BufferedWriter bw = new BufferedWriter (fw);
//				PrintWriter salida = new PrintWriter (bw);
//				salida.println("Elemento: " + z.Codcur);
//				salida.close();
//				rota=rota+"Elemento: " +z.Codcur+"\n";
//				//inserta en el arbol para arreglarlo
//				t = insertarArreglado(t, z);
//			}
//			catch(Exception e){
//			}
//			return t;
//		}
//		
//	  	//Recibe la raiz con el elemento metido y el elemento
//	  	//para arreglarlo 
//		public nodoRojiNegro insertarArreglado(nodoRojiNegro t, nodoRojiNegro z){
//			try{
//				FileWriter fw = new FileWriter (outm+".txt", true);
//				BufferedWriter bw = new BufferedWriter (fw);
//				PrintWriter salida = new PrintWriter (bw);
//				//si el padre z es rojo
//				while ((z.padre != null) && (z.padre.padre != null) && (z.padre.color == rojo)){
//				  //si el padre es hijo izquierdo de abuelo
//					if (z.padre == z.padre.padre.hIzq){
//						nodoRojiNegro y = z.padre.padre.hDer;
//				        //si el tio de z tambien es rojo
//				        if (y!=null && y.color == rojo){
//							//cambia al tio de z negro, al padre de z negro
//							salida.println("Cambio de color");
//							rota=rota+"Cambio de color\n";
//							z.padre.color = negro;
//							y.color = negro;
//							z.padre.padre.color = rojo;
//							z = z.padre.padre;
//				        }
//				        else {
//				        	//Si z es hijo derecho
//							if (z.padre.hDer!=null && z == z.padre.hDer) {
//								salida.println("Rotacion Izquierda");
//								rota=rota+"Rotacion Izquierda\n";
//								z = z.padre;
//								t = rotarIzq(t, z);
//							}
//							else{
//								salida.println("Rotacion Derecha");
//								rota=rota+"Rotacion Derecha\n";
//								//Caso 3
//								z.padre.color = negro;
//								z.padre.padre.color = rojo;
//								t = rotarDer(t, z.padre.padre);
//							}
//				        }
//				  	}
//			  	//Si el padre de z es hijo derecho
//					else{
//						nodoRojiNegro y = z.padre.padre.hIzq;
//						//si el tio de z es rojo
//						if (y!=null && y.color == rojo) {
//						  // cambiar colores
//						  salida.println("Cambio de color");
//						  rota=rota+"Cambio de color\n";
//						  z.padre.color = negro;
//						  y.color = negro;
//						  z.padre.padre.color = rojo;
//						  z = z.padre.padre;
//						}
//						else {
//						  //si z es hijo izquierdo
//						  if (z == z.padre.hIzq) {
//						  	salida.println("Rotacion Derecha");
//						  	rota=rota+"Rotacion Derecha\n";
//						    z = z.padre;
//						    t = rotarDer(t, z);
//						  }
//						  else{
//						  	salida.println("Rotacion Izquierda");
//						  	rota=rota+"Rotacion Izquierda\n";
//						  	//Caso 3
//						  	z.padre.color = negro;
//						  	z.padre.padre.color = rojo;
//						  	t = rotarIzq(t, z.padre.padre);
//						  }
//						} 
//					}
//				}
//				salida.close();
//			}
//			catch (Exception e){
//				
//			}
//			t.color = negro;
//			return t;
//		}
//		
//		//rotacion izquierda
//		public nodoRojiNegro rotarIzq(nodoRojiNegro t, nodoRojiNegro x) {
//			nodoRojiNegro y = x.hDer;
//			x.hDer = y.hIzq;
//			if (y.hIzq != null)
//			  y.hIzq.padre = x;
//			y.padre = x.padre;
//			if (x.padre == null)
//			  t = y;
//			else if (x == x.padre.hIzq)
//			  x.padre.hIzq = y;
//			else
//			  x.padre.hDer = y;
//			y.hIzq = x;
//			x.padre = y;
//			return t;
//		}
//		
//		//rotacion derecha
//		public nodoRojiNegro rotarDer(nodoRojiNegro t, nodoRojiNegro x) {
//			nodoRojiNegro y = x.hIzq;
//			x.hIzq = y.hDer;
//			if (y.hDer != null)
//			  y.hDer.padre = x;
//			y.padre = x.padre;
//			if (x.padre == null)
//			  t = y;
//			else if (x == x.padre.hIzq)
//			  x.padre.hIzq = y;
//			else
//			  x.padre.hDer = y;
//			y.hDer = x;
//			x.padre = y;
//			return t;
//		}
//		
//		//busca un elemento
//		public boolean Miembro(int x, nodoRojiNegro r){
//			raiz=r;
//			boolean si=false;
//			nodoRojiNegro temp = raiz;
//			while (temp != null && si==false) {
//			  if(x==temp.Codcur){
//			  	si=true;
//			  }
//			  else{
//			  	if (x < temp.Codcur)
//			    	temp = temp.hIzq;
//			    else
//			    	if(x > temp.Codcur)
//			    		temp = temp.hDer;
//			  }
//			}
//			return si;
//		} 
//		
//		//retorna true si el arbol esta vacio
//		public boolean estaVacio(){
//			return (raiz == null);
//		}
//		
//		//Imprime en inorden
//		public void Imprimir(nodoRojiNegro t){
//			if(estaVacio())
//			  System.out.println("Arbol Vacio");
//			else
//			  imprimirArbol(t);
//		}
//		
//		//auxiliar
//		public void imprimirArbol(nodoRojiNegro t){
//			if(t != null){
//		      imprimirArbol(t.hIzq);
//		      if(t.color==1)
//		      	System.out.println(t.Codcur + " negro");
//		      else
//		      	System.out.println(t.Codcur + " rojo");
//		      imprimirArbol(t.hDer);
//			}
//	    }
//	}
//
//	//Nodo del arbol rojinegro
//	class nodoRojiNegro{
//		int Codcur;    	// la llave del arbol
//		int Codcar;
//		String Nombre;
//		int Requisito;
//		nodoRojiNegro padre;    // el padre del nodo
//		nodoRojiNegro hIzq;      // Hijo izquierdo
//		nodoRojiNegro hDer;      // Hijo derecho
//		int color;      		// Color
//		// Constructores
//		nodoRojiNegro(){
//			padre=hIzq=hDer=null;
//			color=0;
//		}
//		nodoRojiNegro (int codcu,int codca,String nom,int req){
//			Codcur= codcu;
//			Codcar= codca;
//			Nombre= nom;
//			Requisito= req;
//			padre= hIzq = hDer = null;
//			color= 0;
//		}
//		public nodoRojiNegro(int codcu,int codca,String nom,int req, nodoRojiNegro pa){
//			Codcur= codcu;
//			Codcar= codca;
//			Nombre= nom;
//			Requisito= req;
//			hIzq= hDer=null;
//			padre= pa;
//			color= 0;
//		}
//	}
//
//	class ArbolRojiNegroA{
//		public static void main(String args[]){
//			arbolRojiNegro nuevo=new arbolRojiNegro();
//			nuevo.Insertar(1,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(2,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(20,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(8,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(12,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(4,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(21,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(18,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(7,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(52,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(63,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.Insertar(17,1,"pr",1,nuevo.raiz,"pr");
//			nuevo.imprimirArbol(nuevo.raiz);
//			
//		}
//	
//}

}
