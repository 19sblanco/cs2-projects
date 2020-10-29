public class JulianDate {
    int day = 1;
    int month = 1;
    int year = 1;
    double millisecondsSince1_1_1970 = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
    int daysSince1_1_1970 = (int) (millisecondsSince1_1_1970 / 86400000);

    JulianDate() {
        addDays(719164);
        addDays(daysSince1_1_1970);
    }
    JulianDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    void addDays(int days) {
        for (int i=0; i<days; i++) {
            this.day++;
            if (this.day > getNumberOfDaysInMonth(getYear(), getMonth())) {
                this.day = 1;
                this.month++;
                if (month == 13) {
                    this.month = 1;
                    this.year++;
                }
            }
        }
    }

    void subtractDays(int days) {
        for (int i=0; i<days; i++) {
            this.day--;
            if (this.day == 0) {
                this.month--;
                if (this.month == 0) {
                    this.month = 12;
                    this.year--;
                }
                this.day = getNumberOfDaysInMonth(getYear(), getMonth());
            }
        }
    }

    boolean isLeapYear() {
        return this.year % 4 == 0;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    void printShortDate() {
        System.out.print(getMonth() + "/" + getDayOfMonth() + "/" + getYear());
    }
    void printLongDate() {
        System.out.print(getMonthName() + " " + getDayOfMonth() + ", " + getYear());
    }

    int getMonth() {
        return this.month;
    }

    int getYear() {
        return this.year;
    }

    int getDayOfMonth() {
        return this.day;
    }

    private int getNumberOfDaysInMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }

    }

    private int getNumberOfDaysInYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        }
        else {
            return 365;
        }
    }

    String getMonthName() {
        if (getMonth() == 1) {
            return "January";
        }
        else if (getMonth() == 2) {
            return "February";
        }
        else if (getMonth() == 3) {
            return "March";
        }
        else if (getMonth() == 4) {
            return "April";
        }
        else if (getMonth() == 5) {
            return "May";
        }
        else if (getMonth() == 6) {
            return "June";
        }
        else if (getMonth() == 7) {
            return "July";
        }
        else if (getMonth() == 8) {
            return "August";
        }
        else if (getMonth() == 9) {
            return "September";
        }
        else if (getMonth() == 10) {
            return "October";
        }
        else if (getMonth() == 11) {
            return "November";
        }
        else if (getMonth() == 12) {
            return "December";
        }
        return "Not a month";
    }
}