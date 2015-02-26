public class AngryBallsTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Vector();


        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    

    private static void test_Vector() {
        System.out.println("Testing Vector equality...");

        Vector v = new Vector(1988,450);

      try {
            displaySuccessIfTrue(1988 == v.x());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
     try {
            displaySuccessIfTrue(450 == v.y());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }    

    }
}

    
    
    
    
    

