package scope.function;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String returnsTrue = "function () {}"; //will return true;
        String returnsFalse = "function () {;"; //will return false;
        String forFunzos = "[()]{}{[()()]()}"; //will return true;
        //
        boolean outcome = isBalanced(returnsTrue);
        boolean outcome2 = isBalanced(returnsFalse);
        boolean outcome3 = isBalanced(forFunzos);
        //
        System.out.println(outcome);
        System.out.println(outcome2);
        System.out.println(outcome3);
    }

    public static boolean isBalanced(String input)
    {
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put('(', ')');
        bracketPairs.put('{', '}');
        bracketPairs.put('[', ']');
        bracketPairs.put('<', '>');

        Stack<Character> brackets = new Stack<Character>();
        
        try {
            for (char value: input.toCharArray()) {
                if (bracketPairs.containsKey(value)){
                    brackets.push(value);
                }
                else {
                    if (bracketPairs.containsValue(value)){
                        if(value == bracketPairs.get(brackets.peek()))
                        {
                            brackets.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        continue;
                    }
                }
            }
        } catch (Exception e)
        {
            return false;
        }
        //
        return brackets.size() == 0;
    };
}
