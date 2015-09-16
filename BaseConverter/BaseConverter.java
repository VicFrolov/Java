import java.util.Scanner;

public class BaseConverter {

    public static long conversionToDecimal(int[] numberToConvert, int base) {
        long decimalValueSoFar = 0;
        
        for (int i = 0; i < numberToConvert.length; i++) {
            decimalValueSoFar += numberToConvert[i] * Math.pow(base, i);
        }

        return decimalValueSoFar;
    }

    public static String conversionFromDecimal(long numberToConvert, int base) {
        String newValue = "";
        long[] arrayOfValues;
        int arrayLength = 0;
        long numCalc = numberToConvert;

        if (numberToConvert == 0) {
            return "0";
        } else {

            // this loop determines the length of array needed
            while (numCalc > 0) {
                numCalc = (numCalc / base);
                arrayLength++;
            }

            arrayOfValues = new long[arrayLength];

            // this loop creates an array of digits
            int x = 0;
            while (numberToConvert > 0) {
                arrayOfValues[x] = (numberToConvert % base);
                numberToConvert = (numberToConvert / base);
                x++;
            }

            for (int i = arrayOfValues.length -1; i >=0; i--) {
                newValue += Long.toString(arrayOfValues[i]) + " ";
            }

            return newValue.trim();
        }
    }

    private static void greetings() {
        System.out.println("Please enter a number you want to convert.\nSeparate each value with a space. \nThe last 2 values will be \"base from\" and \"base to\"\n");
        System.out.println("For example, if I want to convert 1A (in hex) to base 7, you would write:");
        System.out.println("1 10 16 7");
        System.out.println("\n\n Your input:");

    }

    private static void userInputChecker() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] userInputSeparatedDigits;
        int baseFrom = 0;
        int baseTo = 0;
        
        greetings();
        String userInput = sc.nextLine();

        boolean goodEntry = true;

        while (goodEntry) {
            goodEntry = false;
            for (int i = 0; i < userInput.length(); i++){
                char c = userInput.charAt(i);        
                if (!(c == '0') && !(c == '1') && !(c == '2') && !(c == '3') && !(c == ' ') && !(c == '4') 
                    && !(c == '5') && !(c == '6') && !(c == '7') && !(c == '8') && !(c == '9')) {
                        System.out.println("You've entered an invalid input. You can only enter digits and spaces. \n Please try again:");
                        userInput = sc.nextLine();
                        goodEntry = true;
                }
            }

        }

        String[] stringArrayOfDigits= userInput.split(" ");
        userInputSeparatedDigits = new int[stringArrayOfDigits.length];

        baseFrom = Integer.parseInt(stringArrayOfDigits[stringArrayOfDigits.length -2]);
        baseTo = Integer.parseInt(stringArrayOfDigits[stringArrayOfDigits.length -1]);
        int j = 0;
        
        for (int i = stringArrayOfDigits.length - 3; i >= 0 ; i--) {

            userInputSeparatedDigits[j] = Integer.parseInt(stringArrayOfDigits[i]);
            if(userInputSeparatedDigits[j] > baseFrom) {
                System.out.println("Sorry, you've entered a value larger than your base for conversion. Please try again.");
                return;
            } 
            j++;
        }

        System.out.println("\nThe number above that you have converted from base " + baseFrom + " to base " + baseTo + " is...." );
        System.out.println(conversionFromDecimal( conversionToDecimal(userInputSeparatedDigits, baseFrom), baseTo));

        sc.close();
    }

}