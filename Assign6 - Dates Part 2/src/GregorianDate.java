public class GregorianDate extends Date{
    GregorianDate() {
        super(1, 1, 1970);
        addDays(daysSince1_1_1970);
    }

    // overload, takes: year, month, day
    GregorianDate(int year,int month,int day) {
        super(day, month, year);
    }

    @Override
    boolean isLeapYear() {
        if (this.year % 4 == 0) {
            if (this.year % 400 == 0) {
                return true;
            }
            else return this.year % 100 != 0;
        }
        return false;
    }

    @Override
    boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                return true;
            }
            else return year % 100 != 0;
        }
        return false;
    }
}
