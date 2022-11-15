package cts.Junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterAlphabetTest {

	Alphabet alpha = new Alphabet();
	
	private String input;
	private String excepted;
	
	public ParameterAlphabetTest(String input, String excepted) {
		super();
		this.input = input;
		this.excepted = excepted;
	}
	@Parameters
	public static Collection<String[]> testConditions() {
		String array[][]= {{"AACD","CD"},{"ACD","CD"}};
		return Arrays.asList(array);
	}
	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals(excepted, alpha.truncateAInFirst2Positions(input));
		
	}

}
