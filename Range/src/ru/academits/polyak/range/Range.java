package ru.academits.polyak.range;

public class Range {
    private double from;
    private double to;

    public Range(double newFrom, double newTo) {
        from = newFrom;
        to = newTo;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double newFrom) {
        from = newFrom;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double newTo) {
        to = newTo;
    }

    public double intervalLength() {
        return to - from;
    }

    public boolean isInside(double point) {
       return point >= from && point <= to;
    }
}
