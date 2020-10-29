public class Quadratic {
    public static void main(String[] args) {
        // get user input
        System.out.print("Enter a, b, c: ");
        java.util.Scanner input = new java.util.Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        // calculate how many zeros, based on discriminate
        double discriminate = Math.pow(b, 2) - 4 * a * c;
        if (discriminate > 0) {
            double r1 = (-b + Math.pow(discriminate, .5)) / 2 * a;
            double r2 = (-b - Math.pow(discriminate, .5)) / 2 * a;

            // display output
            System.out.println("There are two roots for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2);

        } else if (discriminate == 0) {
            double r1 = -b / 2 * a;

            // display output
            System.out.println("There is one root for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + r1);

        } else {
            System.out.println("There are no roots for the quadratic equation with these coefficients.");
        }
    }
}
