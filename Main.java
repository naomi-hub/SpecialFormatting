package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
         String fileIn = "textReader.txt";
         FileFormatting file = new FileFormatting();
         FileRead fileRead = new FileRead();
         FileWrite fileWrite = new FileWrite();
         String toWriteFileName = "output2.txt";

    ArrayList<String> strArray = fileRead.fileToArray(fileIn);
    ArrayList<String> formattedStr = file.formattedArray(strArray);
    fileWrite.ArrayToFile(formattedStr,toWriteFileName);
        }
    }
