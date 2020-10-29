/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };

        // for the circles
        System.out.print("--- Report of Points and Circles ---\n\n");

        // loop through each circle
        for (int i=0; i<2; i++) {
            // for each point
            for (int j=0; j<4; j++) {
                reportPoint(ptX[j], ptY[j]);
                if (isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i])) {
                    System.out.printf(" is inside");
                }
                else {
                    System.out.printf(" is outside");
                }
                reportCircle(circleX[i], circleY[i], circleRadius[i]);
                System.out.print("\n");
            }
        }

        // for the rectangles
        System.out.print("\n--- Report of Points and Rectangles ---\n\n");

        // loop through each rectangle
        for (int i=0; i<2; i++) {
            // for each point
            for (int j=0; j<4; j++) {
                reportPoint(ptX[j], ptY[j]);
                if (isPointInsideRectangle(ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i])) {
                    System.out.printf(" is inside");
                }
                else {
                    System.out.printf(" is outside");
                }
                reportRectangle(rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                System.out.print("\n");
            }
        }

    }

    public static void reportPoint(double x, double y) {
        System.out.printf("Point(" + x + ", " + y + ")");
    }

    public static void reportCircle(double x, double y, double r) {
        System.out.print(" Circle(" + x + ", " + y + ") " + "Radius: " + r);
    }

    public static void reportRectangle(double left, double top, double width, double height) {
        System.out.print(" Rectangle(" + left + ", " + top + ", " + width + ", " + height + ")");
    }

    public static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        double distance = Math.sqrt((circleY - ptY) * (circleY - ptY) + (circleX - ptX) * (circleX - ptX));
        if (distance <= circleRadius) {
            return true;
        }
        else {
            return false;
        }
    }

    static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        double right = rLeft + rWidth;
        double bottom = rTop - rHeight;
        if (rLeft <= ptX && ptX <= right && bottom <= ptY && ptY <= rTop) {
            return true;
        }
        else {
            return false;
        }
    }

}
