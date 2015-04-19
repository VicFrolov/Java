public class MakeOptimalChange {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {
            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.");
                System.out.println();
                printUsage();
                return;
            }

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.");
                    System.out.println();
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.");
                        System.out.println();
                        printUsage();
                        return;
                    }
                }
            }

            Tally change = makeOptimalChange(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.");
            System.out.println();
            printUsage();
        }
    }

    public static Tally makeOptimalChange(int[] denominations, int amount) {
        Tally[][] tallyTable = new Tally[denominations.length][amount + 1];

        //makes the first row zero 
        for(int i = 0; i < denominations.length; i++) {
            tallyTable[i][0] = new Tally(denominations.length);

        }

        for(int i = 0; i < denominations.length; i++) {

            for(int j = 1; j <= amount; j++) {
                //special case for the first column
                if(i == 0) {
                    tallyTable[0][j] = new Tally(denominations.length);
                    tallyTable[0][j].setElement(0, j); 
                    System.out.println(tallyTable[i][j].toString());
                } else if(j >= denominations[i]) {
                    System.out.println("CURRENT CYCLE: i value is " + i + " and j value is " + j + "and the denomination is " + denominations[i]);

                    Tally tempOldChange = tallyTable[i][j - denominations[i]]; // not sure about this shit right here bruh    

                    tallyTable[i][j] = new Tally(denominations.length);
                    tallyTable[i][j].setElement(i, 1); 
                    tallyTable[i][j] = tallyTable[i][j].add(tempOldChange);

                    if(tallyTable[i][j].total() > tallyTable[i-1][j].total()) {
                        tallyTable[i][j] = tallyTable[i-1][j];
                    }

                    //******** right above is just adding "1" 
                    System.out.println(tallyTable[i][j].toString());
                } else {
                    //the "NO" condition
                    tallyTable[i][j] = tallyTable[i-1][j];
                    System.out.println("DO YOU REACH ?? I VALUE" + i + "AND J VALUE" + j + "TALLY "  + tallyTable[i][j].toString());

                }        
            }   
        }

        return tallyTable[denominations.length - 1][amount];
    }


    private static void printUsage() {
        System.out.println("Usage: java MakeOptimalChange <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
