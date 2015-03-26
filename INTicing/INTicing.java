public class INTicing {
    private byte[] binaryDigits;
    private int isPositiveNumber = 0;

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
        boolean numberisNotZero = true;
        //find the index of the first digit of the number in the String array
        while(testforZerosAndSigns) {
            if(indexToCheck == tempStringArray.length -1 && tempStringArray[tempStringArray.length -1].equals("0")) {
                this.binaryDigits = new byte[]{0};
                numberisNotZero = false;
                testforZerosAndSigns = false;
            } else if(tempStringArray[indexToCheck].equals("0") || tempStringArray[indexToCheck].equals("+") || tempStringArray[indexToCheck].equals("-")) {
                indexToCheck++;
            } else {
                testforZerosAndSigns = false;
            }
        }
        if(numberisNotZero){
            //check if the number is positive or negative
            if(tempStringArray[0].equals("-")) {
            this.isPositiveNumber = -1;
            } else {
            this.isPositiveNumber = 1;
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
            }
            //Convert into a byte array of binary digits, in reverse order
            String[] tempBinaryStringArray = tempBinaryString.split("(?!^)");

            this.binaryDigits = new byte[tempBinaryStringArray.length];
            for(int i =0 ; i < tempBinaryStringArray.length; i++) {
                this.binaryDigits[i] = Byte.parseByte(tempBinaryStringArray[i]);   
            }
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

    // public String toString() {

    //  int totalCount = 0;
    //  String stringDigits = "";

    //  for(int i= 0; i < this.binaryDigits.length; i++) {
    //      totalCount *= 2;
    //      if(this.binaryDigits[i] == 1) {
    //          totalCount +=1;
    //      }
    //  }

    //  if(this.isPositiveNumber == 1){
    //      stringDigits = "+";
    //  } else if(this.isPositiveNumber == -1){
    //      stringDigits = "-";
    //  }
    //  stringDigits = stringDigits + totalCount + "";
    //  return stringDigits;

    // }


    // public String toString() {
    //     String stringDigits = "0";
        
    //     if(binaryDigits[0] == 0 && binaryDigits.length == 1) {
    //         return stringDigits;
    //     }
        
    //     stringDigits = "1";

    //     for(int i = 1; i < this.binaryDigits.length; i++) {
    //         stringDigits = doubleDecimalString(stringDigits);
    //         if(binaryDigits[i] == 1) {
    //             stringDigits = addOne(stringDigits);

    //         }
    //     }

    //     if(this.isPositiveNumber == 1){
    //         stringDigits = "+" + stringDigits;
    //     } else if(this.isPositiveNumber == -1){
    //         stringDigits = "-" + stringDigits;
    //     }
    //         System.out.println(stringDigits);

    //     return stringDigits;
    // }



    public static String doubleDecimalString(String s) {
        int[] revIntArrayOfString = new int[s.length()];
        int[] doubledArray = new int[revIntArrayOfString.length + 1];
        String doubledString = "";
        boolean carry = false;

        for(int i = 0; i < revIntArrayOfString.length; i++) {
            revIntArrayOfString[i] = Character.getNumericValue(s.charAt(s.length() -1 -i));
        }
        for(int i = 0; i < doubledArray.length - 1; i++) {
            if(revIntArrayOfString[i] <=4){
                doubledArray[i] = revIntArrayOfString[i] * 2;
            }
            else {
                doubledArray[i] = revIntArrayOfString[i] * 2 - 10;
                doubledArray[i +1] += 1;
            }
            for(int j=0; j < doubledArray.length; j++) {
                System.out.println("LOL" + doubledArray[j]);
            }
            
        }

        for(int i=0; i < doubledArray.length; i++) {
            System.out.println(doubledArray[i]);
        }

        if(doubledArray[doubledArray.length-1] == 0) {
            for(int i = doubledArray.length -2; i >= 0; i--) {
                doubledString += (char)(doubledArray[i] + 48);                
            }
        } else {
            for(int i = doubledArray.length -1; i >= 0; i--) {
                doubledString += (char)(doubledArray[i] + 48);
            }
        } 
        System.out.println("string: " + doubledString);
        return doubledString;
    }



    public static String addOne(String s) {
        String[] digits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for(int i = 0; i < digits.length; i++) {
            if(s == digits[i] && i <9){
                return digits[i+1];
            } else if(s == digits[i] && i == 9) {
                return digits[0];
            }
        }
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