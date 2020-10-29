import java.util.Scanner;

public class Pyramid1 {
    public static void main(String[] args) {
        // get input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int rows = input.nextInt();

        // determine the amount of white space
        String rowsString = String.valueOf(rows);
        int columnLength = rowsString.length();

        // loop through each row
        for (int i=0; i<=rows; i++) {

            // print white space
            for (int j = rows; j>=i; j--) {
                System.out.printf("%" + columnLength + "s ", " ");
            }

            // print numbers counting down
            for (int n=i; n>=1; n--) {
                System.out.printf("%" + columnLength + "s ", n);
            }

            // print numbers counting up
            for (int k=2; k<=i; k++) {
                System.out.printf("%" + columnLength + "s ", k);
            }
            System.out.println();
        }

    }
    }