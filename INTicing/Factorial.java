public class Factorial {

   public static String factorial(INTicing n) {

      INTicing p = new INTicing(n.toString());
 
      while(!"+1".equals(n.toString())) {
         n = n.minus(new INTicing("1"));
         p = p.times(n);         
      }

      return p.toString();
   }

   public static void main(String[] args) {
      int valueCheck;

      if(args.length != 1 || Integer.parseInt(args[0]) < 0) {
         System.out.println("You fool, I demand one argument, and one argument only. Positive numbers only.");
         return;
      }
      try {
         valueCheck = Integer.parseInt(args[0]);

      } catch(NumberFormatException nfe) {
         System.out.println("Input is one argument only, numerical only, positive only. Thank you kindly.");
         return;
      }

      System.out.println(factorial(new INTicing(args[0])));

   }
}