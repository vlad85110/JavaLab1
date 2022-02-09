package com.company;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.print("wrong input");
        }

        Parser input;
        try {
            input = new Parser(args[0]);
        } catch (IOException ex) {
            System.err.print("Cannot open file \n" + ex);
            return;
        }

        HashMap<String, Integer> data;
        Statistics statistics;
        try {
            data = input.getData();
            if (data.isEmpty()) return;
        } catch (Error e) {
            System.err.print("Error" + e);
            return;
        }

        statistics = new Statistics(data);
        try {
            Writer.writeFile(args[1], statistics.getSortedData(), statistics.getSize());
        }
        catch (IOException ex) {
            System.err.print("Opening file error : " + ex);
        }
    }
}
