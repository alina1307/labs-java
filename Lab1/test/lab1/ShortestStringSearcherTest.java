package lab1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShortestStringSearcherTest {

    @Test
    public void testShortestLine() {
        ShortestStringSearcher instance = new ShortestStringSearcher();
        String[] curStr = {"dgshgf","ch"};
        String result = instance.ShortestLine(curStr);
        assertEquals("ch", result);
    } 
}
