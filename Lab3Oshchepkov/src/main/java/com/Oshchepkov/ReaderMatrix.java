package com.Oshchepkov;

import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderMatrix implements IReaderRestriction{
    @Override
    public Matrix read(String path) throws IOException {
        try( BufferedReader reader = new BufferedReader(new FileReader(path))) {
            var lines = reader.lines()
                    .map(line -> Arrays.stream(line.split("\\s+"))
                            .mapToDouble(Double::parseDouble)
                            .toArray())
                    .toArray(double[][]::new);
            return new Matrix(lines);
        }catch (Exception ex)
        {
            throw ex;
        }
    }
}
