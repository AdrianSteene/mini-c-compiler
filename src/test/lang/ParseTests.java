package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
    /** Directory where the test input files are stored. */
    private static final File TEST_DIRECTORY = new File("testfiles/parser");

    @Test
    public void example() {
        Util.testValidSyntax(TEST_DIRECTORY, "example.in");
    }

    @Test
    public void example1() {
        Util.testValidSyntax(TEST_DIRECTORY, "example1.in");
    }

    @Test
    public void example2() {
        Util.testValidSyntax(TEST_DIRECTORY, "example2.in");
    }

    @Test
    public void example3() {
        Util.testValidSyntax(TEST_DIRECTORY, "example3.in");
    }

    @Test
    public void example4() {
        Util.testValidSyntax(TEST_DIRECTORY, "example4.in");
    }

    @Test
    public void example5() {
        Util.testValidSyntax(TEST_DIRECTORY, "example5.in");
    }

    @Test
    public void example6() {
        Util.testValidSyntax(TEST_DIRECTORY, "example6.in");
    }

    @Test
    public void example7() {
        Util.testValidSyntax(TEST_DIRECTORY, "example7.in");
    }
    @Test
    public void example8() {
        Util.testValidSyntax(TEST_DIRECTORY, "example8.in");
    }

    @Test
    public void error() {
        Util.testSyntaxError(TEST_DIRECTORY, "error.in");
    }
}
