import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Momifier {

	private static Set<Character> vowelSet;
	private static float MOMIFYPERCENT = 0.3f;

	public Momifier() {
		vowelSet = Stream.of('a', 'e', 'o', 'i', 'u').collect(Collectors.toSet());
	}


	public String momify(String testString) {
		if (testString == null) {
			return null;
		}
		if (!hasEnoughVowels(testString)) {
			return testString;
		}
		return insertMommyInContinuousVowels(testString);
	}

	private String insertMommyInContinuousVowels(String testString) {
		int firstContinuousVowelIndex = findFirstContinuousVowels(testString);
		StringBuffer stringBuffer = new StringBuffer(testString);
		while (firstContinuousVowelIndex != -1) {
			stringBuffer.insert(firstContinuousVowelIndex + 1, "mommy");
			firstContinuousVowelIndex = findFirstContinuousVowels(stringBuffer.toString());
		}
		return stringBuffer.toString();
	}

	private boolean hasEnoughVowels(String testString) {
		long count = testString.chars().mapToObj(i -> (char) i)
				.filter(e -> vowelSet.contains(e)).count();
		return (float) count / (float) testString.length() >= MOMIFYPERCENT;
	}

	private int findFirstContinuousVowels(String testString) {
		char[] testArr = testString.toCharArray();
		char firstVowel = ' ';
		for (int i = 0; i < testArr.length; i++) {
			char currentChar = testArr[i];
			if (isVowel(currentChar)) {
				if (currentChar == firstVowel) {
					return i - 1;
				}
			}
			firstVowel = currentChar;
		}
		return -1;
	}

	private boolean isVowel(char c) {
		return vowelSet.contains(c);
	}
}
