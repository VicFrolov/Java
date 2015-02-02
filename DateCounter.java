import java.util.Calendar;

public class DateCounter {

    public static boolean isLeapYear(int year){
        return  (((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) && year > 1583);
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
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.set(year0, month0, day0);
        cal2.set(year1, month1, day1);

        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();

        long diff = milis2 - milis1;

        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));


        /*int totalDays = 0;
        int earlierDate;
        int newerDate;
        if (year0 > year1) {
            earlierDate = day1;
            newerDate = day0;
        } else if (year1 > year0) {
            earlierDate = day0;
            newerDate = day1;
        } else {
            if (month0 > month1) {
                earlierDate = day0;
                newerDate = day1;
            } else if (month1 > month 0) {
                earlierDate = year
            }
        }

        while(smallerYear < biggerYear) {
            if (isLeapYear(smallerYear)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
            smallerYear += 1;
        }
        return totalDays;
        */
        return diffDays;
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
