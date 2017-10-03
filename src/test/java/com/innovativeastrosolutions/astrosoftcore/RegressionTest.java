package com.innovativeastrosolutions.astrosoftcore;

import com.innovativeastrosolutions.astrosoftcore.core.*;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Rajasekar Elango
 */
public class RegressionTest{

    private static final String TEST_DATA_PATH="/testData/";

    @Test
    public void testHoroscope() throws Exception{
        String actual = Horoscope.runTests();

        String expected = readFile(TEST_DATA_PATH + "HoroscopeExpected.txt");
        validate("Horoscope " , expected,actual);
    }

    @Test
    public void testCompatibility() throws Exception{
        String actual = Compactibility.runTests();
        String expected = readFile(TEST_DATA_PATH + "CompactibilityExpected.txt");
        validate("Compactibility " , expected,actual);
    }

    @Test
    public void testPanchang() throws Exception{
        String actual = Panchang.runTests();
        String expected = readFile(TEST_DATA_PATH + "PanchangExpected.txt");
        validate("Panchang " , expected,actual);

    }

    @Test
    public void testPanchangList() throws Exception{
        String actual = PanchangList.runTests();
        String expected = readFile(TEST_DATA_PATH + "PanchangListExpected.txt");
        validate("Panchang List " , expected,actual);

    }

    @Test
    public void testEpehemris() throws Exception{

        String actual = Ephemeris.runTests();
        String expected = readFile(TEST_DATA_PATH + "EphemerisExpected.txt");
        validate("Ephemeris " , expected,actual);

    }

    private void validate(String test, String expected, String actual){
        String actualResult = actual.substring(actual.indexOf("RESULT")).replaceAll("\\p{Space}","");
        String expectedResult = expected.replaceAll("\\p{Space}","");
        StringBuilder message = new StringBuilder(test + " : "  + "FAIL").append("\n");
        message.append("Actual :").append("\n").append(actual).append("\n");
        message.append("Expected :").append("\n").append(expected).append("\n");
        Assert.assertEquals(message.toString(), expectedResult, actualResult);
        System.out.println(test + " : " + "OK");
       /* if(expectedResult.equals(actualResult)){
            System.out.println(test + " : " + "OK");
        }else{
            System.out.println(test + " : "  + "FAIL");
            System.out.println("Actual :");
            System.out.println(actual);
            System.out.println("\n");
            System.out.println("Expected :");
            System.out.println(expected);
        }
        System.out.println();*/
     }
    public String readFile(String filePath) throws Exception{
        Path path = Paths.get(RegressionTest.class.getResource(filePath).toURI());
        return new String(Files.readAllBytes(path));
    }
}
