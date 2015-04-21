public class MakeOptimalChangeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        test_CAD();
        test_IMPOSSIBLE();
        test_random();
        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_CAD() {
        int[] cadDenominations = new int[] {5, 10, 25, 100, 200};
        Tally resultCad = MakeOptimalChange.makeOptimalChange(cadDenominations, 215);


        try {
            displaySuccessIfTrue(1 == resultCad.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == resultCad.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == resultCad.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == resultCad.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == resultCad.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }        


    }
    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };
        Tally result = MakeOptimalChange.makeOptimalChange(usaDenominations, 99);

        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }


    }


    public static void test_random() {
        int[] usaDenominations = new int[] { 2, 3, 9, 100 };
        Tally result = MakeOptimalChange.makeOptimalChange(usaDenominations, 32);

        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(3 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }


    }

    public static void test_IMPOSSIBLE() {
        int[] usaDenominations = new int[] { 25, 10, 5, 2 };
        Tally result = MakeOptimalChange.makeOptimalChange(usaDenominations, 1);

        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

    }

}
