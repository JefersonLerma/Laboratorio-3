package test;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;
import world.TreeAvl;
import world.TreeBR;

public class TestABR extends TestCase {

	TreeBR<Integer, Integer> abr;
	int[] are = { 6,4,12,2,5,10,14,13,15,20,50,100,60,8,9,11,1,3,7,16,17,18,19,21,22,23,24,25,26,27};

	private void stage1(){
		abr=new TreeBR<>();
		for (int i = 0; i < are.length; i++) {

			abr.add(are[i], are[i]); 
		}
	}
	
	public void testSort(){
		stage1();
		int al=(int) (Math.log(are.length)/Math.log(2))+1;
		int ala=abr.height();
		assertTrue(al>=ala);
		assertTrue(are.length==abr.size());
		ArrayList<Integer> lis=new ArrayList<>();
		Arrays.sort(are);
		abr.inOrder(lis);
		for (int i = 0; i < are.length; i++) {
			if(lis.get(i)!=are[i]){
				fail();
			}
		}
	}
	public void testDelete(){
		stage1();
		for (int i = 0; i < are.length; i++) {
			abr.delete(are[i]);
			int al=(int) (Math.log(are.length-(i))/Math.log(2))+1;
			int ala=abr.height();

			assertTrue(al>=ala);
			assertTrue(are.length-(1+i)==abr.size());
		}
		
	}
		public void testSearch(){
				stage1();
				assertTrue(abr.search(23)==23);
			}
		
	
}
