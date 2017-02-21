package ru.academits.polyak.matrix.main;

import ru.academits.polyak.matrix.Matrix;
import ru.academits.polyak.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 2);
        System.out.println("Matrix1: \n" + matrix1);
        System.out.println("Number of rows: " + matrix1.getNumberOfRows());
        System.out.println("Number of columns: " + matrix1.getNumberOfColumns());
        Matrix matrix2 = new Matrix(matrix1);
        System.out.println("Matrix2: \n" + matrix2);
        double[][] array = new double[][]{{1, 2, 3},
                {4, 5, 6}};
        Matrix matrix3 = new Matrix(array);
        System.out.println("Matrix3: \n" + matrix3);
        Vector[] vectors = new Vector[]{new Vector(new double[]{1, 2}),
                                        new Vector(new double[]{3, 4, 5}),
                                        new Vector(new double[]{6, 7, 8, 9, 10})};
        Matrix matrix4 = new Matrix(vectors);
        System.out.println("Matrix4: \n" + matrix4);
        System.out.println("Matrix4 first line: " + matrix4.getLineVector(0));
        matrix4.setLineVector(0, new Vector(new double[]{11, 12, 3, 14, 15, 16, 17, 18}));
        System.out.println("Matrix4 first line: " + matrix4.getLineVector(0));
        System.out.println("Matrix4 first column: " + matrix4.getColumnVector(0));
        matrix4.transpose();
        System.out.println("Matrix4 transposed: \n" + matrix4);
        matrix4.multipleByNumber(0.5);
        System.out.println("Matrix4 multipled by 0.5: \n" + matrix4);
        System.out.println("Matrix3 multipled by vector: \n" + matrix3.multipleByVectorFromRight(new Vector(new double[]{1, 2, 3})));
        Matrix matrix5 = new Matrix(new double[][]{{1, 0, 0},
                                                    {0, 1, 0},
                                                    {0, 0, 1}});
        Matrix matrix6 = new Matrix(new double[][]{{0, 2, 2},
                                                    {2, 0, 2},
                                                    {2, 2, 1}});
        System.out.println("Matrix5 add Matrix6 static: \n" + Matrix.add(matrix5, matrix6));
        System.out.println("Matrix5 subtract Matrix6 static: \n" + Matrix.subtract(matrix5, matrix6));
        Matrix matrix7 = new Matrix(matrix5);
        matrix7.addMatrix(matrix6);
        System.out.println("Matrix5 add Matrix6: \n" + matrix7);
        matrix7 = new Matrix(matrix5);
        matrix7.subtractMatrix(matrix6);
        System.out.println("Matrix5 subtract Matrix6: \n" + matrix7);
        System.out.println("Matrix5 mult Matrix6: \n" + Matrix.multiple(matrix5, matrix6));
        System.out.println("Matrix6 determinant: " + matrix6.getDeterminant());
    }
}
