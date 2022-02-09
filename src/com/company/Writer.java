package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;


public class Writer {
    static void writeFile (String fileName,  ArrayList<HashMap.Entry<String, Integer>> sortedData,
                           int size) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        DecimalFormat df = new DecimalFormat("#.###");
        String formatted;

        for (var i : sortedData) {
            fileWriter.write(i.getKey() + ";");
            fileWriter.write(i.getValue().toString() + ";");
            formatted = df.format((double)i.getValue() / size * 100);
            fileWriter.write(formatted + "%" + "\n");
        }

        fileWriter.close();
    }
}
