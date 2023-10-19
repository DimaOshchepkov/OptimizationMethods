package com.Oshchepkov;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Matrix matrix = new ReaderMatrix().read("src/main/resources/simplexMatrix.txt");
        Matrix m2 = new ReaderMatrix().read("src/main/resources/task3-3.txt");
        SecondStage test = new SecondStage();
        /*for (var x : test.apply(matrix))
            System.out.println(x);*/

        System.out.println();

        for (var x : test.apply(m2))
            System.out.println(x);
    }
}
