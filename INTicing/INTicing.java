public class INTicing {
    private byte[] binaryDigits;
    private int isPositiveNumber = 0;

    public INTicing(){
        this("0");
    }
    public INTicing(byte[] b, int s){
        this.binaryDigits = b;
        this.isPositiveNumber = s;
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
        while (testforZerosAndSigns) {
            if (indexToCheck == tempStringArray.length -1 && tempStringArray[tempStringArray.length -1].equals("0")) {
                this.binaryDigits = new byte[]{0};
                numberisNotZero = false;
                testforZerosAndSigns = false;
            } else if (tempStringArray[indexToCheck].equals("0") || tempStringArray[indexToCheck].equals("+") || tempStringArray[indexToCheck].equals("-")) {
                indexToCheck++;
            } else {
                testforZerosAndSigns = false;
            }
        }
        if (numberisNotZero){
            //check if the number is positive or negative
            if (tempStringArray[0].equals("-")) {
            this.isPositiveNumber = -1;
            } else {
            this.isPositiveNumber = 1;
            }
            //create an array of inversed decimal digits
            int[] decimalDigits = new int[tempStringArray.length - (indexToCheck)];

            for (int i = tempStringArray.length -1; i >= indexToCheck; i--) {
                decimalDigits[j] = Integer.parseInt(tempStringArray[i]);
                j++;
            }
            //divide by two, and make new binary String array
            while (isNumberNotZero) {
                int sum = 0;
                for (int i = 0; i < decimalDigits.length; i++) {
                    sum += decimalDigits[i];
                }
                if (sum == 0) {
                    isNumberNotZero = false;
                } else if (decimalDigits[0] % 2 == 0) {
                    tempBinaryString = "0" + tempBinaryString;  
                } else {
                    tempBinaryString = "1" + tempBinaryString;  
                }
                decimalDigits = divideByTwo(decimalDigits);
            }
            //Convert into a byte array of binary digits
            String[] tempBinaryStringArray = tempBinaryString.split("(?!^)");

            this.binaryDigits = new byte[tempBinaryStringArray.length];
            for (int i =0 ; i < tempBinaryStringArray.length; i++) {
                this.binaryDigits[i] = Byte.parseByte(tempBinaryStringArray[i]);   
            }      
        }
    }

    public static int[] divideByTwo(int[] number) {
        //Set appropriate length to the byte[] array
        int specificLength = 0;

        //special case: if the int array is of the number 1
        //otherwise, appropriate length is derived
        if (number.length == 1 && number[0] == 1) {
            number = new int[1];
            number[0] = 0;
            return number;
        } else if (number[number.length-1] == 1) {
            specificLength = number.length -1;
        } else {
            specificLength = number.length;
        }
        int[] returnByte = new int[specificLength];

        //Calculate half
        for (int i=0; i+1 < number.length; i++) {
            if (number[i] % 2 != 0){
                number[i] -= 1;
            } 
            if (number[i+1] % 2 !=0) {
                number[i] = number[i] / 2 + 5;
            } else {
                number[i] /= 2;
            }
        }
        number[number.length-1] /= 2;
        //convert to bytes
        for (int i = 0; i < specificLength; i++) {
            returnByte[i] = number[i];
        }

        return number;
    }

    public String toString() {
        String stringDigits = "0";
        
        if (binaryDigits[0] == 0 && binaryDigits.length == 1) {
            return stringDigits;
        }
        
        stringDigits = "1";

        for (int i = 1; i < this.binaryDigits.length; i++) {
            stringDigits = doubleDecimalString(stringDigits);
            if (binaryDigits[i] == 1) {
                stringDigits = addOne(stringDigits);
            }
        }

        if (this.isPositiveNumber == 1){
            stringDigits = "+" + stringDigits;
        } else if (this.isPositiveNumber == -1){
            stringDigits = "-" + stringDigits;
        }

        return stringDigits;
    }

    public static String doubleDecimalString(String s) {
        int[] revIntArrayOfString = new int[s.length()];
        int[] doubledArray = new int[revIntArrayOfString.length + 1];
        String doubledString = "";
        boolean carry = false;
        boolean carryChecker = false;

        for (int i = 0; i < revIntArrayOfString.length; i++) {
            revIntArrayOfString[i] = Character.getNumericValue(s.charAt(s.length() -1 -i));
        }

        for (int i = 0; i < doubledArray.length -1; i++) {
            if (revIntArrayOfString[i] <=4){
                doubledArray[i] = revIntArrayOfString[i] * 2;
                carryChecker = false;
            }
            else {
                doubledArray[i] = revIntArrayOfString[i] * 2 - 10;
                carryChecker = true;
            }
            if (carry) {
                doubledArray[i]++;
                carry = false;
            }
            carry = carryChecker;
        }

        if (revIntArrayOfString[revIntArrayOfString.length-1] >= 5) {
            doubledArray[doubledArray.length -1] = 1;
        }

        if (doubledArray[doubledArray.length-1] == 0) {
            for (int i = doubledArray.length -2; i >= 0; i--) {
                doubledString += (char)(doubledArray[i] + 48);
            }
        } else {
            for (int i = doubledArray.length -1; i >= 0; i--) {
                doubledString += (char)(doubledArray[i] + 48);
            }
        }

        return doubledString;
    }

    public static String addOne(String s) {
        int[] revIntArrayOfString = new int[s.length()];
        int[] arrayPlusOne = new int[revIntArrayOfString.length + 1];
        String plusOneString = "";

        for (int i = 0; i < revIntArrayOfString.length; i++) {
            revIntArrayOfString[i] = Character.getNumericValue(s.charAt(s.length() -1 -i));
        }
        for (int i = 0; i < revIntArrayOfString.length; i++) {
            arrayPlusOne[i] = revIntArrayOfString[i];
        }

        if (arrayPlusOne[0] < 9) {
            arrayPlusOne[0]++;
        } else {
            for (int i= 0; i < arrayPlusOne.length - 1; i++) {
                if (arrayPlusOne[i+1] < 9) {
                    arrayPlusOne[i] = 0;
                    arrayPlusOne[i +1]++;
                    break;
                } else {
                    arrayPlusOne[i] = 0;
                }
            }
        }

        if (arrayPlusOne[arrayPlusOne.length-1] == 0) {
            for (int i = arrayPlusOne.length -2; i >= 0; i--) {
                plusOneString += (char)(arrayPlusOne[i] + 48);
            }
        } else {
            for (int i = arrayPlusOne.length -1; i >= 0; i--) {
                plusOneString += (char)(arrayPlusOne[i] + 48);
            }
        }

        return plusOneString;
    }

    @Override
    public boolean equals(Object n) {
        if (this == n) {
            return true;
        }

        if (n == null) {
            return false;
        }

        if (getClass() != n.getClass()) {
            return false;
        }

        INTicing other = (INTicing)n;
        if (isPositiveNumber != other.isPositiveNumber) {
            return false;
        }

        if (binaryDigits.length != other.binaryDigits.length) {
            return false;
        }

        for (int i = 0; i < binaryDigits.length; i++) {
            if (binaryDigits[i] != other.binaryDigits[i]) {
                return false;
            }
        }


        return true;
    }



    public boolean isGreaterThan(INTicing n) {
        if (this.isPositiveNumber > n.isPositiveNumber) {
            return true;
        } else if (this.isPositiveNumber == 1 && n.isPositiveNumber == 1) {
            if (this.binaryDigits.length > n.binaryDigits.length) {
                return true;
            } else if (this.binaryDigits.length < n.binaryDigits.length) {
                return false;
            }

            for (int i = 0 ; i < this.binaryDigits.length; i++) {
                if (this.binaryDigits[i] > n.binaryDigits[i]) {
                    return true;
                } else if (this.binaryDigits[i] < n.binaryDigits[i]) {
                    return false;
                }
            }

        } else if (this.isPositiveNumber == -1 && n.isPositiveNumber == -1) {
            if (this.binaryDigits.length < n.binaryDigits.length) {
                return true;
            } else if (this.binaryDigits.length > n.binaryDigits.length) {
                return false;
            }

            for (int i = 0 ; i < this.binaryDigits.length; i++) {
                if (this.binaryDigits[i] < n.binaryDigits[i]) {
                    return true;
                } else if (this.binaryDigits[i] > n.binaryDigits[i]) {
                    return false;
                }
            }
        }
        return false;
    }


    public boolean isLessThan(INTicing n) {
        if (this.isPositiveNumber < n.isPositiveNumber) {
            return true;
        } else if (this.isPositiveNumber == 1 && n.isPositiveNumber == 1) {
            if (this.binaryDigits.length < n.binaryDigits.length) {
                return true;
            } else if (this.binaryDigits.length > n.binaryDigits.length) {
                return false;
            }

            for (int i = 0 ; i < this.binaryDigits.length; i++) {
                if (this.binaryDigits[i] < n.binaryDigits[i]) {
                    return true;
                } else if (this.binaryDigits[i] > n.binaryDigits[i]) {
                    return false;
                }
            }

        } else if (this.isPositiveNumber == -1 && n.isPositiveNumber == -1) {
            if (this.binaryDigits.length > n.binaryDigits.length) {
                return true;
            } else if (this.binaryDigits.length < n.binaryDigits.length) {
                return false;
            }

            for (int i = 0 ; i < this.binaryDigits.length; i++) {
                if (this.binaryDigits[i] > n.binaryDigits[i]) {
                    return true;
                } else if (this.binaryDigits[i] < n.binaryDigits[i]) {
                    return false;
                }
            }
        }
        return false;
    }

    public INTicing plus(INTicing addend) {
        byte[] firstValue;
        byte[] secondValue;
        byte[] addedValue;
        boolean carry = false;
        int j = 0;
        int signedValue = 1;


        if (this.isPositiveNumber == 0 && addend.isPositiveNumber == 0) {
            return new INTicing();
        }

        //Using subtraction method with proper allocation of signs
        if (this.isPositiveNumber == 1 && addend.isPositiveNumber == -1) {
            addend.isPositiveNumber = 1;
            return this.minus(addend);
        } else if (this.isPositiveNumber == -1 && addend.isPositiveNumber == 1){
            this.isPositiveNumber = 1;
            return addend.minus(this);
        } 

        //pads arrays accordingly, and creates proper length summed Value thing
        if (this.binaryDigits.length == addend.binaryDigits.length) {
            firstValue = this.binaryDigits;
            secondValue = addend.binaryDigits;
            addedValue = new byte[firstValue.length + 1];
        } else if (this.binaryDigits.length > addend.binaryDigits.length) {
            firstValue = this.binaryDigits;
            addedValue = new byte[firstValue.length + 1];
            secondValue = new byte[firstValue.length];
            
            for (int i = (this.binaryDigits.length - addend.binaryDigits.length); i < secondValue.length; i++) {
                secondValue[i] = addend.binaryDigits[j];
                j++;
            }
        } else {
            secondValue = addend.binaryDigits;
            addedValue = new byte[secondValue.length + 1];
            firstValue = new byte[secondValue.length];

            for (int i = (addend.binaryDigits.length - this.binaryDigits.length); i < firstValue.length; i++) {
                firstValue[i] = this.binaryDigits[j];
                j++;
            }
        }
        //addition with positive numbers
        for (int i = firstValue.length -1; i >= 0; i--) {
            if (firstValue[i] == 0 && secondValue[i] == 0) {
                addedValue[i + 1] = 0;
                if (carry) {
                    addedValue[i + 1] = 1;
                    carry = false;
                }
            } else if ((firstValue[i] == 1 && secondValue[i] == 0) || (firstValue[i] == 0 && secondValue[i] == 1)) {
                addedValue[i + 1] = 1;
                if (carry) {
                    addedValue[i + 1] = 0;
                    carry = true;
                }
            } else {
                if (carry) {
                    addedValue[i + 1] = 1;
                } else {
                    addedValue[i +1] = 0;
                    carry = true;
                }
            }
        }
        
        if (carry) {
            addedValue[0] = 1;
        }
        if (this.isPositiveNumber == -1 && addend.isPositiveNumber == -1) {
            signedValue = -1;
        }
        if (addedValue[0] == 0) {
            byte[] finalizedArray = new byte[addedValue.length - 1];

            for (int i = 1; i < addedValue.length; i++) {
                finalizedArray[i - 1] = addedValue[i];
            }
            return new INTicing(finalizedArray, signedValue);
        } else {
            byte[] finalizedArray = new byte[addedValue.length];
            finalizedArray = addedValue;
            return new INTicing(finalizedArray, signedValue);
        }
    }

    public INTicing minus(INTicing subtrahend) {
        byte[] biggerNumber;
        byte[] smallerNumber;
        byte[] outputNumber;
        int j = 0;
        int leadingZeroIndexLength = 0;
        byte[] finalizedArray;
        //Using addition method with proper allocation of signs
        if (this.isPositiveNumber == 1 && subtrahend.isPositiveNumber == -1) {
            subtrahend.isPositiveNumber = 1;
            return this.plus(subtrahend);
        } else if (this.isPositiveNumber == -1 && subtrahend.isPositiveNumber == 1){
            subtrahend.isPositiveNumber = -1;
            return this.plus(subtrahend);
        } else if (this.isPositiveNumber == 0 || subtrahend.isPositiveNumber == 0){
            return this.plus(subtrahend);
        }
        // detecting the larger number while ignoring it's sign, and padding the smaller one
        if (this.isPositiveNumber == 1 && subtrahend.isPositiveNumber == 1) {
            if (this.isGreaterThan(subtrahend)) {
                biggerNumber = this.binaryDigits;
                smallerNumber = new byte[biggerNumber.length];
                outputNumber = new byte[biggerNumber.length];
                for (int i = (this.binaryDigits.length - subtrahend.binaryDigits.length); i < smallerNumber.length; i++) {
                    smallerNumber[i] = subtrahend.binaryDigits[j];
                    j++;
                }
            } else {
                biggerNumber = subtrahend.binaryDigits;
                smallerNumber = new byte[biggerNumber.length];
                outputNumber = new byte[biggerNumber.length];
                for (int i = (subtrahend.binaryDigits.length - this.binaryDigits.length); i < smallerNumber.length; i++) {
                    smallerNumber[i] = this.binaryDigits[j];
                    j++;
                }
            }
        } else {
            if (this.isLessThan(subtrahend)) {
                biggerNumber = this.binaryDigits;
                smallerNumber = new byte[biggerNumber.length];
                outputNumber = new byte[biggerNumber.length];
                for (int i = (this.binaryDigits.length - subtrahend.binaryDigits.length); i < smallerNumber.length; i++) {
                    smallerNumber[i] = subtrahend.binaryDigits[j];
                    j++;
                }
            } else {
                biggerNumber = subtrahend.binaryDigits;
                smallerNumber = new byte[biggerNumber.length];
                outputNumber = new byte[biggerNumber.length];
                for (int i = (subtrahend.binaryDigits.length - this.binaryDigits.length); i < smallerNumber.length; i++) {
                    smallerNumber[i] = this.binaryDigits[j];
                    j++;
                }                
            }
        }
        // the third  for statement below was mutating subtrahend's instance variables, so I made this new safety net
        byte[] saveOriginalEntryArray = new byte[subtrahend.binaryDigits.length];
        for (int i = 0; i < saveOriginalEntryArray.length; i ++) {
            saveOriginalEntryArray[i] = subtrahend.binaryDigits[i];
        }
        INTicing saveOriginalEntry = new INTicing(saveOriginalEntryArray, subtrahend.isPositiveNumber);

        // the below for statement was mutating this object's instance variables, so I made this new safety net
        byte[] saveOriginalMain = new byte[this.binaryDigits.length];
        for (int i = 0; i < saveOriginalMain.length; i ++) {
            saveOriginalMain[i] = this.binaryDigits[i];
        }
        INTicing saveOriginal = new INTicing(saveOriginalMain, this.isPositiveNumber);

        /* this here is the for loop in question that has been mutating, rarely, 
         * instance variables, for this, I created the above two instances
         */
        for (int i = outputNumber.length -1; i >= 0; i--) {
            if (biggerNumber[i] >= smallerNumber[i]) {
                outputNumber[i] = (byte) (biggerNumber[i] - smallerNumber[i]);
            } else {
                //apply borrowing to the larger Number, altering it for the next iteration
                boolean noBorrowYet = true;
                for (int k = i; k >= 0; k--) {
                    if (biggerNumber[k] == 1 && noBorrowYet) {
                        for (int numberEraser = k; numberEraser < i; numberEraser++){
                            biggerNumber[numberEraser] = 1;
                        }
                        biggerNumber[k] = 0;
                        outputNumber[i] = 1;
                        noBorrowYet = false;
                    }   
                }
            }
        }
        //detect the placement of the first non-zero
        for (int i = 0; i < outputNumber.length; i++) {
            if (outputNumber[i] == 0) {
                leadingZeroIndexLength++;
            } else {
                i = outputNumber.length;
            }
        }
        // special case zero
        if (leadingZeroIndexLength == outputNumber.length) {
            finalizedArray = new byte[]{0};
            return new INTicing(finalizedArray, 0);
        }

        finalizedArray = new byte[outputNumber.length - leadingZeroIndexLength];
        
        for (int i= 0; i < finalizedArray.length; i++) {
            finalizedArray[i] = outputNumber[i + leadingZeroIndexLength];
        }

        if (saveOriginal.isGreaterThan(saveOriginalEntry)) {
            return new INTicing(finalizedArray, 1);
        } else {
            return new INTicing(finalizedArray, -1);
        }
    }    

    public INTicing times(INTicing factor) {
        byte[] multipleModifiedArray;
        byte[] factorModifiedArray;
        INTicing totalMultipliedSum = new INTicing("0");

        //special case for zero
        if ((this.binaryDigits.length == 1 && this.binaryDigits[0] == 0) || (factor.binaryDigits.length == 1 && factor.binaryDigits[0] == 0)) {
            return new INTicing("0");
        }

        while (this.binaryDigits.length != 1 || this.binaryDigits[0] != 1) {

            if (this.binaryDigits[this.binaryDigits.length-1] != 0) {
                totalMultipliedSum = totalMultipliedSum.plus(new INTicing(factor.binaryDigits, factor.isPositiveNumber));
            } 

            multipleModifiedArray = new byte[this.binaryDigits.length - 1];
            factorModifiedArray = new byte[factor.binaryDigits.length + 1];

            for (int i = 0 ; i < this.binaryDigits.length - 1; i++) {
                multipleModifiedArray[i] = this.binaryDigits[i];
            }

            for (int i = 0; i < factor.binaryDigits.length; i++) {
                factorModifiedArray[i] = factor.binaryDigits[i];
            }

            this.binaryDigits = multipleModifiedArray;
            factor.binaryDigits = factorModifiedArray;
        }

        totalMultipliedSum = totalMultipliedSum.plus(new INTicing(factor.binaryDigits, 1));

        //Setting the correct sign
        if (factor.isPositiveNumber == -1 && this.isPositiveNumber == -1) {
            totalMultipliedSum.isPositiveNumber = 1;
        } else if (factor.isPositiveNumber == 1 && this.isPositiveNumber == 1) {
            totalMultipliedSum.isPositiveNumber =1;
        } else {
            totalMultipliedSum.isPositiveNumber = -1;
        }
        return totalMultipliedSum;
    }

    public INTicing div(INTicing divisor) {
        return null;
    }
    public INTicing mod(INTicing divisor) {
        return null;
    }

    

    public static void main(String[] args) {


    }
}