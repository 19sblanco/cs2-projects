public class ISBN {
    public static void main(String[] args) {
        // prompt user and get input
        System.out.print("Enter the first 9 digits of an ISBN: ");
        java.util.Scanner input = new java.util.Scanner(System.in);
        int isbn_num = input.nextInt();

        // calculate numbers
        int d1 = isbn_num / 100_000_000;
        int a = isbn_num - (d1 * 100_000_000);
        int d2 = a / 10_000_000;
        int b = a - (d2 * 10_000_000);
        int d3 = b / 1_000_000;
        int c = b - (d3 * 1_000_000);
        int d4 = c / 100_000;
        int d = c - (d4 * 100_000);
        int d5 = d / 10_000;
        int e = d - (d5 * 10_000);
        int d6 = e / 1_000;
        int f = e - (d6 * 1_000);
        int d7 = f / 100;
        int g = f - (d7 * 100);
        int d8 = g / 10;
        int h = g - (d8 * 10);
        int d9 = h;

        // calculate 10th digit
        int d10 = (d1 + 2 * d2 + 3 * d3 + 4 * d4 + 5 * d5 + 6 * d6 + 7 * d7 + 8 * d8 + 9 * d9) % 11;

        // display output
        System.out.print("The ISBN-10 number is: ");
        if (d10 == 10) {
            System.out.println("" + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + "X");
        } else {
            System.out.println("" + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);
        }
    }
}
