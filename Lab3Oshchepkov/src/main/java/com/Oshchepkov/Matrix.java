package com.Oshchepkov;


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
        return new Matrix(newArr);
    }

    public void plusLine(int to, int from, double multiplier){
        for (int i = 0; i < this.column(); i++){
            array[to][i] += array[from][i] * multiplier;
        }
    }

    public void multy(int to, double multiplier){
        for (int i = 0; i < this.column(); i++){
            array[to][i] *= multiplier;
        }
    }
}
