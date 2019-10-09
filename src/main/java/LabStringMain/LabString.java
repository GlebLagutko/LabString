package LabStringMain;


public class LabString {
    public static void main(String[] args) {
        checkArgs(args);
        printArgs(args);
        StringBuilder substring = findMaxSubstring(args[0], args[1]);
        System.out.printf(substring.toString());
    }

    protected static StringBuilder findMaxSubstring(String arg1, String arg2) {
        StringBuilder str1 = new StringBuilder(arg1);
        StringBuilder str2 = new StringBuilder(arg2);
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

    protected static StringBuilder findSubstring(StringBuilder str1, StringBuilder str2, int i, int j) {
        int sizeCurrent = 1;
        StringBuilder str = new StringBuilder();
        str.append(str1.charAt(i));
        for (int k = i + 1; k < str1.length(); k++) {
            if (j + sizeCurrent >= str2.length())
                break;
            if (str1.charAt(k) != str2.charAt(j + sizeCurrent))
                break;
            str.append(str1.charAt(k));
            sizeCurrent++;
        }
        return str;
    }

    protected static void printArgs(String[] args) {
        for (int i = 0; i < args.length; ++i)
            System.out.println("N " + i + " = " + args[i]);
    }

    private static void checkArgs(String[] args) {
        if (args.length != 2)
            throw new RuntimeException("Wrong argument count ");
    }
}
