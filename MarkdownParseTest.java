import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path fileName = Path.of("my-test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https://something.com", "some-thing.html");

        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks1() throws IOException {
        Path fileName = Path.of("new.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https://something.com");

        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https://something.com", "some-page.html");

        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        boolean empty = links.isEmpty();

        assertEquals(true, empty);
    }


    @Test
    public void testGetLinks4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        boolean empty = links.isEmpty();

        assertEquals(true, empty);
    }

    @Test
    public void testGetLinks5() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("page.com");

        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks6() throws IOException {
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("page.com");

        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks7() throws IOException {
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        boolean empty = links.isEmpty();

        assertEquals(true, empty);
    }

    @Test
    public void testGetLinks8() throws IOException {
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        boolean empty = links.isEmpty();

        assertEquals(false, empty);
    }

    @Test
    public void testGetLinks9() throws IOException {
        Path fileName = Path.of("test1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("'google.com");

        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks10() throws IOException {
        Path fileName = Path.of("test2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("a.com", "a.com(())", "example.com"
        );

        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks11() throws IOException {
        Path fileName = Path.of("test3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule"
        );

        assertEquals(expected, links);
    }
}
