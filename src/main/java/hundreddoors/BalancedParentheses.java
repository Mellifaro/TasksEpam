package hundreddoors;

import java.util.*;
import java.util.stream.Collectors;

public class BalancedParentheses {
    private static final Map<Character, Character> characterMap = new HashMap<Character, Character>(){{
        put('[', ']');
        put('(', ')');
        put('{', '}');
    }};
    private static final Set<Character> openBrackets = new HashSet<Character>(){{
        add('[');
        add('(');
        add('{');
    }};
    private static final Set<Character> closedBrackets = new HashSet<Character>(){{
        add(']');
        add(')');
        add('}');
    }};

    public static void main(String[] args) {
        System.out.println(isParenthesesValid("[[{256+(-65)}]]"));
    }

    public static boolean isParenthesesValid(String testString){
        Stack<Character> stack = new Stack<>();
        List<Character> chars = testString.chars().mapToObj(c -> (char)c).collect(Collectors.toList());

        for(Character character: chars){
            if(openBrackets.contains(character)){
                stack.push(character);
            }
            else if(closedBrackets.contains(character)){
                if (stack.isEmpty()){
                    return false;
                }
                Character openedBracket = stack.peek();
                if(characterMap.get(openedBracket).equals(character)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
