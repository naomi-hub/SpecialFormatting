package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWrite {
    private int i = 0;


    public  void ArrayToFile(ArrayList<String> readList, String fileName) {

        try {
            FileWriter writer = new FileWriter(fileName);
            for (String value : readList) {
                writer.write(value);
                if (i < readList.size() - 1) {
                    writer.write(" ");
                    i++;
                }
                    if (value.endsWith(".")) {
                        writer.write("\n");
                        ++i;
                    }
                }
                writer.close();
            }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
