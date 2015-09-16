public class BaseConverterTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_conversionToDecimal();
        test_conversionToNewBase();
     

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_conversionToDecimal() {
        System.out.println("Testing Conversion to Decimal...");
        BaseConverter test1 = new BaseConverter();
        
        try {
            displaySuccessIfTrue(157 == test1.conversionToDecimal(new byte[]{5,3,2}, 8));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(0 == test1.conversionToDecimal(new byte[]{0}, 10000));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        
        try {
            displaySuccessIfTrue(2984432549403l == test1.conversionToDecimal(new byte[]{3,2,1,3,2,1,3,2,1}, 36));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }   
        try {
            displaySuccessIfTrue(276 == test1.conversionToDecimal(new byte[]{3,4,5}, 7));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 
        try {
            displaySuccessIfTrue(13 == test1.conversionToDecimal(new byte[]{0,1}, 13));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 
        try {
            displaySuccessIfTrue(1 == test1.conversionToDecimal(new byte[]{1,0}, 13));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }   
        try {
            displaySuccessIfTrue(306 == test1.conversionToDecimal(new byte[]{17,17}, 17));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }  
        try {
            displaySuccessIfTrue(917086735 == test1.conversionToDecimal(new byte[]{2,19,31,31,31,31}, 31));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }   

        

        
    }

    private static void test_conversionToNewBase() {
        System.out.println("Testing conversionToNewBase...");
        BaseConverter test2 = new BaseConverter();
        String banana = "1 0 1 1 0";

        try {
            displaySuccessIfTrue(("2 2").equals(test2.conversionFromDecimal(10l, 4)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(("1 0 1 1 0").equals(test2.conversionFromDecimal(276l, 4)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);

        }
        try {
            displaySuccessIfTrue(("1 0 1 1 0").equals(banana));
        } catch(Exception e) {
            displaySuccessIfTrue(false);

        }        

    }











}