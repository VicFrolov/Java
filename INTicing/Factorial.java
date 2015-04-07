public class Factorial {

   public static String factorial(INTicing n) {

      INTicing p = new INTicing(n.toString());


      while(!"+1".equals(n.toString())) {
         n = n.minus(new INTicing("1"));
         System.out.println(n.toString());

         p = p.times(n);
         System.out.println(p.toString());
      }

      return p.toString();
   }

      public static void main(String[] args) {

         System.out.println(factorial(new INTicing(args[0])));
   }
}