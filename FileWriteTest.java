package TestPackage;

import com.company.FileFormatting;
import com.company.FileRead;
import com.company.FileWrite;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileWriteTest {
private FileWrite fileWrite = new FileWrite();

    private void writeToFile(String fileName, String msg) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(msg);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Test
    void arrayToFile() throws IOException {
        writeToFile("Class Syllabus.txt", "This is %s:[A-P][5,10]% and you are %i:[6,10]% years old but " +
                "are qualified to participate in the math league fit for university students!");

        FileFormatting file = new FileFormatting();
        FileRead fileRead = new FileRead();
        FileWrite fileWrite = new FileWrite();
        ArrayList<String> str = fileRead.fileToArray("Class Syllabus.txt");
        ArrayList<String> str2 = file.formattedArray(str);
        fileWrite.ArrayToFile(str2,"outPut.txt");
        assertEquals(read("outPut.txt"), read("outPut.txt"));

    }

    @Test
    void testArrayToFile() throws IOException {
        FileFormatting file = new FileFormatting();
        FileRead fileRead = new FileRead();
        FileWrite fileWrite = new FileWrite();
        String name = "output3.txt";
        ArrayList<String> str = fileRead.fileToArray("textReader.txt");
        ArrayList<String> str2 = file.formattedArray(str);
        fileWrite.ArrayToFile(str2,"outputTestArrayToFile.txt");
        assertEquals(read("outputTestArrayToFile.txt"),read("outputTestArrayToFile.txt"));

    }
    @Test
    void testWritingToFile() throws IOException {
        ArrayList<String> o = new ArrayList<>();
        writeToFile("testReader.txt", "I love going out to play especially %{A-G}[8,123]% when the weather " +
                "is %d:[60,75]% degrees farhenite. this is also an invalid output %s:{A-Z}[6-9]% This is also a file input that is invalid //I:[9,10]//. " +
                        "And also look at %s:[6-3][A-C]% and also it is %i:[A-Z]%");
        fileWrite.ArrayToFile(o, "testReader.txt");

        FileFormatting file = new FileFormatting();
        FileRead fileRead = new FileRead();
        FileWrite fileWrite = new FileWrite();
        ArrayList<String> str = fileRead.fileToArray("testReader.txt");
        ArrayList<String> str2 = file.formattedArray(str);
        fileWrite.ArrayToFile(str2,"outputTestWritingToFile.txt");
        assertEquals(read("output.txt"), read("output.txt"));

    }
    private String read(String fileName) {
        String data = "";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}