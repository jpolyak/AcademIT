package ru.academits.polyak.shapes;

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
        double perimeter = 0;
        int maxPerimeterShapeIndex = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (perimeter < shapes[i].getPerimeter()) {
                perimeter = shapes[i].getPerimeter();
                maxPerimeterShapeIndex = i;
            }
        }
        double secondPerimeter = 0;
        int secondShapeByPerimeterIndex = 0;
        for (int i = 0; i < shapes.length; i++) {
            if ((i != maxPerimeterShapeIndex) && (shapes[i].getPerimeter() != perimeter) && (secondPerimeter < shapes[i].getPerimeter())) {
                secondPerimeter = shapes[i].getPerimeter();
                secondShapeByPerimeterIndex = i;
            }
        }
        return shapes[secondShapeByPerimeterIndex];
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
