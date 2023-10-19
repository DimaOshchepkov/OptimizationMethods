package com.Oshchepkov;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReaderSimplexMatrix implements IReaderRestriction{

    static final Pattern PATTERN_X = 
            Pattern.compile("([+-]?\\d+)\\s*\\*?\\s*x_(\\d+)");

    static final Pattern PATTERN_F = 
            Pattern.compile("(<=|>=|=)\\s*(\\d+)");

    @Override
    public Matrix read(String path) throws IOException {
        try( BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
           var lines = reader.lines().collect(Collectors.toList());
           int maxCoefficient = getCountVariables(lines);
           double[][] values = new double[lines.size()][maxCoefficient];
           for (String line : lines){
                Matcher x = PATTERN_X.matcher(line);
                Matcher f = PATTERN_F.matcher(line);
                if (!f.find()) 
                    throw new IllegalArgumentException();
                switch (f.group(0)) {
                case "<=" -> {
                    int countVar = 0;
                    while (x.find()) {
                        if (x.group(0) == "-") {
                            
                        }
                    }
                }

                }
                
           }
           throw new Exception();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

    

    private int getCountVariables(List<String> lines) {
        int maxCoefficient = Integer.MIN_VALUE;
        int countNotEquals = 0;

        for (String equation : lines) {
            Matcher matcher = PATTERN_X.matcher(equation);
            Matcher matcher_f = PATTERN_F.matcher(equation);
            while (matcher.find() && matcher_f.find()) {
                if (matcher_f.group(0) == "<=" || matcher_f.group(0) == ">=");
                    countNotEquals++;
                int coefficient = Integer.parseInt(matcher.group(0));
                maxCoefficient = Math.max(maxCoefficient, coefficient);
            }
        }
        return maxCoefficient + countNotEquals; 
    }
    
}
