package com.Oshchepkov;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Matrix matrix = new ReaderMatrix().read("src/main/resources/simplexMatrix.txt");
        Matrix m2 = new ReaderMatrix().read("src/main/resources/task3-3.txt");
        SecondStage test = new SecondStage();

        System.out.println();

        System.out.println(test.apply(m2).toString());
    }
}
