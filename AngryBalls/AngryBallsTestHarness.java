public class AngryBallsTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Vector();
        test_add();
        test_scale();


        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    

    private static void test_Vector() {
        System.out.println("Testing Vector creation...");

        Vector v = new Vector(1988,450);
        Vector w = new Vector(1,2);

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

    private static void test_add() {
        System.out.println("Testing add method...");

        Vector v = new Vector(1988,450), w = new Vector(1,2), sum = v.add(w);

        try {
            displaySuccessIfTrue(1989 == sum.x());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(452 == sum.y());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }    
    }

    private static void test_scale() {
        System.out.println("Testing scale method...");

        Vector g = new Vector(12,45);
        Vector newG = g.scale(2);

        try {
            displaySuccessIfTrue(24 == newG.x());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(90 == newG.y());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }    
    }    


}

    
    