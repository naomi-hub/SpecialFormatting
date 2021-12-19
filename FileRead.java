package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FileRead {
    private Random rand = new Random();

    public ArrayList<String> fileToArray(String fileName) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        String lineRead = "";
        FileInputStream filein = new FileInputStream(fileName);
        Scanner scanNext = new Scanner(filein);
        while (scanNext.hasNextLine() && (lineRead = scanNext.nextLine()) != null) {
            for (String token : lineRead.split(" ")) {
                result.add(token);
            }
        }
        return result;
    }
}

