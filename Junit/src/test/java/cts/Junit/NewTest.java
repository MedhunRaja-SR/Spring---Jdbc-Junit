package cts.Junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class NewTest {

	@Test
	public void testArraySort() {
		int[] numbers = { 5, 2, 3, 1, 4 };
		int[] excepted = { 1, 2, 3, 4, 5 };
		Arrays.sort(numbers);
		assertArrayEquals(excepted, numbers);
	}
	
	@Test(expected=NullPointerException.class)
	public void testArrayException(){
		int[] numbers=null;
		Arrays.sort(numbers);
	}
	
	@Test(timeout=1000)
	public void testSort_Performance(){
		int[] numbers= {3,7,2};
		for(int i=1;i<100000;i++) {
			numbers[0]=i;
			Arrays.sort(numbers);
		}
	}
}
