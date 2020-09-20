import org.junit.Test;
import static org.junit.Assert.*;

public class MommifierTest {

	@Test
	public void Test_Null_String() {
		String testString = null;
		Momifier momifier = new Momifier();
		assertNull(momifier.momify(testString));
	}

}
