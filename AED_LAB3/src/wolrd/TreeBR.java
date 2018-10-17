package wolrd;

public class TreeBR {
	
	
	
	
	
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
