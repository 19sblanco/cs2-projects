public class ComputerArea {
    public static void main(String[] args) {
        System.out.print("Enter a circle radius: ");
        java.util.Scanner input = new java.util.Scanner(System.in);

        double radius = input.nextDouble();
        double radius2 = input.nextDouble();

        double area = radius * radius * 3.14159;

        System.out.println("The area for the circle of radius " + radius + " is " + area);
        System.out.println(radius2);
    }
}
