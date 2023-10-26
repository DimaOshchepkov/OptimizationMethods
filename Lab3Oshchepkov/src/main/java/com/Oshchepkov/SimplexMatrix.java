package com.Oshchepkov;


public class SimplexMatrix{
    Matrix m;
    SimplexMatrix(Matrix restrictions, Matrix func){
        m = restrictions.joinDown(func);
    }
    SimplexMatrix(Matrix m){
        this.m = m;
    }

    public int getLeadColumn(){
        double[] f = m.at(m.row()- 1);
        int ind = 0;
        double value = f[0];
        for (int i = 1; i < m.column() - 1; i++){
            if (f[i] < 0 && -f[i] >= value){
                ind = i;
                value = -f[i];
            }
        }

        if (f[ind] >=0)
            return -1;
        return ind;
    }

    public int getLeadLine(int indLeadColumn){
        double valueFree = 1000000000000.0;
        double valueInColumn = 1;
        int ind = -1;
        for (int i = 0; i < m.row()-1; i++) {
            if (m.at(i, indLeadColumn) != 0 &&
                    m.at(i, m.column()-1) / m.at(i, indLeadColumn) >= 0 &&
                    m.at(i, m.column()-1) / m.at(i, indLeadColumn) <= valueFree / valueInColumn){
                ind = i;
                valueFree = m.at(i,m.column()-1);
                valueInColumn = m.at(i, indLeadColumn);
            }
        }
        return ind;
    }

    public void normalize(int line, int col){
        m.multy(line, 1 / m.at(line)[col]);
        for (int i = line + 1; i < m.row(); i++) {
            if (m.at(i)[col] != 0)
                m.plusLine(i, line, -m.at(i)[col]);
        }
        for (int i = line - 1; i >= 0; i--) {
            if (m.at(i)[col] != 0)
                m.plusLine(i, line, -m.at(i)[col]);
        }
    }

    public int row() {
        return m.row();
    }

    public int column() {
        return m.column();
    }
    public double[] at(int i) {
        return m.at(i);
    }
    public double at(int row, int col) {
        return m.at(row, col);
    }

    @Override
    public String toString(){
        return m.toString();
    }
}
