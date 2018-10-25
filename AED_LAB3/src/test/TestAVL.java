	package test;
import java.util.ArrayList;
import world.*;
import java.util.Arrays;
import interfaces.*;
import junit.framework.*;

public class TestAVL extends TestCase {
	
	TreeAvl<Integer, Integer> avl;
	int[] are = { 6,4,12,2,5,10,14,13,15,20,50,100,60,8,9,11,1,3,7,16,17,18,19,21,22,23,24,25,26,27};

	private void stage1(){
		avl=new TreeAvl<>();
		for (int i = 0; i < are.length; i++) {

			avl.add(are[i], are[i]); 
		}
	}
	
	public void testSort(){
		stage1();
		int al=(int) (Math.log(are.length)/Math.log(2))+1;
		int ala=avl.height();
		assertTrue(al>=ala);
		assertTrue(are.length==avl.size());
		ArrayList<Integer> lis=new ArrayList<>();
		Arrays.sort(are);
		avl.inOrder(lis);
		for (int i = 0; i < are.length; i++) {
			if(lis.get(i)!=are[i]){
				fail();
			}
		}
	}
	public void testDelete(){
		stage1();
		for (int i = 0; i < are.length; i++) {
			avl.delete(are[i]);
			int al=(int) (Math.log(are.length-(i))/Math.log(2))+1;
			int ala=avl.height();

			assertTrue(al>=ala);
			assertTrue(are.length-(1+i)==avl.size());
		}
		
	}
		public void testSearch(){
				stage1();
				assertTrue(avl.search(23)==23);
			}
		
		
		
}

