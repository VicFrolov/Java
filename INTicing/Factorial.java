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

      if(args.length != 1) {
         System.out.println("You fool, I demand one argument, and one argument only. Positive numbers only.");
      }

      System.out.println(factorial(new INTicing(args[0])));
   }
}