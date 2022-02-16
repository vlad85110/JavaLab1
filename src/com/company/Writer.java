package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;


public class Writer {
    static void writeFile (String fileName, SorterStat statistics) throws IOException {
        String[] file;
        file = fileName.split("\\.");
        if (!file[1].equals("csv") && !file[1].equals("txt")) {
            throw new IOException("Incorrect file format");
        }

        char splitter;
        if (file[1].equals("csv")) {
            splitter = ';';
        } else  splitter = ' ';

        File output = new File(fileName);
        FileWriter fileWriter = new FileWriter(output);
        DecimalFormat df = new DecimalFormat("#.###");
        var sortedData = statistics.getData();
        var size = sortedData.size();
        String formatted;

        for (var i : sortedData.entrySet()) {
            fileWriter.write(i.getKey() + splitter);
            fileWriter.write(i.getValue().toString() + splitter);
            formatted = df.format((double)i.getValue() / size * 100);
            fileWriter.write(formatted + "%" + "\n");
        }

        fileWriter.close();
    }
}
