package ru.academits.polyak.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {
        return radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    public String toString() {
        return String.format("Circle: radius = %.2f", radius);
    }

    public int hashCode() {
        final int PRIME = 21;
        int hash = 1;
        hash = PRIME * hash + (int) radius;
        return hash;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;
        return this.radius == circle.radius;
    }
}
