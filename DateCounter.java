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
        int totalDays = 0;
        int earlierYear = 0;
        int earlierMonth = 0;
        int earlierDay = 0;
        int newerYear = 0;
        int newerMonth = 0;
        int newerDay = 0;

        if (year0 > year1) {
            earlierYear = year1;
            earlierMonth = month1;
            earlierDay = day1;
            newerYear = year0;
            newerMonth = month0;
            newerDay = day0;
        } else if (year1 > year0) {
            earlierYear = year0;
            earlierMonth = month0;
            earlierDay = day0;
            newerYear = year1;
            newerMonth = month1;
            newerDay = day1;
        } else {
            if (month0 > month1) {
                earlierMonth = month1;
                earlierYear = year1;
                earlierDay = day1;
                newerMonth = month0;
                newerYear = year0;
                newerDay = day0;
            } else if (month1 > month0) {
                earlierMonth = month0;
                earlierYear = year0;
                earlierDay = day0;
                newerMonth = month1;
                newerYear = year1;
                newerDay = day1;
            } else {
                if (day1 > day0) {
                    earlierDay = day0;
                    earlierMonth = month0;
                    earlierYear = year0;
                    newerDay = day1;
                    newerMonth = month1;
                    newerYear = year1;
                } else if (day0 > day1) {
                    earlierDay = day1;
                    earlierMonth = month1;
                    earlierYear = year1;
                    newerDay = day0;
                    newerMonth = month0;
                    newerYear = year0;

                }
            }
        }

        while((earlierYear != newerYear) || (earlierMonth != newerMonth) || (earlierDay != newerDay)) {

            if(isValidDate(earlierYear, earlierMonth, (earlierDay + 1))) {
                earlierDay += 1;
            } else if(earlierMonth <= 11) {
                earlierMonth += 1;
                earlierDay = 1;
            } else {
                earlierYear += 1;
                earlierMonth = 1;
                earlierDay = 1;
            }

            totalDays += 1;
        }

        return totalDays;
    }

    public static boolean hasLeapSecond(int year) {
        int[] leapYears = {1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1981, 1982, 1983, 1985, 1987, 1989, 1990, 1992, 1993, 1994, 1995, 1997, 1998, 2005, 2008, 2012, 2015};
        for(int i = 0; i < leapYears.length; i++ ) {
            if(year == leapYears[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLeapSecond(int year, int month, int day) {
        int[] hasLeapFirstHalf = {1972, 1981, 1982, 1983, 1985, 1992, 1993, 1994, 1997, 2012, 2015};
        int[] hasLeapSecondHalf = {1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1987, 1989, 1990, 1995, 1998, 2005, 2008};

        if (month == 6 && day == 30) {
            for(int i = 0; i < hasLeapFirstHalf.length; i++ ) {
                if(year == hasLeapFirstHalf[i]) {
                    return true;
                }
            }
        }
        if (month == 12 && day == 31) {
            for(int i = 0; i < hasLeapSecondHalf.length; i++ ) {
                if(year == hasLeapSecondHalf[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Usage: java DateCounter <year0> <month0> <day0> <year1> <month1> <day1>");
            return;
        }

        return ;
    }
}
