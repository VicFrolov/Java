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
		String tempBinaryString = "";
		boolean isNumberNotZero = true;

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


		//divide by two, and make new binary String array

		while(isNumberNotZero) {
			int sum = 0;
			for(int i = 0; i < decimalDigits.length; i++) {
    			sum += decimalDigits[i];
			}
			if(sum == 0) {
				isNumberNotZero = false;
			} else if(decimalDigits[0] % 2 == 0) {
				tempBinaryString = "0" + tempBinaryString; 	
			} else {
				tempBinaryString = "1" + tempBinaryString;	
			}
			decimalDigits = divideByTwo(decimalDigits);
			for(int i= 0; i < decimalDigits.length; i++) {
				System.out.print(decimalDigits[i]);
			}
			System.out.println("");

		}

		//Convert into a byte array of binary digits, in reverse order
		String[] tempBinaryStringArray = tempBinaryString.split("(?!^)");

		binaryDigits = new byte[tempBinaryStringArray.length];
		for(int i =0 ; i < tempBinaryStringArray.length; i++) {
			binaryDigits[i] = Byte.parseByte(tempBinaryStringArray[i]);   
		}

	}

	public static int[] divideByTwo(int[] number) {
		//Set appropriate length to the byte[] array
		int specificLength = 0;

		//special case: if the int array is of the number 1
		//otherwise, appropriate length is derived
		if(number.length == 1 && number[0] == 1) {
			number = new int[1];
			number[0] = 0;
			return number;
		} else if(number[number.length-1] == 1) {
			specificLength = number.length -1;
		} else {
			specificLength = number.length;
		}
		int[] returnByte = new int[specificLength];

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
			returnByte[i] = number[i];
		}
		return number;
	}

	public String toString() {
		int totalCount = 0;
		String stringDigits = "";

		for(int i= 0; i < binaryDigits.length; i++) {
			totalCount *= 2;
			if(binaryDigits[i] == 1) {
				totalCount +=1;
			}
		}

		if(isPositiveNumber){
			stringDigits = "+";
		} else{
			stringDigits = "-";
		}
		stringDigits = stringDigits + totalCount + "";
		return stringDigits;

	}

	/*public boolean equals(Object n) {
		return false;
	}*/


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