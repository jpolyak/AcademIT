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
        if (this == null) {
            System.out.println("null");
        } else {
            System.out.println("(" + from + ", " + to + ")");
        }
    }

    public boolean isInside(double point) {
        return point >= from && point <= to;
    }

    public Range getIntersection(Range range) {
        if ((this.to < range.from) || (range.to < this.from)) {
            return null;
        }
        if (this.from <= range.from) {
            if (this.to <= range.to) {
                return new Range(range.from, this.to);
            } else {
                return new Range(range.from, range.to);
            }
        } else {
            if (range.to <= this.from) {
                return new Range(this.from, range.to);
            } else {
                return new Range(this.from, this.to);
            }
        }
    }

    public Range[] getUnion(Range range) {
        if (this.getIntersection(range) == null) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }
        return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
    }

    public Range[] getDifference(Range range) {
        if (range.from < this.from && range.to > this.to) {
            return null;
        }
        if (this.getIntersection(range) == null) {
            return new Range[]{new Range(this.from, this.to)};
        }
        Range intersection = this.getIntersection(range);
        if (this.from == intersection.from) {
            return new Range[]{new Range(intersection.to, this.to)};
        }
        if (this.to == intersection.to) {
            return new Range[]{new Range(this.from, intersection.from)};
        }
        return new Range[]{new Range(this.from, intersection.from), new Range(intersection.to, this.to)};
    }
}
