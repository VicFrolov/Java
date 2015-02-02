public class DateCounter {

    public static boolean isLeapYear(int year){
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeapYear && year > 1583) {
            return true;
        } else {
            return false;
        }
    }

    public static int daysInMonth(int year, int month) {
        return 5;
    }

    public static boolean isValidDate(int year, int month, int day) {
        return true;
    }

    public static int daysBetween(int year0, int month0, int day0, int year1, int month1, int day1) {
        return 5;
    }

    public static boolean hasLeapSecond(int year) {
        return true;
    }

    public static boolean hasLeapSecond(int year, int month, int day) {
        return true;
    }

    public static void main(String[] args) {
        return ;
    }
}
