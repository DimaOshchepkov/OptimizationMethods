package com.Oshchepkov;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

interface IReaderRestriction {
    Matrix read(String path) throws IOException;
}
