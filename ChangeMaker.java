class ChangeMaker {
	public static int getQuarters(int cents) {
		return cents / 25;
	}

	public static void main(String[] args){
		System.out.println(getQuarters(Integer.parseInt(args[0])));
	}
	
}
