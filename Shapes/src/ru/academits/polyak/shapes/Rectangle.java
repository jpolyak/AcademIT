package ru.academits.polyak.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public String toString() {
        return String.format("Reactangle: width = %.2f height = %.2f", width, height);
    }

    public int hashCode() {
        final int PRIME = 25;
        int hash = 1;
        hash = PRIME * hash + (int) width;
        hash = PRIME * hash + (int) height;
        return hash;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return (this.width == rectangle.width) && (this.height == rectangle.height);
    }
}
