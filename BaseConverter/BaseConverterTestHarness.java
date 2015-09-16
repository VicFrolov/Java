public class BaseConverterTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_baseConverter();
     

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_baseConverter() {
        System.out.println("Testing Arrays...");
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
    

        
    }
}