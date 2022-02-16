package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
    String fileName;

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public SorterStat parseFile() throws  IOException {
        File file = new File(this.fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        var data = new TreeMap<String, Integer>();
        String line;

        line = reader.readLine();
        while (line != null) {
            parseStr(line, data);
            line = reader.readLine();
        }

        fr.close();
        reader.close();
        return new SorterStat(data);
    }

    private void parseStr (String str, TreeMap<String, Integer> data) {
        Pattern pattern = Pattern.compile("(\\w|[0-9])+");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find())
            data.merge(matcher.group(), 1, Integer::sum);
    }
}
