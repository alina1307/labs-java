
package lab2;

import org.junit.Test;
import static org.junit.Assert.*;


public class RegualExpressionsTest {
    
    public RegualExpressionsTest() {
    }
    
    @Test
    public void testCheckString() {
        RegualExpressions instance = new RegualExpressions();
        Boolean result = instance.CheckString("str");
        assertEquals(false, result);  
        
        result = instance.CheckString("abcdefghijklmnopqrstuv18340");
        assertEquals(true, result);  
}
}