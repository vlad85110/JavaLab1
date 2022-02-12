package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.print("wrong input");
        }

        Parser input;
        Statistics statistics = null;
        input = new Parser(args[0]);
        try {
            statistics =input.parseFile();
        } catch (IOException ex){
            System.err.print("Error" + ex);
        }

        try {
            assert statistics != null;
            Writer.writeFile(args[1], statistics);
        }
        catch (IOException ex) {
            System.err.print("Opening file error : " + ex);
        }
    }
}
