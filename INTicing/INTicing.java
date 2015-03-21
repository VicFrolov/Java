public class INTicing {
	private byte[] digits;
	private byte[] number;

	public INTicing(){
		this("0");
	}

	public INTicing(String s) {

		
	}

	public static byte[] divideByTwo(byte[] number) {
		for(byte i=0; i < number.length; i++) {
			if(number[i] % 2 != 0){
				number[i] -= 1;
			}
			if(number[i+1] % 2 !=0) {
				number[i] /= 2 + 5;
			} else {
				number[i] /= 2;
			}
		}
		return number;
	}

	public String toString() {
		String values = "";


		if(digits[0] == 1) {
			values += "=";
		} else if(digits[0] == 2) {

		}

		for(int i = 0; i < digits.length; i++){
			values += Byte.toString(digits[i]);
		}
		return values;
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