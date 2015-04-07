/*
*	Market Capitalization takes in two arguments, number of shares outstanding
*	and the price per share, and prints out the market cap.
*/


public class MarketCapitalization {

    public static String marketCapitalization(INTicing n, INTicing p) {
    	// INTicing marketCap = n.times(p);
    	return n.times(p).toString();
    }

    public static void main(String[] args) {
    	int valueCheck;
   		if(args.length != 2 || Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[1]) < 0) {
        	System.out.println("MarketCapitalization formula requires you to input positive integers, please.");
        	System.out.println("First argument is the number of shares outstanding, second argument is the price per share.");
        	return;
      	}
      	try {
        	valueCheck = Integer.parseInt(args[0]);

      	} catch(NumberFormatException nfe) {
        	System.out.println("Input is one argument only, numerical only, positive only. Thank you kindly.");
        	return;
      	}

		System.out.println(marketCapitalization(new INTicing(args[0]), new INTicing(args[1])));
	}
}