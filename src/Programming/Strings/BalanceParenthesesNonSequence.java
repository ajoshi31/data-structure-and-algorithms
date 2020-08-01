package Programming.Strings;

import java.util.HashMap;
import java.util.Map;

public class BalanceParenthesesNonSequence {

    public static void main(String args[]) {
        String string = "[(])";
        balanceUtil(string);
    }

    private static void balanceUtil(String input) {
        Map<String, Integer> myMap = new HashMap<>();
        int length = input.length();
        boolean flag = true;
        for (int i = 0; i < length && flag; i++) {
            String charString = String.valueOf(input.charAt(i));
            switch (charString) {
                case "{":
                    flag = mapMaintainer(myMap, "{", i);
                    break;
                case "}":
                    flag = mapMaintainer(myMap, "}", i);
                    break;
                case "(":
                    flag = mapMaintainer(myMap, "(", i);
                    break;
                case ")":
                    flag = mapMaintainer(myMap, ")", i);
                    break;
                case "[":
                    flag = mapMaintainer(myMap, "[", i);
                    break;
                case "]":
                    flag = mapMaintainer(myMap, "]", i);
                    break;
            }
        }

        if (flag) {
            for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
                if (entry.getValue() != 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("RIGHT");
        } else {
            System.out.println("WRONG");
        }
    }

    private static boolean mapMaintainer(Map<String, Integer> myMap, String charString, int i) {
        int value = 1;
        String initialCharVal = charString;
        switch (charString) {
            case "}":
                charString = "{";
                value = -1;
                break;
            case "]":
                charString = "[";
                value = -1;
                break;
            case ")":
                charString = "(";
                value = -1;
                break;
        }
        if (!myMap.containsKey(String.valueOf(charString))) {
            if (initialCharVal.equals("}") || initialCharVal.equals(")") || initialCharVal.equals("]")) {
                return false;
            }
            myMap.put(charString, value);
        } else {
            if (initialCharVal.equals("}") || initialCharVal.equals(")") || initialCharVal.equals("]")) {
                if (myMap.get(charString) == 0) {
                    return false;
                }
            }
            myMap.put(charString, myMap.get(charString) + value);
        }
        return true;
    }
}
