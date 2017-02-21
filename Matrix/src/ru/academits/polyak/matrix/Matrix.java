package ru.academits.polyak.matrix;

import ru.academits.polyak.vector.Vector;

import java.util.Arrays;

public class Matrix extends IllegalArgumentException {
    private double[][] array;

    public Matrix(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException();
        }
        array = new double[m][n];
    }

    public int getNumberOfRows() {
        return this.array.length;
    }

    public int getNumberOfColumns() {
        return this.array[0].length;
    }

    public Matrix(Matrix matrix) {
        this.array = new double[matrix.getNumberOfRows()][matrix.getNumberOfColumns()];
        for (int i = 0; i < this.getNumberOfRows(); i++) {
            this.array[i] = Arrays.copyOf(matrix.array[i], matrix.getNumberOfColumns());
        }
    }

    public Matrix(double[][] array) {
        this.array = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = Arrays.copyOf(array[i], array[i].length);
        }
    }

    public Matrix(Vector[] matrix) {
        int sizeN = matrix[0].getSize();
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].getSize() > sizeN) {
                sizeN = matrix[i].getSize();
            }
        }
        array = new double[matrix.length][sizeN];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].getSize(); j++) {
                array[i][j] = matrix[i].getComponent(j);
            }
        }
    }


    public Vector getLineVector(int lineNumber) {
        return new Vector(array[lineNumber]);
    }

    public void setLineVector(int lineNumber, Vector vector) {
        if (vector.getSize() < this.getNumberOfColumns()) {
            for (int i = 0; i < vector.getSize(); i++) {
                this.array[lineNumber][i] = vector.getComponent(i);
            }
            for (int i = vector.getSize(); i < this.getNumberOfColumns(); i++) {
                this.array[lineNumber][i] = 0;
            }
        } else {
            for (int i = 0; i < this.getNumberOfColumns(); i++) {
                this.array[lineNumber][i] = vector.getComponent(i);
            }
        }
    }

    public Vector getColumnVector(int columnNumber) {
        if (columnNumber < 0 || columnNumber >= this.getNumberOfColumns()) {
            throw new IllegalArgumentException();
        }
        double[] column = new double[this.getNumberOfRows()];
        for (int i = 0; i < this.getNumberOfRows(); i++) {
            column[i] = this.array[i][columnNumber];
        }
        return new Vector(column);
    }

    public void transpose() {
        double[][] tempArray = new double[this.getNumberOfColumns()][this.getNumberOfRows()];
        Matrix matrix = new Matrix(tempArray);
        for (int i = 0; i < this.getNumberOfColumns(); i++) {
            matrix.setLineVector(i, this.getColumnVector(i));
        }
        this.array = matrix.array;
    }

    public void multipleByNumber(double number) {
        for (int i = 0; i < this.getNumberOfRows(); i++) {
            Vector tempVector = new Vector(this.getLineVector(i));
            tempVector.multipleByNumber(number);
            this.setLineVector(i, tempVector);
        }
    }

    //для детерминанта
    public boolean isSquareMatrix() {
        return this.getNumberOfRows() == this.getNumberOfColumns();
    }

    //для детерминанта
    public Matrix getMinorMatrix(int i, int j) {
        if (!this.isSquareMatrix() || this.getNumberOfRows() < 2) {
            throw new IllegalArgumentException();
        }
        Matrix matrix = new Matrix(this.getNumberOfRows() - 1, this.getNumberOfRows() - 1);
        int tempK = 0;
        int tempP;
        for (int k = 0; k < this.getNumberOfRows(); k++) {
            Vector vector = new Vector(this.getNumberOfRows() - 1);
            tempP = 0;
            if (k == i) {
                tempK = 1;
            } else {
                for (int p = 0; p < this.getNumberOfRows(); p++) {
                    if (p == j) {
                        tempP = 1;
                    } else {
                        vector.setComponent(p - tempP, this.array[k][p]);
                    }
                }
                matrix.setLineVector(k - tempK, vector);
            }
        }
        return matrix;
    }

    public double getDeterminant() {
        if (!this.isSquareMatrix()) {
            throw new IllegalArgumentException();
        }
        if (this.getNumberOfRows() == 1) {
            return this.array[0][0];
        }
        double sum = 0;
        //разложение по 1 строке
        for (int j = 0; j < this.getNumberOfRows(); j++) {
            sum += Math.pow(-1, j % 2) * this.getLineVector(0).getComponent(j) * this.getMinorMatrix(0, j).getDeterminant();
        }
        return sum;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("{");
        for (int i = 0; i < this.getNumberOfRows(); i++) {
            output.append(this.getLineVector(i).toString()).append(", ");
        }
        output.delete(output.length() - 2, output.length()).append("}");
        return output.toString();
    }

    public Vector multipleByVectorFromRight(Vector vector) {
        if (vector.getSize() != this.getNumberOfColumns()) {
            throw new IllegalArgumentException();
        }
        Vector resVector = new Vector(this.getNumberOfRows());
        for (int i = 0; i < this.getNumberOfRows(); i++) {
            resVector.setComponent(i, Vector.scalarProduct(this.getLineVector(i), vector));
        }
        return resVector;
    }

    //для операций между матрицами
    public boolean isOfSameSize(Matrix matrix) {
        return this.getNumberOfRows() == matrix.getNumberOfRows() && this.getNumberOfColumns() == matrix.getNumberOfColumns();
    }

    public void addMatrix(Matrix matrix) {
        if (!this.isOfSameSize(matrix)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < this.getNumberOfRows(); i++) {
            Vector tempVector = new Vector(this.getNumberOfColumns());
            for (int j = 0; j < this.getNumberOfColumns(); j++) {
                tempVector.setComponent(j, this.getLineVector(i).getComponent(j) + matrix.getLineVector(i).getComponent(j));
            }
            this.setLineVector(i, tempVector);
        }
    }

    public void subtractMatrix(Matrix matrix) {
        if (!this.isOfSameSize(matrix)) {
            throw new IllegalArgumentException();
        }
        Matrix tempMatrix = new Matrix(matrix);
        tempMatrix.multipleByNumber(-1);
        this.addMatrix(tempMatrix);
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        if (!matrix1.isOfSameSize(matrix2)) {
            throw new IllegalArgumentException();
        }
        Matrix tempMatrix = new Matrix(matrix1);
        tempMatrix.addMatrix(matrix2);
        return tempMatrix;
    }

    public static Matrix subtract(Matrix matrix1, Matrix matrix2) {
        if (!matrix1.isOfSameSize(matrix2)) {
            throw new IllegalArgumentException();
        }
        Matrix tempMatrix = new Matrix(matrix2);
        tempMatrix.multipleByNumber(-1);
        return Matrix.add(matrix1, tempMatrix);
    }

    public static Matrix multiple(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getNumberOfColumns() != matrix2.getNumberOfRows()) {
            throw new IllegalArgumentException();
        }
        Matrix resMatrix = new Matrix(matrix1.getNumberOfRows(), matrix2.getNumberOfColumns());
        for (int i = 0; i < matrix1.getNumberOfRows(); i++) {
            Vector tempVector = new Vector(matrix2.getNumberOfColumns());
            for (int j = 0; j < matrix2.getNumberOfColumns(); j++) {
                tempVector.setComponent(j, Vector.scalarProduct(matrix1.getLineVector(i), matrix2.getColumnVector(j)));
            }
            resMatrix.setLineVector(i, tempVector);
        }
        return resMatrix;
    }
}
