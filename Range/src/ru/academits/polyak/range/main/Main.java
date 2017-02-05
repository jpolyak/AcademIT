package ru.academits.polyak.range.main;

import ru.academits.polyak.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1.0, 10.0);
        double point1 = 2.0;
        double point2 = 12.0;
        System.out.println("Point1 belongs to range: " + range.isInside(point1));
        System.out.println("Point2 belongs to range: " + range.isInside(point2));
        System.out.println("Range length is " + range.intervalLength());
        System.out.println("Range left end is " + range.getFrom());
        System.out.println("Range right end is " + range.getTo());
        range.setFrom(0);
        range.setTo(13);
        System.out.println("Range left end is " + range.getFrom());
        System.out.println("Range right end is " + range.getTo());
        System.out.println("Point1 belongs to range: " + range.isInside(point1));
        System.out.println("Point2 belongs to range: " + range.isInside(point2));
    }
}
