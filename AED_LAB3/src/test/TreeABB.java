package test;

import java.util.*;

import world.*;
import junit.framework.*;
import interfaces.*;
public class TreeABB extends TestCase {

	private TreeBB<Integer, Integer> testTree;

	private int[] arreglo = { 4,2,8,7,5,9,6,10,3,1 };
	private int height=4;

	private void scene1() {
		testTree = new TreeBB<>();

		for (int i = 0; i < arreglo.length; i++) {
			testTree.add(arreglo[i], arreglo[i]); //

		}
	}

	public void testHeight() {
		scene1();
		int al1 = testTree.height();
		assertTrue(al1==height);
	}
	public void testSize(){
		scene1();
		int si=testTree.size();
		int le=arreglo.length;
		assertTrue(si==le);

	}
	public void testDelete(){
		scene1();
		assertTrue(testTree.exist(6));
		testTree.delete(6);
		assertFalse(testTree.exist(6));
		assertTrue(testTree.height()==height-1);

	}
	public void testSearch(){
		scene1();
		assertTrue(testTree.search(10)==10);
	}
	public void testInOrder(){
		scene1();
		Arrays.sort(arreglo);
		ArrayList<Integer> lis=new ArrayList<>();
		testTree.inOrder(lis);
		for (int i = 0; i < arreglo.length; i++) {
			assertTrue(arreglo[i]==lis.get(i));
			
		}
	}

}
