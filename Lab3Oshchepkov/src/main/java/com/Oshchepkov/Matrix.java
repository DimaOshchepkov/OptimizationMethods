package com.Oshchepkov;

import java.sql.Array;

public class Matrix {
    double[][] array;
    protected Matrix(int row, int column){
        array = new double[row][column];
    }
    protected Matrix(double[][] arr){
        array = arr;
    }

    public int row(){
        return array.length;
    }

    public int column(){
        return array[0].length;
    }

    public double[] at(int ind){
        return array[ind];
    }

    public Matrix joinDown(Matrix m){
        double[][] newArr = new double[array.length + 1][array[0].length];

        for (int i = 0; i < array.length; i++){
            newArr[i] = array[i];
        }

        for (int i = array.length; i < array.length + m.row(); i++){
            newArr[i] = m.at(i - array.length);
        }
    }
}
