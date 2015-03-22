public class INTicing {
	private byte[] binaryDigits;
	private boolean isPositiveNumber = false;



	public INTicing(){
		this("0");
	}

	public INTicing(String s) {
		int j = 0;
		boolean testforZerosAndSigns = true;
		int indexToCheck = 0;
		String[] tempStringArray = s.trim().split("(?!^)");	

		//check if the number is positive or negative
		if(!tempStringArray[0].equals("-")) {
			isPositiveNumber = true;
		}
		//find the index of the first digit of the number in the String array
		while(testforZerosAndSigns){
			if(tempStringArray[indexToCheck].equals("0") || tempStringArray[indexToCheck].equals("+") || tempStringArray[indexToCheck].equals("-")) {
				indexToCheck++;
			} else {
				testforZerosAndSigns = false;
			}

		}
		//create an array of inversed decimal digits
	    int[] decimalDigits = new int[tempStringArray.length - (indexToCheck)];

		for(int i = tempStringArray.length -1; i >= indexToCheck; i--) {
		    decimalDigits[j] = Integer.parseInt(tempStringArray[i]);
		    j++;
		}

		this.binaryDigits = divideByTwo(decimalDigits);

	}

	public static byte[] divideByTwo(int[] number) {
		//Set appropriate length to the bytep[] array
		int specificLength = 0;
		if(number[number.length-1] == 1){
			specificLength = number.length -1;
		} else {
			specificLength = number.length;
		}
		byte[] returnByte = new byte[specificLength];

		//Calculate half
		for(int i=0; i+1 < number.length; i++) {
			if(number[i] % 2 != 0){
				number[i] -= 1;
			}
			if(number[i+1] % 2 !=0) {
				number[i] = number[i] / 2 + 5;
			} else {
				number[i] /= 2;
			}
		}
		number[number.length-1] /= 2;

		//convert to bytes
		for(int i = 0; i < specificLength; i++) {
			returnByte[i] = (byte) number[i];
		}
		return returnByte;
	}

	public String toString() {
/*		String values = "";


		if(digits[0] == 1) {
			values += "=";
		} else if(digits[0] == 2) {

		}

		for(int i = 0; i < digits.length; i++){
			values += Byte.toString(digits[i]);
		}*/
		return null;

	}

	public boolean equals(Object n) {
		return false;
	}


	public boolean isGreaterThan(INTicing n) {
		return false;
	}
	public boolean isLessThan(INTicing n) {
		return false;
	}
	public INTicing div(INTicing divisor) {
		return null;
	}
	public INTicing mod(INTicing divisor) {
		return null;
	}
	public INTicing plus(INTicing addend) {
		return null;
	}
	public INTicing minus(INTicing subtrahend) {
		return null;
	}	
	public INTicing times(INTicing factor) {
		return null;
	}


	

	public static void main(String[] args) {

	}
}