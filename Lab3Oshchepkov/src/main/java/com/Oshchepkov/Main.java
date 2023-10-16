package com.Oshchepkov;

public class Main {
    public static void main(String[] args) {
        double[][] arr = {{1, 3, 1, 0, 9},
                        {1, 1, 0, 1, 7},
                        {-2, -3, 0, 0, 0}};
        Matrix matrix = new Matrix(arr);
        SecondStage test = new SecondStage();
        for (var x : test.apply(matrix))
            System.out.println(x);
    }
}
