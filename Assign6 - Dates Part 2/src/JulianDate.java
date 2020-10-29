public class JulianDate extends Date {
    JulianDate() {
        super(1, 1, 1);
        addDays(719164);
        addDays(daysSince1_1_1970);
    }
    JulianDate(int year, int month, int day) {
        super(day, month, year);
    }

    boolean isLeapYear() {
        return this.year % 4 == 0;
    }

    boolean isLeapYear(int year) {
        return year % 4 == 0;
    }
}
