# Circles

### Assignment, class and language
This is my solution to the assignment **Circles** of class **software developement 1,** written in Java.

### Requirements
This program needs the position of two circles in an Cartesian coordinate system and gets them by the terminal (x-value of center circle1, y-value of center circle1, radius circle1, x-value of center circle2, y-value of center circle2, radius circle2) as double values. It determines the relative position towards the both circles. There are four different results:
**1. disjoint:** both circles have nothing in common
**2. contained:** one of the circles lies completely within the other
**3. intersecting:** one of the circles overlaps the other
**4. touching:** both circles touch each other in exactly one single point

If more than one result is right (for example `contained` and `intersecting`), than the result which occurs first in the list above is the right one (in the example: `contained` comes right before `intersecting`, so `contained` is the right answer).
