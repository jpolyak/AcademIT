package ru.academits.polyak.shapes.main;

import ru.academits.polyak.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape maxAreaShape(Shape[] shapes) {
        double area = 0;
        int shapeIndex = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (area < shapes[i].getArea()) {
                area = shapes[i].getArea();
                shapeIndex = i;
            }
        }
        return shapes[shapeIndex];
    }

    public static Shape secondShapeByPerimeter(Shape[] shapes) {
        Shape[] array = Arrays.copyOf(shapes, shapes.length);
        for (int i = 0; i < array.length - 1; i++) {
            Shape temporaryShape = array[i];

            double minimumValue = array[i].getPerimeter();
            int minimumValueIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getPerimeter() < minimumValue) {
                    minimumValue = array[j].getPerimeter();
                    minimumValueIndex = j;
                }
            }

            int k = minimumValueIndex;
            array[i] = array[k];
            array[k] = temporaryShape;
        }
        return array[array.length - 2];
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(10);
        Circle circle2 = new Circle(15);
        Rectangle rectangle1 = new Rectangle(5, 10);
        Rectangle rectangle2 = new Rectangle(10, 35);
        Square square1 = new Square(10);
        Square square2 = new Square(15);
        Triangle triangle1 = new Triangle(0, 0, 0, 5, 10, 0);
        Triangle triangle2 = new Triangle(0, 0, 0, 8, 13, 0);
        Shape[] shapes = new Shape[]{circle1, circle2, rectangle1, rectangle2, square1, square2, triangle1, triangle2};
        Shape shape = maxAreaShape(shapes);
        System.out.println(shape + " area " + shape.getArea());
        shape = secondShapeByPerimeter(shapes);
        System.out.println(shape + " perimeter " + shape.getPerimeter());
    }
}
