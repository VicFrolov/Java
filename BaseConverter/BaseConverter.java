public class BaseConverter {
	// private long decimalRepresentation = 0;
	// private int fromBase = 0;
	// private int toBase = 0;
	// private byte[] numberToConvert;
	
	// public BaseConverter(byte b, int i, int j) {
	// 	b = this.numberToConvert;
	// 	i = this.fromBase;
	// 	j = this.toBase;
	// }

	public long conversionToDecimal(byte[] numberToConvert, int base) {
		long decimalValueSoFar = 0;
		
		for (int i = 0; i < numberToConvert.length; i++) {
			decimalValueSoFar += numberToConvert[i] * Math.pow(base, i);
		}
		return decimalValueSoFar;
	}



	public static void main(String[] args) {

	}

}