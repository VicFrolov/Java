public class INTicingTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_divideByTwo();
        test_doubleDecimalString();
        test_addOne();
        test_Constructor();
        test_toString();
        test_Equals();
        test_isGreaterThan();
        test_isLessThan();
        test_Addition();
        test_Subtraction();
        test_Multiplication();
        test_IntegerDivision();
        test_Modulo();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_divideByTwo() {
        System.out.println("Testing DivideByTwo...");

        int[] numbers = new int[] {1,5,1};
        numbers = INTicing.divideByTwo(numbers); 
        int[] numbersTwo = new int[] {9,5,2};
        numbersTwo = INTicing.divideByTwo(numbersTwo);
        int[] numbersThree = new int[] {9};
        numbersThree = INTicing.divideByTwo(numbersThree);
        int[] numbersFour = new int[] {9,1};
        numbersFour = INTicing.divideByTwo(numbersFour);
        int[] numbersFive = new int[] {1};
        numbersFive = INTicing.divideByTwo(numbersFive);
        
        try {
            displaySuccessIfTrue(5 == numbers[0]);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(7 == numbers[1]);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(0 == numbers[2]);
        } catch(Exception e) {
            displaySuccessIfTrue(!false);
        }
        try {
            displaySuccessIfTrue(0== numbers[3]);
        } catch(Exception e) {
            displaySuccessIfTrue(!false);
        }
        try {
            displaySuccessIfTrue(9 == numbersTwo[0]);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(2 == numbersTwo[1]);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(1 == numbersTwo[2]);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(4 == numbersThree[0]);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(9 == numbersFour[0]);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(0 == numbersFive[0]);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
    }

    private static void test_doubleDecimalString() {
        System.out.println("Testing Double Decimal String...");
        String s = "19483918239083";
        s = INTicing.doubleDecimalString(s);
        String t = "888";
        t = INTicing.doubleDecimalString(t);
        String u = "477";
        u = INTicing.doubleDecimalString(u);
        String v = "44";
        v = INTicing.doubleDecimalString(v);
        String w = "154";
        w = INTicing.doubleDecimalString(w);

        
        try {
            displaySuccessIfTrue("38967836478166".equals(s));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("1776".equals(t));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("954".equals(u));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("88".equals(v));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("308".equals(w));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        


    }

    private static void test_addOne() {
        System.out.println("Testing addOne...");
        String s = "0";
        String t = "1";
        String u = "9";
        String v = "199";
        String w = "199291239";
        String x = "99999";

        s = INTicing.addOne(s);
        t = INTicing.addOne(t);
        u = INTicing.addOne(u);
        v = INTicing.addOne(v);
        w = INTicing.addOne(w);
        x = INTicing.addOne(x);

        try {
            displaySuccessIfTrue("1".equals(s));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("2".equals(t));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("10".equals(u));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("200".equals(v));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("199291240".equals(w));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("100000".equals(x));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }
    private static void test_Constructor() {
        System.out.println("Testing constructors...");
        try {
            displaySuccessIfTrue("+10".equals(new INTicing("10").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("+15123".equals(new INTicing(" 15123").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("-12220".equals(new INTicing("-12220 ").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+15123".equals(new INTicing("  +15123").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+10".equals(new INTicing("+10 ").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+1".equals(new INTicing("  +1").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-1".equals(new INTicing("-1  ").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new INTicing("00").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("0".equals(new INTicing("  000").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new INTicing("000  ").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new INTicing("0").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new INTicing().toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("+314159265358979323846264338327950288"
                    .equals(new INTicing("314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+314159265358979323846264338327950288"
                    .equals(new INTicing("+314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-314159265358979323846264338327950288"
                    .equals(new INTicing("-314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+100"
                    .equals(new INTicing("100").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            new INTicing("a");
            displaySuccessIfTrue(false);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

    }

    private static void test_toString() {
        System.out.println("Testing toString...");

        try {
            displaySuccessIfTrue("+9234013274012419836418634983459547689126439817263478157836453178654"
                    .equals(new INTicing("9234013274012419836418634983459547689126439817263478157836453178654").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+123456789123456789"
                    .equals(new INTicing("123456789123456789").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+123456789123456789"
                    .equals(new INTicing("000123456789123456789").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_Equals() {
        System.out.println("Testing equals...");

        try {
            displaySuccessIfTrue(new INTicing("123456789123456789")
                    .equals(new INTicing("123456789123456789")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new INTicing("123456789123456789")
                    .equals(new INTicing("333"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new INTicing("123456789123456789")
                    .equals(new INTicing("-123456789123456789"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("123456789123456789")
                    .equals(new INTicing("000123456789123456789")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("13")
                    .equals(new INTicing("3")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_isGreaterThan() {
        System.out.println("Testing isGreaterThan...");
        INTicing a = new INTicing("-2");
        INTicing b = new INTicing("-1");

        try {
            displaySuccessIfTrue(new INTicing("3")
                    .isGreaterThan(new INTicing("-1")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("12")
                    .isGreaterThan(new INTicing("11")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1901824098123908")
                    .isGreaterThan(new INTicing("1901824098123907")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("+1901824098123908")
                    .isGreaterThan(new INTicing("1901824098123907")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("-4294967295")
                    .isGreaterThan(new INTicing("-4294967294")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("-102938109238109238019284019324098123098123")
                    .isGreaterThan(new INTicing("-102938109238109238019284019324098123098122")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1901824098123907")
                    .isGreaterThan(new INTicing("-1901824098123908")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        

        try {
            displaySuccessIfTrue(!new INTicing("-1901824098123908")
                    .isGreaterThan(new INTicing("-1901824098123907")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(!new INTicing("0")
                    .isGreaterThan(new INTicing("0000")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }  

        try {
            displaySuccessIfTrue(!new INTicing("0")
                    .isGreaterThan(new INTicing("1")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!new INTicing("3000")
                    .isGreaterThan(new INTicing("4000")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(new INTicing("1505050")
                    .isGreaterThan(new INTicing("1")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(!new INTicing("1")
                    .isGreaterThan(new INTicing("114908123")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(new INTicing("2000000000")
                    .isGreaterThan(new INTicing("1999999999")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(!new INTicing("12938109238109238901283091823091823")
                    .isGreaterThan(new INTicing("12938109238109238901283091823091823")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(new INTicing("10923829384092348000009183981293810230120398123123")
                    .isGreaterThan(new INTicing("10923829384092348000009183981293810230120398123122")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(new INTicing("-100")
                    .isGreaterThan(new INTicing("-1000")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(new INTicing("-2")
                    .isGreaterThan(new INTicing("-3")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("11")
                    .isGreaterThan(new INTicing("10")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(!a.isGreaterThan(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new INTicing("123456789123456789")
                    .equals(new INTicing("-123456789123456789"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("123456789123456789")
                    .equals(new INTicing("000123456789123456789")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

   private static void test_isLessThan() {
        System.out.println("Testing isLessThan...");
        INTicing a = new INTicing("-2");
        INTicing b = new INTicing("-1");

        try {
            displaySuccessIfTrue(!new INTicing("3")
                    .isLessThan(new INTicing("-1")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("12")
                    .isLessThan(new INTicing("11")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("3")
                    .isLessThan(new INTicing("2")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("1901824098123908")
                    .isLessThan(new INTicing("1901824098123907")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("+1901824098123908")
                    .isLessThan(new INTicing("1901824098123907")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-4294967295")
                    .isLessThan(new INTicing("-4294967294")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-102938109238109238019284019324098123098123")
                    .isLessThan(new INTicing("-102938109238109238019284019324098123098122")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("-1901824098123907")
                    .isLessThan(new INTicing("-1901824098123908")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(!new INTicing("0")
                    .isLessThan(new INTicing("00")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(new INTicing("123908120938102498230580123098987127630982340712378627324091823876")
                    .isLessThan(new INTicing("123908120938102498230580123098987127630982340712378627324091823877")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(!new INTicing()
                    .isLessThan(new INTicing()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }         
    }    

    private static void test_Addition() {
        System.out.println("Testing addition...");
        
        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("0").plus(new INTicing("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(new INTicing("13").equals(new INTicing("8").plus(new INTicing("5"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("14").equals(new INTicing("7").plus(new INTicing("7"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("17").equals(new INTicing("9").plus(new INTicing("8"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("2").equals(new INTicing("1").plus(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1").equals(new INTicing("0").plus(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1").equals(new INTicing("1").plus(new INTicing("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("100").equals(new INTicing("0").plus(new INTicing("100"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("2").equals(new INTicing("1").plus(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1000").equals(new INTicing("1").plus(new INTicing("999"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1000").equals(new INTicing("123").plus(new INTicing("877"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-999").equals(new INTicing("-123").plus(new INTicing("-876"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1000").equals(new INTicing("-123").plus(new INTicing("-877"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1000").equals(new INTicing("+3000").plus(new INTicing("-4000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1000").equals(new INTicing("-4000").plus(new INTicing("+3000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("-1").plus(new INTicing("+1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("+1").plus(new INTicing("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("10").equals(new INTicing("-1").plus(new INTicing("+11"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("10").equals(new INTicing("+12").plus(new INTicing("-2"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            INTicing x = new INTicing("+12354");
            displaySuccessIfTrue(new INTicing("24708").equals(x.plus(x)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(("+" + (new java.math.BigInteger("123456789123456789")))
                    .equals(new INTicing("123456789123456789").plus(new INTicing()).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new INTicing("123456789123456789")
                    .plus(new INTicing("-123456789123456789")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("2934097831972391728347612783641927841983569834695")
                    .add(new java.math.BigInteger("9234013274012419836418634983459547689126439817263478157836453178654"));
            displaySuccessIfTrue(("+" + expected).equals(new INTicing("2934097831972391728347612783641927841983569834695")
                    .plus(new INTicing("9234013274012419836418634983459547689126439817263478157836453178654")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("000123456789123456789")
                    .add(new java.math.BigInteger("000123456789123456789"));
            displaySuccessIfTrue(("+" + expected).equals(new INTicing("000123456789123456789")
                    .plus(new INTicing("000123456789123456789")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("888888888888888888")
                    .add(new java.math.BigInteger("-999999999999999999"));
            displaySuccessIfTrue(expected.toString().equals(new INTicing("888888888888888888")
                    .plus(new INTicing("-999999999999999999")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_Subtraction() {
        System.out.println("Testing subtraction...");
        
        try {
            displaySuccessIfTrue(new INTicing("-20").equals(new INTicing("-10").minus(new INTicing("10"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("20").equals(new INTicing("10").minus(new INTicing("-10"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-10").equals(new INTicing("-9").minus(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("501").equals(new INTicing("500").minus(new INTicing("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-2").equals(new INTicing("-1").minus(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("1").equals(new INTicing("0").minus(new INTicing("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1").equals(new INTicing("1").minus(new INTicing("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("0").minus(new INTicing("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("1").equals(new INTicing("0").minus(new INTicing("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("-1").minus(new INTicing("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("16").equals(new INTicing("-15").minus(new INTicing("-31"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("5023").equals(new INTicing("9854").minus(new INTicing("4831"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("-3").equals(new INTicing("5").minus(new INTicing("8"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("-2").equals(new INTicing("-1").minus(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("82").equals(new INTicing("90").minus(new INTicing("8"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("-9").equals(new INTicing("81").minus(new INTicing("90"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("-18").equals(new INTicing("-19").minus(new INTicing("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        
        try {
            displaySuccessIfTrue(new INTicing("18").equals(new INTicing("-1").minus(new INTicing("-19"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-102814210146725407820107883110043133111").equals(new INTicing("-102938019284817230918230981230981231234")
                    .minus(new INTicing("-123809138091823098123098120938098123"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1000").equals(new INTicing("+3000").minus(new INTicing("4000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1000").equals(new INTicing("-4000").minus(new INTicing("-3000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }
    
    private static void test_Multiplication() {
        System.out.println("Testing multiplication...");
        
        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("1").times(new INTicing("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("0").times(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("0").times(new INTicing("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1").equals(new INTicing("1").times(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1").equals(new INTicing("1").times(new INTicing("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1").equals(new INTicing("-1").times(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1200").equals(new INTicing("40").times(new INTicing("30"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1209").equals(new INTicing("39").times(new INTicing("31"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-1200").equals(new INTicing("-40").times(new INTicing("30"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1200").equals(new INTicing("-40").times(new INTicing("-30"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }   

        try {
            displaySuccessIfTrue(new INTicing("1411743158069580861185147302500867038549702925158000").equals(new INTicing("109182398123098098123098").times(new INTicing("12930135098130980985877471000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-20").equals(new INTicing("4").times(new INTicing("-5"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-20").equals(new INTicing("-4").times(new INTicing("5"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("20").equals(new INTicing("-4").times(new INTicing("-5"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(new INTicing("37912").equals(new INTicing("677").times(new INTicing("56"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("15353222434413990441717734710226973507058959958200164621").equals(new INTicing("123908120938102498230580123098987127")
                    .times(new INTicing("123908120938123124123"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }    

    private static void test_IntegerDivision() {
        System.out.println("Testing division...");
        
        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("0").div(new INTicing("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("0").div(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!new INTicing("0").equals(new INTicing("1").div(new INTicing("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("1").equals(new INTicing("1").div(new INTicing("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("999").div(new INTicing("1000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("75").equals(new INTicing("3700").div(new INTicing("49"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("25").equals(new INTicing("100").div(new INTicing("4"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        

        try {
            displaySuccessIfTrue(new INTicing("900").equals(new INTicing("9000").div(new INTicing("10"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("3").equals(new INTicing("27").div(new INTicing("9"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        

        try {
            displaySuccessIfTrue(new INTicing("4").equals(new INTicing("16").div(new INTicing("4"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("947").equals(new INTicing("3790").div(new INTicing("4"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new INTicing("-4").equals(new INTicing("20").div(new INTicing("-5"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }        

        try {
            displaySuccessIfTrue(new INTicing("-4").equals(new INTicing("-20").div(new INTicing("5"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }   

        try {
            displaySuccessIfTrue(new INTicing("4").equals(new INTicing("-20").div(new INTicing("-5"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }   
    }  

    private static void test_Modulo() {
        System.out.println("Testing Modulo Bro...");
        
        try {
            displaySuccessIfTrue(new INTicing("2").equals(new INTicing("20").mod(new INTicing("3"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
       
        try {
            displaySuccessIfTrue(new INTicing("0").equals(new INTicing("-20").mod(new INTicing("4"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        } 

        try {
            displaySuccessIfTrue(new INTicing("47555").equals(new INTicing("190238019348091823").mod(new INTicing("129837"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }                 
    }    

}