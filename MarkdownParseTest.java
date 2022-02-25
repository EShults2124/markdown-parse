import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(1, 1 + 0);
    }

    @Test
    public void testSnippet1() throws IOException {

        String testingFile = "SnippetOne.md";

        Path fileName = Path.of(testingFile);
        String contents = Files.readString(fileName);
        ArrayList<String> validLinks = MarkdownParse.getLinks(contents);

        ArrayList<String> test = new ArrayList<>();
        test.add("`google.com");
        test.add("google.com");
        test.add("ucsd.edu");

        assertTrue(test.equals(validLinks));

    }

    @Test
    public void testSnippet2() throws IOException {

        String testingFile = "SnippetTwo.md";

        Path fileName = Path.of(testingFile);
        String contents = Files.readString(fileName);
        ArrayList<String> validLinks = MarkdownParse.getLinks(contents);

        ArrayList<String> test = new ArrayList<>();
        test.add("a.com");
        test.add("a.com(())");
        test.add("example.com");

        assertTrue(test.equals(validLinks));

    }

    @Test
    public void testSnippet2() throws IOException {

        String testingFile = "SnippetThree.md";

        Path fileName = Path.of(testingFile);
        String contents = Files.readString(fileName);
        ArrayList<String> validLinks = MarkdownParse.getLinks(contents);

        ArrayList<String> test = new ArrayList<>();
        test.add("https://ucsd-cse15l-w22.github.io/");

        assertTrue(test.equals(validLinks));

    }

    /*
     * @Test
     * public void inBetween() throws IOException {
     * 
     * String[] test1 = { "hi.com", "hi.com" };
     * String[] args = { "InBetween.md" };
     * 
     * Path fileName = Path.of("InfiniteLoop.md");
     * String contents = Files.readString(fileName);
     * ArrayList<String> links = MarkdownParse.getLinks(contents);
     * 
     * boolean error = false;
     * 
     * for (int i = 0; i < test1.length; i++) {
     * if (test1[i] != links.get(i)) {
     * error = true;
     * break;
     * }
     * }
     * https://github.com/austin-li/CSE15L-TheLunaMoths.git
     * assertFalse(error);
     * 
     * }
     */
}
