package TestPackage;

import com.company.FileRead;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileReadTest {
    private String input ="input.txt";
    private String inputFile = "filename.txt";

    private void writeToFile(String fileName , String msg) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(msg);
            myWriter.close();
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
private ArrayList<String> fileToArr(String fileName) throws FileNotFoundException {
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
    @Test
    void fileToArray() throws IOException {
        writeToFile("TestFile", " This is the second test, %i:[7,10]%. it also goes without saying, good bye!");
        FileRead file = new FileRead();
        ArrayList<String> strFile =  file.fileToArray("TestFile");
        ArrayList<String> filOfStr = fileToArr("TestFile");
        assertEquals(strFile,filOfStr);
    }

    @Test
    void fileTo() throws IOException {
        writeToFile("toTestFile", " This is the second test, %i:[7,10]%. it also goes without saying, good bye!");

        FileRead file = new FileRead();
        ArrayList<String> strFile =  file.fileToArray("toTestFile");
        ArrayList<String> filOfStr = fileToArr("toTestFile");
        assertEquals(strFile,filOfStr);
    }

    @Test
    void fill() throws IOException {
        FileRead file = new FileRead();
        writeToFile("FileIn", "Hello my name is %s:[A-P][8,10]% and i am %i:[8,16]% years old.\n" +
                "I love going out to play especially %{A-G}[8,123]% when the weather is %d:[60,75]% degrees farhenite.\n" +
                " this is also an invalid output %s:{A-Z}[6-9]%");
        ArrayList<String> strFile =  file.fileToArray("FileIn");
        ArrayList<String> filOfStr = fileToArr("FileIn");
        assertEquals(strFile,filOfStr);
    }




}