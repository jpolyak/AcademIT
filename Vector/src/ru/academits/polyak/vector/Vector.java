package ru.academits.polyak.vector;

import java.util.Arrays;

public class Vector extends IllegalArgumentException {
    private double[] array;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        array = new double[n];
    }

    public Vector(Vector vector) {
        this.array = Arrays.copyOf(vector.array, vector.getSize());
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        this.array = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.array = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return this.array.length;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("{");
        for (int i = 0; i < this.getSize(); i++) {
            output.append(String.format(" %.2f,", this.array[i]));
        }
        output.deleteCharAt(output.length() - 1).append("}").deleteCharAt(1);
        return output.toString();
    }

    public void addVector(Vector vector) {
        if (vector.getSize() > this.getSize()) {
            this.array = Arrays.copyOf(this.array, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); i++) {
            this.array[i] += vector.array[i];
        }
    }

    public void subtractVector(Vector vector) {
        if (vector.getSize() > this.getSize()) {
            this.array = Arrays.copyOf(this.array, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); i++) {
            this.array[i] -= vector.array[i];
        }
    }

    public void multipleByNumber(double number) {
        for (int i = 0; i < this.getSize(); i++) {
            this.array[i] *= number;
        }
    }

    public void flip() {
        this.multipleByNumber(-1);
    }

    public double getLength() {
        int tempLength = 0;
        for (int i = 0; i < this.getSize(); i++) {
            tempLength += Math.pow(this.array[i], 2);
        }
        return Math.sqrt(tempLength);
    }

    public double getComponent(int position) {
        return this.array[position];
    }

    public void setComponent(int position, double component) {
        this.array[position] = component;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        if (this.getSize() != vector.getSize()) {
            return false;
        }
        for (int i = 0; i < this.getSize(); i++) {
            if (this.array[i] - vector.array[i] > 0.0001) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int PRIME = 33;
        int hash = 1;
        for (int i = 0; i < this.getSize(); i++) {
            hash = PRIME * hash + (int) this.array[i];
        }
        return hash;
    }

    public static Vector add(Vector vector1, Vector vector2) {
        if (vector1.getSize() < vector2.getSize()) {
            Vector vector = new Vector(vector2);
            for (int i = 0; i < vector1.getSize(); i++) {
                vector.array[i] += vector1.array[i];
            }
            return vector;
        } else {
            Vector vector = new Vector(vector1);
            for (int i = 0; i < vector2.getSize(); i++) {
                vector.array[i] += vector2.array[i];
            }
            return vector;
        }
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector2);
        vector.flip();
        return Vector.add(vector1, vector);
    }

    public static double scalarProduct(Vector vector1, Vector vector2) {
        int count = Math.min(vector1.getSize(), vector2.getSize());
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += vector1.array[i] * vector2.array[i];
        }
        return sum;
    }
}
