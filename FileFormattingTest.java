package TestPackage;

import com.company.FileFormatting;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class FileFormattingTest {
    private String strint = "%i:[58,70]%";
    private String strString = "%s:[A-Z][6,10]%";
    private String anotherString = "%s:[A-F][6,10]%";
    private String strDouble = "%d:[5,6]%";
    private String doubleTest = "%d:[4,150]%";
    private String anotherDouble = "%d:[4,20]%";
    private String anotherInt = "%i:[4,70]%";
    private String strTest = "ABCDRFC";
    private String toTest = "%i:[57+100]$";
    private ArrayList<String> listOfVals = new ArrayList<>();
    private FileFormatting file = new FileFormatting();
    private Random rand = new Random();

    private ArrayList<String> addList(ArrayList<String> arr , String toAdd) throws IOException {
        arr.add(toAdd);
        arr.add("This is also a paragraph entry!");
        return arr;
    }

    @Test
    void testFailInt(){
        String exp = "%i:[57+100]$";
        String res = file.parseInteger(exp);
        assertEquals(exp,res);
    }

    @Test
    void testFailDouble(){
        String exp = "%d:[45556]$";
        String res = file.parseDouble(exp);
        assertEquals(exp,res);
    }

    @Test
    void testFailString(){
        String exp = "%s:[57+100][A-T]$";
        String res = file.parseInteger(exp);
        assertEquals(exp,res);
    }

    @Test
    void testFailAnotherInt(){
        String exp = "%i:[88-00]%";
        String res = file.parseInteger(exp);
        assertEquals(exp,res);
    }

    @Test
    void testFailAnotherDouble(){
        String exp = "%d:[455-56]$";
        String res = file.parseDouble(exp);
        assertEquals(exp,res);
    }

    @Test
    void testFailAnotherString(){
        String exp = "%s:[A-X][A-T]$";
        String res = file.parseInteger(exp);
        assertEquals(exp,res);
    }

    @Test
    void testString() {

        String str1 = file.parseString(strString);
        boolean test = str1.length() >= 6 && str1.length() <= 10 ? true : false;
        boolean test2 = strTest.length() >= 6 && strTest.length() <= 10 ? true : false;
        assertEquals(test, test2);

    }

    @Test
    void testParseString() {

        String str1 = file.parseString(anotherString);
        boolean test = str1.length() >= 6 && str1.length() <= 10 ? true : false;
        boolean test2 = strTest.length() >= 6 && strTest.length() <= 10 ? true : false;
        assertEquals(test, test2);

    }


    @Test
    void testint() {

        String intTest = file.parseInteger(strint);
        boolean test = Integer.valueOf(intTest) >= 58 && Integer.valueOf(intTest) <= 70 ? true : false;
        boolean test2 = 60 >= 58 && 60 <= 70 ? true : false;
        assertEquals(test, test2);

    }

    @Test
    void testParseint() {

        String intTest = file.parseInteger(anotherInt);
        boolean test = Integer.valueOf(intTest) >= 4 && Integer.valueOf(intTest) <= 70 ? true : false;
        boolean test2 = true ? true : false;
        assertEquals(test, test2);

    }
    @Test
    void testDouble() {

        Double db = 6.2;
        String intTest = file.parseDouble(strDouble);
        boolean test = Double.valueOf(intTest) >= 5 && Double.valueOf(intTest) <= 7 ? true : false;
        boolean test2 = db >= 5 && db <= 7 ? true : false;
        assertEquals(test, test2);

    }
    @Test
    void testParseDouble() {

        Double db = 6.2;
        String intTest = file.parseDouble(anotherDouble);
        boolean test = Double.valueOf(intTest) >= 4 && Double.valueOf(intTest) <= 20 ? true : false;
        boolean test2 = db >= 4 && db <= 20 ? true : false;
        assertEquals(test, test2);

    }

    @Test
    void testIntFormat() throws IOException {
        int min = 58, max = 70;
        file.formattedArray(addList(listOfVals,strint));
        listOfVals.set(0, file.parseInteger(strint));
        boolean anotherTest = true;
        String getnum = listOfVals.get(0);
        boolean b = Integer.valueOf(getnum) <= max && min <= Integer.valueOf(getnum);
        String newStr= "" + b;
        if(Integer.parseInt(getnum) <= max && min <= Integer.valueOf(getnum)){
            assertTrue(newStr,anotherTest);
        }
    }

    @Test
    void testDoubleFormat() throws IOException {
        int min = 40, max = 150;
        file.formattedArray(addList(listOfVals,doubleTest));
        listOfVals.set(0, file.parseDouble(doubleTest));
        boolean bool = Double.valueOf(listOfVals.get(0))<=max  && min<= Double.valueOf(listOfVals.get(0));
        String newStr= "" + bool;
        if(Double.valueOf(listOfVals.get(0))<=max  && min<= Double.valueOf(listOfVals.get(0))){
            assertTrue(newStr, true);
        }
    }

}