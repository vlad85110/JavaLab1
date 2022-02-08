package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Input input = new Input("input.txt");
        }
        catch (IOException ex){
            System.err.print("Cannot open file \n" + ex);
        }
    }
}
