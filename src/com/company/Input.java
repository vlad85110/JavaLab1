package com.company;
import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class Input {
    private Map<String, Integer> data;

    public Input(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line;

        line = reader.readLine();
       // while (line != null) {
            parseStr(line);

            //line = reader.readLine();
            //System.out.println(line);
       // }

        fr.close();
        reader.close();
    }

    public void parseStr (String str) {
        StringBuilder builder = new StringBuilder(str);

        Pattern pattern = Pattern.compile("(\\w|[0-9])+");

        Matcher matcher = pattern.matcher(str);
       // System.out.print(matcher.group());
        System.out.print(matcher.matches());


        //System.out.print(str.substring(matcher.start(), matcher.end()));
    }
}
