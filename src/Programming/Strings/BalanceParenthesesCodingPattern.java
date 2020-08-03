package Programming.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceParenthesesCodingPattern {

    public static void main(String args[]) {
        String string = "{}[]";
        boolean valueRes = balanceUtil(string);

        if (valueRes) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    private static boolean balanceUtil(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            char pop;
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;

            switch (x) {
                case '}':
                    if (stack.pop() != '{')
                        return false;
                    break;

                case ']':
                    if (stack.pop() != '[')
                        return false;
                    break;

                case ')':
                    if (stack.pop() != '(')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}
