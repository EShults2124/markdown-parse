import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(1, 1 + 0);
    }

    @Test
    public void inBetween() throws IOException {

        String[] test1 = { "hi.com", "hi.com" };
        String[] args = { "InBetween.md" };
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        boolean error = false;

        for (int i = 0; i < test1.length; i++) {
            if (test1[i] != links.get(i)) {
                error = true;
                break;
            }
        }

        assertFalse(error);

    }

}
