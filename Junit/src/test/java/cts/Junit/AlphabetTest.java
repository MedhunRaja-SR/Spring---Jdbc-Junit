package cts.Junit;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;

public class AlphabetTest {

	Alphabet alpha = new Alphabet();
	
	@Before
	public void before() {
		System.out.println("Before Method");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	
	@After
	public void After() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("After Class");
	}
	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals("CD", alpha.truncateAInFirst2Positions("AACD"));
		System.out.println("AACD Done");
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		assertFalse(alpha.areFirstAndLastTwoCharactersTheSame("ABCD"));
		System.out.println("ABCD Done");
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_assertTrue() {
		assertTrue(alpha.areFirstAndLastTwoCharactersTheSame("ABAB"));
		System.out.println("ABAB Done");
	}
	
}
