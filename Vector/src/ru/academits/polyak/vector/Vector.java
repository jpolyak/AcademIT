package ru.academits.polyak.vector;

public class Vector extends IllegalArgumentException {
    private int size;
    private double[] array;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = n;
        array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this.size = vector.size;
        this.array = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = vector.array[i];
        }
    }

    public Vector(double[] array) {
        this.size = array.length;
        this.array = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = array[i];
        }
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = n;
        this.array = new double[this.size];
        if (array.length >= this.size) {
            for (int i = 0; i < this.size; i++) {
                this.array[i] = array[i];
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                this.array[i] = array[i];
            }
            for (int i = array.length; i < this.size; i++) {
                this.array[i] = 0;
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("{");
        for (int i = 0; i < this.size; i++) {
            output.append(String.format(" %.2f,", this.array[i]));
        }
        output.deleteCharAt(output.length() - 1).append("}").deleteCharAt(1);
        return output.toString();
    }

    public void addVector(Vector vector) {
        if (vector.size > this.size) {
            double[] tempArray = new double[vector.size];
            for (int i = 0; i < this.size; i++) {
                tempArray[i] = this.array[i];
            }
            for (int i = this.size; i < vector.size; i++) {
                tempArray[i] = 0;
            }
            this.size = vector.size;
            this.array = tempArray;
        }
        for (int i = 0; i < vector.size; i++) {
            this.array[i] += vector.array[i];
        }
    }

    public void subtractVector(Vector vector) {
        if (vector.size > this.size) {
            double[] tempArray = new double[vector.size];
            for (int i = 0; i < this.size; i++) {
                tempArray[i] = this.array[i];
            }
            for (int i = this.size; i < vector.size; i++) {
                tempArray[i] = 0;
            }
            this.size = vector.size;
            this.array = tempArray;
        }
        for (int i = 0; i < vector.size; i++) {
            this.array[i] -= vector.array[i];
        }
    }

    public void multipleByNumber(double number) {
        for (int i = 0; i < this.size; i++) {
            this.array[i] *= number;
        }
    }

    public void flip() {
        this.multipleByNumber(-1);
    }

    public double getLength() {
        int tempLength = 0;
        for (int i = 0; i < this.size; i++) {
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
        if (this.size != vector.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] - vector.array[i] > 0.0001) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int PRIME = 33;
        int hash = 1;
        for (int i = 0; i < this.size; i++) {
            hash = PRIME * hash + (int) this.array[i];
        }
        return hash;
    }

    public static Vector add(Vector vector1, Vector vector2) {
        if (vector1.size < vector2.size) {
            Vector vector = new Vector(vector2);
            for (int i = 0; i < vector1.size; i++) {
                vector.array[i] += vector1.array[i];
            }
            return vector;
        } else {
            Vector vector = new Vector(vector1);
            for (int i = 0; i < vector2.size; i++) {
                vector.array[i] += vector2.array[i];
            }
            return vector;
        }
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        if (vector1.size < vector2.size) {
            Vector vector = new Vector(vector2);
            vector.flip();
            for (int i = 0; i < vector1.size; i++) {
                vector.array[i] += vector1.array[i];
            }
            return vector;
        } else {
            Vector vector = new Vector(vector1);
            for (int i = 0; i < vector2.size; i++) {
                vector.array[i] -= vector2.array[i];
            }
            return vector;
        }

    }

    public static double scalarProduct(Vector vector1, Vector vector2) {
        int count = (int) Math.min(vector1.size, vector2.size);
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += vector1.array[i] * vector2.array[i];
        }
        return sum;
    }
}
