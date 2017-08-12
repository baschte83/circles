/**
 * Organisation: University of applied sciences Munich, faculty 07
 * Project: lab to class software developement 1 Mrs. Prof. Dr. Hammerschall, WS 2016/2017
 * Author: Sebastian Baumann, sebastian_baumann@gmx.net
 * Study group: IF3A
 * Date: 26. Oktober 2016
 * Purpose: solution to lab Circles
 */
public class Circles {

    /**
     * This method computes the relation between two given circles.
     * @param x1 X-coordinate of the center of circle 1
     * @param y1 Y-coordinate of the center of circle 1
     * @param r1 radius of circle 1
     * @param x2 X-coordinate of the center of circle 2
     * @param y2 Y-coordinate of the center of circle 2
     * @param r2 radius of circle 2
     * @return - returns the relation between the tw given circles as a String
     */
    private String compareDistance(final double x1, final double y1, final double r1, final double x2, final double y2, final double r2) {

        // Variable to store the computed result to
        String result;

        // --------------------------------------

        /*
         * For my algorithm I use this two values for comparison reasons. Everytime I need a comparison of a cicrle
         * with the greater of both circles I compare it with maximumRadius. If I need a comparison with the smaller
         * of both circles I compare it with minimumRadius.
         */
        double maximumRadius = Math.max(r1, r2);
        double minimumRadius = Math.min(r1, r2);

        // Computation of the distance between the two circle centers
        final double distanceOfCenters = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // Computation of the sum of both circle radii
        final double radiusSum = r1 + r2;


        // Classification of the position of both circles relative to one another

        /*
         * If the distance of both circle centers is greater than the sum of both radii then both circles a disjoint.
         */
        if (distanceOfCenters > radiusSum) {

            result = "disjoint";

        }

        /*
         * If the distance between both circle centers is 0 than both circles are concentric and therefore the greater circle
         * always contains the smaller one. If both circles are of the same size (radii are equal) more than one criterion is
         * right. In such case the assignment demands that the first of all right criteria is the right one and therefore the
         * right answer is 'contained' as well. Also 'contained' is right if the distance of the centers is smaller than the
         * radius of the greater circle and at the same time the radius of the smaller one is at the most as large as the
         * distance between both centers.
         */
        else if ((distanceOfCenters == 0) || ((minimumRadius <= distanceOfCenters) && (distanceOfCenters < maximumRadius))) {

            result = "contained";

        }

        /*
         * If none of the upper criteria is right and the distance between the two centers is smaller than the sum
         * of both radii, both circles are 'intersecting'.
         */
        else if (distanceOfCenters < radiusSum) {

            result = "intersecting";

        }

        /*
         * If none of the upper criteria is right the distance of both centers corresponds to the sum of both radii
         * and therefore both circles are 'touching'.
         */
        else {

            result = "touching";

        }

        // ---------------------------------------

        return result;
    }


    /**
     * This is the main function of the program.
     * @param args - variable number of values from the terminal
     */
    public static void main(String[] args) {

        // First circle: X-coordinate of center, Y-coordinate of center, radius
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double r1 = Double.parseDouble(args[2]);

        // Second circle: X-coordinate of center, Y-coordinate of center, radius
        double x2 = Double.parseDouble(args[3]);
        double y2 = Double.parseDouble(args[4]);
        double r2 = Double.parseDouble(args[5]);

        // Check if both radii are greater than 0. If not, the program ends.
        if ((r1 < 0) || (r2 < 0)) {

            System.out.println("Invalid Input");

        }
        else {

            Circles circles = new Circles();
            String result = circles.compareDistance(x1, y1, r1, x2, y2, r2);
            System.out.println(result);

        }

    }

}