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

    public double getLength() {
        return to - from;
    }

    public void printRange() {
        System.out.println("(" + from + ", " + to + ")");
    }

    public boolean isInside(double point) {
        return point >= from && point <= to;
    }

    public boolean existsIntersection(Range range) {
        return !((this.to <= range.from) || (range.to <= this.from));
    }

    public Range getIntersection(Range range) {
        if (this.existsIntersection(range)) {
            return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
        }
        return null;
    }

    public Range[] getUnion(Range range) {
        if (this.existsIntersection(range)) {
            return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        }
        return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
    }

    public Range[] getDifference(Range range) {
        if (this.existsIntersection(range)) {
            if (range.from <= this.from) {
                if (range.to >= this.to) {
                    return new Range[0];
                }
                return new Range[]{new Range(range.to, this.to)};
            }
            if (range.to >= this.to) {
                return new Range[]{new Range(this.from, range.from)};
            }
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        }
        return new Range[]{new Range(this.from, this.to)};
    }
}
