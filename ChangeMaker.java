class ChangeMaker {
	
	public static int getQuarters(int cents) {
		return cents / 25;
	}

	public static int getDimes(int cents) {
		return cents / 10;
	}

	public static int getNickels(int cents) {
		return cents / 5;
	}

	public static int getPennies(int cents) {
		return cents / 1;
	}

	public static int[] getChange(int cents) {
		int[] coins = new int[4];
		coins[0] = getQuarters(cents);
		cents = cents - 25 * coins[0];

		coins[1] = getDimes(cents);
		cents = cents - 10 *coins[1];

		coins[2] = getNickels(cents);
		cents = cents - 5 * coins[2];
		
		coins[3] = getPennies(cents);

		return coins;

	}

	public static void main(String[] args){
		int cashMoney = Integer.parseInt(args[0]);
		int[] result = getChange(cashMoney);
		System.out.println("Quarters:" + result[0]);
		System.out.println("Dimes:" + result[1]);
		System.out.println("Nickels:" + result[2]);
		System.out.println("Pennies:" + result[3]);					
	}
	
}