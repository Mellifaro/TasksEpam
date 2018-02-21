package hundreddoors;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class BalancedParenthesesTest {

    @Test
    public void testBalanced(){
        List<String> strings = new ArrayList<String>(){{
            add("()");
            add("{3+{}-2[]}+8*{}");
        }};

        strings.forEach(string -> {
            assertTrue(BalancedParentheses.isParenthesesValid(string));
        });
    }

    @Test(expected = AssertionError.class)
    public void testNotBalanced(){
        List<String> strings = new ArrayList<String>(){{
            add("(");
            add("]");
            add("+56]");
            add("{3+{[}]-2[]}+{{8*{}");
        }};

        strings.forEach(string -> {
            assertTrue(BalancedParentheses.isParenthesesValid(string));
        });
    }
}
