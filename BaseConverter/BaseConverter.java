public class BaseConverter {
	

	public long conversionToDecimal(byte[] numberToConvert, int base) {
		long decimalValueSoFar = 0;
		
		for (int i = 0; i < numberToConvert.length; i++) {
			decimalValueSoFar += numberToConvert[i] * Math.pow(base, i);
		}

		return decimalValueSoFar;
	}

	public String conversionFromDecimal(long numberToConvert, int base) {
		String newValue = "";
		long[] arrayOfValues;
		int arrayLength = 0;
		long numCalc = numberToConvert;

		// this loop determines the length of array needed
		while (numCalc > 0) {
			numCalc = (numCalc / base);
			arrayLength++;
		}

		arrayOfValues = new long[arrayLength];


		// this loop creates an array of digits
		int x = 0;
		while(numberToConvert > 0) {
			arrayOfValues[x] = (numberToConvert % base);
			numberToConvert = (numberToConvert / base);
			System.out.println(numberToConvert);
			x++;
		}

		for(int i = arrayOfValues.length -1; i >=0; i--) {
			newValue += Long.toString(arrayOfValues[i]) + " ";
		}
		System.out.println(newValue);
		return newValue.trim();
	}



	// public String conversion(int[] numberToConvert, int baseFrom, int baseTo) {
	// 	int[] newBaseValue = new int[numberToConvert.length + 1];
	// 	String newValue = "";
		
	// 	for (int i = 0; i < numberToConvert.length; i++) {

	// 		if (numberToConvert[i] < baseTo) {
	// 			newBaseValue[i] = numberToConvert[i];
	// 		} else {
	// 			newBaseValue[i] = (numberToConvert[i] / baseTo);
	// 			newBaseValue[i+1] = (numberToConvert[i] % baseTo);
	// 		}
	// 	}

	// 	for(int i = 0; i < newBaseValue.length; i ++) {
	// 		System.out.print(newBaseValue[i]);
	// 	}

	// 	return null;

	// }




	public static void main(String[] args) {

	}

}