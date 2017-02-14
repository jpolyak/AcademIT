package ru.academits.polyak.shapes;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getWidth() {
        return side;
    }

    public double getHeight() {
        return side;
    }

    public double getArea() {
        return Math.pow(side, 2);
    }

    public double getPerimeter() {
        return side * 4;
    }

    public String toString() {
        return String.format("Square: side = %.2f", side);
    }

    public int hashCode() {
        final int PRIME = 27;
        int hash = 1;
        hash = PRIME * hash + (int) side;
        return hash;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return this.side == square.side;
    }
}
