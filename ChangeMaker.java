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
		int[] dividers = new int[4];
		dividers[0] = 25;
		dividers[1] = 10;
		dividers[2] = 5;
		dividers[3] = 1;

		for(int i = 0; i<4; i++){
			coins[i] = (int) cents / dividers[i];
			cents = cents - dividers[i] * coins[i];
		}
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