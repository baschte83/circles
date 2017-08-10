/**
 * Organisation: Hochschule Muenchen, Fakultaet 07
 * Project: Praktikum Softwareentwicklung 1 Frau Prof. Dr. Hammerschall, WS 2016/2017
 * Author: Sebastian Baumann, bauman21@hm.edu
 * Study group: IF3A
 * Date: 10. November 2016
 * Purpose: Loesung Praktikumseinheit 03: Circles
 * Software: Oracle Java SE JDK 1.8.0_101, Windows 10 x86_64
 * Hardware: Intel Core i5-6300 @ 2.40 GHz 2.50 GHz, 2 Cores, 4096 MB RAM
 */


public class Circles {

    private static final double EPSILON = 1E-16;

    /**
     * Berechnet in welchem Verhaeltnis zwei Kreise zueinander stehen.
     * @param x1 x-Wert des Mittelpunkts von Kreis 1
     * @param y1 y-Wert des Mittelpunkts von Kreis 1
     * @param r1 Radius von Kreis 1
     * @param x2 x-Wert des Mittelpunkts von Kreis 2
     * @param y2 y-Wert des Mittelpunkts von Kreis 2
     * @param r2 Radius von Kreis 2
     * @return liefert das Verhaeltnis der Kreise zueinander als String
     */
    public String compareDistance(final double x1, final double y1, final double r1, final double x2, final double y2, final double r2) {

        // Variable fuer das berechnete Ergebnis.
        String result = "";

        // --------------------------------------

        /**
         * Um nicht immer hin- und her zu vergleichen, wenn ich einen Vergleich mit dem groesseren Radius brauche,
         * suche ich per Math.max und Math.min den groesseren und kleineren der Radien heraus und vergleiche dann
         * mit maximalRadius, wenn ich einen Vergleich mit dem groesseren der beiden Radien brauche und mit
         * minimalRadius, wenn ich einen Vergleich mit dem kleineren Radius brauche.
         */
        double maximalRadius = Math.max(r1, r2);
        double minimalRadius = Math.min(r1, r2);

        // Berechnung des Abstandes zwischen den beiden Kreismittelpunkten
        final double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // Berechnung der Summe der beiden Kreisradien
        final double sum = r1 + r2;

        // Klassifizierung der gegenseitigen Lage der beiden Kreise mittels einer if-Kaskade:

        /**
         * Sollte der Abstand der beiden Kreismittelpunkte groesser sein als beide Radien zusammengerechnet,
         * dann sind die beiden Kreise in jedem Fall disjunkt.
         */
        if (distance > sum) {

            result = "disjoint";

        }
        /**
         * Ist der Abstand der beiden Kreise 0, so sind die Kreise konzentrisch und somit beinhaltet immer der
         * groessere Kreis den anderen. Sind beide Kreise gleich gross und konzentrisch, so treffen mehrere Kriterien
         * zu. Da laut Aufgabe das in der Liste erstgenannte zutreffen soll, ist das Ergebnis somit ebenfalls
         * "contained". Es ist ebenfalls ein Kreis im anderen, wenn der Abstand der beiden Kreismittelpunkte
         * kleiner ist als der Radius des groesseren Kreises und gleichzeitig der Radius des kleineren Kreises hoechstens
         * so gross ist, wie der Abstand der beiden Kreismittelpunkte.
         */
        else if ((distance == 0) || ((minimalRadius <= distance) && (distance < maximalRadius))) {

            result = "contained";

        }
        /**
         * Treffen alle oben geprueften Bedingungen nicht zu und ist nun der Abstand der beiden Kreismittelpunkte
         * kleiner als die Summer der beiden Radien, so schneiden sich die beiden Kreise.
         */
        else if (distance < sum) {

            result = "intersecting";

        }
        /**
         * Treffen alle oben genannten Bedingungen nicht zu, so entspricht der Abstand der beiden Kreismittelpunkte
         * exakt der Summe der beiden Radien und die beiden Kreise beruehren sich.
         */
        else {

            result = "touching";

        }

        // ---------------------------------------

        return result;
    }


    /**
     * Start des Programms Circles.
     * @param args erwartet die jeweiligen x- und y- Werte sowie die
     * Radien der beiden Kreise.
     */
    public static void main(String[] args) {

        // Erster Kreis: x-Wert, y-Wert, Radius
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double r1 = Double.parseDouble(args[2]);

        // Zweiter Kreis: x-Wert, y-Wert, Radius
        double x2 = Double.parseDouble(args[3]);
        double y2 = Double.parseDouble(args[4]);
        double r2 = Double.parseDouble(args[5]);

        // Pruefung ob Radien < 0 sind. In diesem Fall Abbruch des
        // Programms mit Fehlermeldung.

        // --------------------------------------

        if ((r1 < 0) || (r2 < 0)) {

            System.out.println("Invalid Input");

        }
        else {

            // Aufruf der Methode zur Berechnung des Verhaeltnisses
            Circles circles = new Circles();
            String result = circles.compareDistance(x1, y1, r1, x2, y2, r2);
            System.out.println(result);

        }

        // --------------------------------------

    }

}