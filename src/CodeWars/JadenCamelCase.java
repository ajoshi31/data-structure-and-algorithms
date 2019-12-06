package CodeWars;

/**
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
 * Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter,
 * he is known for almost always capitalizing every word. For simplicity, you'll have to capitalize each word,
 * check out how contractions are expected to be in the example below.
 * <p>
 * Your task is to convert strings to how they would be written by Jaden Smith.
 * The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.
 * <p>
 * Example:
 * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 * Note that the Java version expects a return value of null for an empty string or null.
 * <p>
 * Link to Jaden's former Twitter account @officialjaden via archive.org
 */

public class JadenCamelCase {

    public static void main(String arg[]) {

        String myStr = "most trees are blue[]";
        System.out.println("Input String:  " + myStr);
        toJadenCase(myStr);

    }

    private static void toJadenCase(String phrase) {


        if (phrase == null) {
            return;
        }
        if (phrase.length() == 0) {
            return;
        }
        String words[] = phrase.split("\\s");
        StringBuilder capitalizedWord = new StringBuilder();
        for (String w : words) {
            String first = w.substring(0, 1);
            String f_after = w.substring(1);
            capitalizedWord.append(first.toUpperCase()).append(f_after).append(" ");
        }
        String singleString = capitalizedWord.toString().trim();
        System.out.println("Output String:  0" + singleString + "0");
    }
}
