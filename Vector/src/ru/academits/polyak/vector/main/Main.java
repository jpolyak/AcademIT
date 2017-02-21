package ru.academits.polyak.vector.main;

import ru.academits.polyak.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3);
        System.out.println("v1 = " + vector1);
        Vector vector2 = new Vector(vector1);
        System.out.println("v2 = " + vector2);
        double[] array = new double[]{1.0, 2.0, 3.0};
        Vector vector3 = new Vector(array);
        System.out.println("v3 = " + vector3);
        Vector vector4 = new Vector(2, array);
        System.out.println("v4 = " + vector4);
        Vector vector5 = new Vector(5, array);
        System.out.println("v5 = " + vector5);
        System.out.println("v5 size = " + vector5.getSize());
        vector1.addVector(vector3);
        System.out.println("v1 + v3 = " + vector1);
        vector3.subtractVector(vector4);
        System.out.println("v3 - v4 = " + vector3);
        vector5.multipleByNumber(3);
        System.out.println("v5 * 3 = " + vector5);
        vector5.flip();
        System.out.println("v5 flip = " + vector5);
        System.out.println("v5 length = " + vector5.getLength());
        System.out.printf("v5 first component = %.4f\n", vector5.getComponent(0));
        Vector vector6 = new Vector(vector5);
        vector6.setComponent(0, vector5.getComponent(0) + 0.0001);
        System.out.println("v6 = " + vector6);
        System.out.printf("v6 first component = %.5f\n", vector6.getComponent(0));
        System.out.println("v5 = v6: " + vector5.equals(vector6));
        System.out.printf("v4 hash code = %d, v5 hash code = %d, v6 hash code = %d\n", vector4.hashCode(), vector5.hashCode(), vector6.hashCode());
        System.out.println("v4 + v5 static = " + Vector.add(vector4, vector5));
        System.out.println("v4 - v5 static = " + Vector.subtract(vector4, vector5));
        System.out.printf("v4 * v5 = %.2f\n", Vector.scalarProduct(vector4, vector5));
        Vector vector7 = new Vector(-5);
    }
}
