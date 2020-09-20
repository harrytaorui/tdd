import org.junit.Test;
import static org.junit.Assert.*;

public class MommifierTest {

	@Test
	public void Test_Null_String() {
		String testString = null;
		Momifier momifier = new Momifier();
		assertNull(momifier.momify(testString));
	}

	@Test
	public void Test_String_With_No_Continuous_Vowels() {
		String testString = "apple";
		Momifier momifier = new Momifier();
		assertEquals(momifier.momify(testString),testString);
	}

	@Test
	public void Test_String_With_Continuous_Vowels_Less_Than_30_Percent() {
		String testString = "greedyflys";
		Momifier momifier = new Momifier();
		assertEquals(momifier.momify(testString),testString);
	}

	@Test
	public void Test_String_With_Continuous_Vowels_More_Than_30_Percent() {
		String testString = "booklist";
		Momifier momifier = new Momifier();
		assertEquals(momifier.momify(testString),"bomommyoklist");
	}


}
