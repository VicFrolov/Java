public class DateCounter {

    public static boolean isLeapYear(int year){
        boolean isLeapYear = (((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) && year > 1583);
        if (isLeapYear) {
            return true;
        } else {
            return false;
        }
    }

    public static int daysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else  if (month == 2) {
            if (isLeapYear(year) == true) {
                return 29;
            } else {
                return 28;
            }            
        } else {
            // not sure why the hell it won't work without the return 100
            return -1;
        }
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (month > 12 || month < 1 || day > 31 || day < 1) {
            return false;
        } else if (month == 2) {
            if (isLeapYear(year) == true && day > 29) {
                return false;
            } else if (isLeapYear(year) == false && day > 28) {
                return false;
            } else {
                return true;
            }
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        } else {
            return true;
        }
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
