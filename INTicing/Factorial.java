public class Factorial {

   public static INTicing factorial(int n) {
       INTicing fac = new INTicing("1");

       for(int i = 2; i <= n; i++) {
           fac = fac.times(new INTicing(i + ""));
       }
       return fac;
   }

      public static void main(String[] args) {

   }
}