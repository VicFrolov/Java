public class AngryBallsTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Vector();
        test_add();
        test_scale();
        test_Ball();
        test_getRadius();
        test_accelerate();
        test_move();

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

    private static void test_Ball() {
        System.out.println("Testing Ball method...");
        Vector testLocation = new Vector(100,200);
        Vector testInitialVelocity = new Vector(200,200);
        Ball testBall = new Ball(10,testLocation, testInitialVelocity);

        try {
            displaySuccessIfTrue(10 == testBall.getRadius());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(testLocation == testBall.getLocation());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
    }



    private static void test_getRadius() {
        System.out.println("Testing getRadius method...");
        Vector testLocation = new Vector(05,10);
        Vector testInitialVelocity = new Vector(200,200);
        Ball testBall = new Ball(300,testLocation, testInitialVelocity);

        try {
            displaySuccessIfTrue(300 == testBall.getRadius());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
  
    }    
    
    private static void test_accelerate() {
        System.out.println("Testing accelerate method...");
        Vector testLocation = new Vector(100,200);
        Vector testInitialVelocity = new Vector(200,200);
        
        Ball testBall = new Ball(10,testLocation, testInitialVelocity);
        testBall.accelerate(new Vector(0, -9.8), 1);
        
        Ball testBallTwo = new Ball(20, new Vector(0,0), new Vector(30,30));
        testBallTwo.accelerate(new Vector(0, -10), 2);
        
        Ball testBallThree = new Ball(20, new Vector(10,15), new Vector(10,20));
        testBallThree.accelerate(new Vector(5, -10), 0.5);

        try {
            displaySuccessIfTrue(190.2 == testBall.getVelocity().y());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(200.0 == testBall.getVelocity().x()) ;
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(30.0 == testBallTwo.getVelocity().x()) ;
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(10.0 == testBallTwo.getVelocity().y()) ;
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(12.5 == testBallThree.getVelocity().x()) ;
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(15.0 == testBallThree.getVelocity().y()) ;
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }

  
    }

    private static void test_move() {
        System.out.println("Testing move method...");
        Ball testBall = new Ball(5,new Vector(10,0), new Vector(20,10));
        testBall.move(1);
        Ball testBallTwo = new Ball(5,new Vector(0,0), new Vector(20,10));
        testBallTwo.move(2);
        Ball testBallThree = new Ball(5,new Vector(10,0), new Vector(20,10));
        testBallThree.move(0.5);



        try {
            displaySuccessIfTrue(30 == testBall.getLocation().x());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(10 == testBall.getLocation().y());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }  
          try {
            displaySuccessIfTrue(40 == testBallTwo.getLocation().x());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(20 == testBallTwo.getLocation().y());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(20 == testBallThree.getLocation().x());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(5 == testBallThree.getLocation().y());
        } catch(Exception exc) {
            displaySuccessIfTrue(false);
        }    


    }  



}

    
    