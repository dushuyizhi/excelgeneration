package com.liu.excelgeneration.util.GenExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileUtils {

    public static InputStream getInputStream(String path) throws Exception{
        return  new FileInputStream(new File(path));
    }
}
