import java.util.Scanner;


public class Pyramid2 {
    public static void main(String[] args) {
        // getting input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int totalRows = input.nextInt();

        // calculate the amount of whitespace per column
        double lastNumber = Math.pow(totalRows, 2);
        String stringLastNumber = "" + lastNumber;
        int whiteSpacePerColumn = stringLastNumber.length();

        // loop through each row
        for (int currRow=0; currRow<totalRows; currRow++) {

            // print white space
            for (int j=0; j<=(totalRows - currRow); j++) {
                System.out.printf("%" + whiteSpacePerColumn + "s", " ");
            }
            // print numbers counting down
            for (int numUp=0; numUp<=currRow; numUp++) {
                int insertNumUp = (int) Math.pow(2, numUp);
                System.out.printf("%" + whiteSpacePerColumn + "s", insertNumUp);
            }
            // print numbers counting down
            for (int numDown=(currRow - 1); numDown>=0; numDown--) {
                int insertNumDown = (int) Math.pow(2, numDown);
                System.out.printf("%" + whiteSpacePerColumn + "s", insertNumDown);
            }
            System.out.println();
        }
    }
}
