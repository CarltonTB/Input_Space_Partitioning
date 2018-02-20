package roman;

import java.util.regex.Pattern;

public class RomanConverter {

	private enum RomanSymbol {

		M(1000), 
		CM(900), 
		D(500), 
		CD(400), 
		C(100), 
		XC(90), 
		L(50), 
		XL(40), 
		X(10), 
		IX(9), 
		V(5), 
		IV(4), 
		I(1);

		private int value;

		private RomanSymbol(int value) {
			this.value = value;
		}
		
		public int value() {
			return this.value;
		}
		
	}

	private static final Pattern romanNumeralPattern = Pattern
			.compile("^M?M?M?(CM|CD|D?C?C?C?)(XC|XL|L?X?X?X?)(IX|IV|V?I?I?I?)$");

	public String toRoman(int n) {

		if (n <= 0 || n >= 4000) {
			throw new IllegalArgumentException(
					"number out of range (must be 1..3999)");
		}

		StringBuilder result = new StringBuilder();

		for(RomanSymbol symbol : RomanSymbol.values()) {
			while (n >= symbol.value()) {
				result.append(symbol.name());
				n -= symbol.value();
			}
		}

		return result.toString();
	}

	public int fromRoman(String s) {
				
		if (!romanNumeralPattern.matcher(s).matches()) {
			throw new IllegalArgumentException("Invalid Roman numeral: " + s);
		}

		int result = 0;
		int index = 0;

		for(RomanSymbol symbol : RomanSymbol.values()) {
			while (s.startsWith(symbol.name(), index)) {
				result += symbol.value();
				index += symbol.name().length();
			}
		}

		return result;
	}
}
