package ru.academits.polyak.range;

import ru.academits.polyak.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1.0, 10.0);
        range.printRange();
        double point1 = 2.0;
        double point2 = 12.0;
        System.out.println("Point1 belongs to range: " + range.isInside(point1));
        System.out.println("Point2 belongs to range: " + range.isInside(point2));
        System.out.println("Range length is " + range.getLength());
        range.setFrom(0);
        range.setTo(13);
        System.out.println("Range left end is " + range.getFrom());
        System.out.println("Range right end is " + range.getTo());

        Range range1 = new Range(5.0, 15.0);
        range1.printRange();
        Range intersection = range.getIntersection(range1);
        System.out.println("Intersection is:");
        intersection.printRange();

        Range[] union = range.getUnion(range1);
        System.out.println("Union is:");
        for (Range r : union) {
            r.printRange();
        }

        Range[] difference = range.getDifference(range1);
        System.out.println("Difference is:");
        if (difference == null) {
            System.out.println("null");
        } else {
            for (Range r : difference) {
                r.printRange();
            }
        }
    }
}
