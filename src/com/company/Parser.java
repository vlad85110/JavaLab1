package com.company;
import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
    private final HashMap<String, Integer> data;

    public Parser(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        data = new HashMap<>();
        String line;

        line = reader.readLine();
        while (line != null) {
            parseStr(line);
            line = reader.readLine();
        }
        fr.close();
        reader.close();
    }

    public void parseStr (String str) {
        Pattern pattern = Pattern.compile("(\\w|[0-9])+");
        Matcher matcher = pattern.matcher(str);

        int count;
        while (matcher.find()) {
            if (data.get(matcher.group()) == null) {
                data.put(matcher.group(), 1);
            } else {
                count = data.get(matcher.group());
                data.put(matcher.group(), count + 1);
            }
        }
    }

    public HashMap<String, Integer> getData() {
        return data;
    }
}
