package com.Oshchepkov;

public class SecondStage implements IStageOfSimplexMethod{
    @Override
    public SimplexMatrix apply(Matrix m) {
     
        SimplexMatrix s = new SimplexMatrix(m);
        int leadColumn = s.getLeadColumn(), leadLine = -1;
        while (leadColumn != -1) {
            leadLine = s.getLeadLine(leadColumn);
            s.normalize(leadLine, leadColumn);
            leadColumn = s.getLeadColumn();
        }
        return s;
    }

    @Deprecated //TODO:требует доработки. Работает некорректно
    private double[] extractAnswer(SimplexMatrix s){
        var ans = new double[s.row()-1];
        for (int i = 0; i < ans.length; i++) {
            int notNullInd = 0;
            for (int j = 0; j < ans.length; j++) {
                if (Math.abs(s.at(i)[j]) > Math.pow(10, -6))
                    notNullInd = j;
            }
            ans[i] = s.at(notNullInd)[s.column()-1];
        }
        return ans;
    }
}
