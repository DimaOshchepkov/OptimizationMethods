package com.Oshchepkov;

import java.util.Arrays;

public class SimplexMatrix{
    Matrix m;
    SimplexMatrix(Matrix restrictions, Matrix func){
        m = restrictions.joinDown(func);
    }
    SimplexMatrix(Matrix m){
        this.m = m;
    }

    public int findLeadColumn(){
        double[] f = m.at(m.row()- 1);
        int ind = 0;
        double value = f[0];
        for (int i = 1; i < m.column() - 1; i++){
            if (f[i] < 0 && -f[i] > value){
                ind = i;
                value = -f[i];
            }
        }

        if (f[ind] >=0)
            return -1;
        return ind;
    }

    public int findLeadLine(int indLeadColumn){
        double valueFree = m.at(0)[m.column()-1];
        int ind = 0;
        for (int i = 0; i < m.row()-1; i++) {
            if (m.at(indLeadColumn)[m.column()-1] != 0 &&
                    m.at(i)[m.column()-1] / m.at(i)[indLeadColumn] <
                    valueFree / m.at(ind)[indLeadColumn]){
                ind = i;
                valueFree = m.at(i)[m.column()-1];
            }
        }
        return ind;
    }
}
