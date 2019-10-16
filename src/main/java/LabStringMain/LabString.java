package LabStringMain;

import java.util.StringTokenizer;

public class LabString {

    public static void main(String[] args) {
        checkArgs(args);
        StringBuilder[] strings = parseString(args[0]);
        checkArgs(strings);
        printArgs(strings);
        StringBuilder substring = findMaxSubstring(strings[0], strings[1]);
        System.out.printf("MaxSubstring: " + substring.toString());
    }


    protected static StringBuilder findMaxSubstring(StringBuilder str1, StringBuilder str2) {
        int maxSize = 0;
        StringBuilder substring = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    StringBuilder currentSubstring = findSubstring(str1, str2, i, j);
                    if (currentSubstring.length() > maxSize) {
                        substring = currentSubstring;
                        maxSize = currentSubstring.length();
                    }
                }
            }
        }
        return substring;
    }

    protected static StringBuilder[] parseString(String arg) {
        StringTokenizer stringTokenizer = new StringTokenizer(arg, " ");
        StringBuilder[] answer = new StringBuilder[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            answer[i] = new StringBuilder(stringTokenizer.nextToken());
            i++;
        }
        return answer;
    }

    protected static StringBuilder findSubstring(StringBuilder str1, StringBuilder str2, int startFirstPos, int startSecondPos) {
        StringBuilder str = new StringBuilder();
        str.append(str1.charAt(startFirstPos));
        int sizeCurrent = 1;
        for (int k = startFirstPos + 1; k < str1.length(); k++) {
            if (startSecondPos + sizeCurrent >= str2.length())
                break;
            if (str1.charAt(k) != str2.charAt(startSecondPos + sizeCurrent))
                break;
            str.append(str1.charAt(k));
            sizeCurrent++;
        }
        return str;
    }

    protected static void printArgs(StringBuilder[] args) {
        for (int i = 0; i < args.length; ++i)
            System.out.println("N " + i + " = " + args[i]);
    }

    private static void checkArgs(StringBuilder[] args) {
        if (args.length != 2)
            throw new RuntimeException("Wrong argument count ");
    }

    private static void checkArgs(String[] args) {
        if (args.length != 1)
            throw new RuntimeException("Wrong argument count ");
    }
}
