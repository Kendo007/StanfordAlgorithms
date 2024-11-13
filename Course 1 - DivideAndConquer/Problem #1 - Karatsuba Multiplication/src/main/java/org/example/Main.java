package org.example;

public class Main {
    /**
     * Add two numbers represented as reversed strings
     * e.g. "001" + "5" = "501"
     */
    public static String add(String s1, String s2) {
        if (s2.length() > s1.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0, i;

        for (i = 0; i < s2.length(); ++i) {
            int r = carry + (s1.charAt(i) - 48) + (s2.charAt(i) - 48);
            result.append(r % 10);
            carry = r / 10;
        }

        while (carry != 0) {
            if (i >= s1.length()) {
                result.append(carry);
                break;
            }

            int r = carry + (s1.charAt(i) - 48);
            result.append(r % 10);
            carry = r / 10;

            ++i;
        }

        while (i < s1.length()) {
            result.append(s1.charAt(i));
            ++i;
        }

        return result.toString();
    }

    /**
     * Subtract two numbers represented as reversed strings
     * e.g. "501" - "5" = "001"
     */
    public static String sub(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        char[] s1Array = s1.toCharArray();

        for (; i < s2.length(); ++i) {
            int r = (s1Array[i] - 48) - (s2.charAt(i) - 48);

            if (r < 0) {
                int j = i + 1;

                while (s1Array[j] == '0') {
                    s1Array[j] = '9';
                    ++j;
                }

                s1Array[j] = (char) (s1Array[j] - 1);
                r += 10;
            }

            result.append(r);
        }

        while (i < s1.length()) {
            result.append(s1Array[i]);
            ++i;
        }

        // remove leading zeros
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    private static String multiplyHelper(String s1, String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if (lenS1 == 1 && lenS2 == 1) {
            int r =  Integer.parseInt(s1, 10) * Integer.parseInt(s2, 10);

            return Integer.toString(r % 10) + (r / 10);
        }

        if (lenS1 < lenS2) {
            s1 = s1.concat("0".repeat(lenS2 - lenS1));
            lenS1 = s1.length();
        }

        if (lenS2 < lenS1) {
            s2 = s2.concat("0".repeat(lenS1 - lenS2));
        }

        int n = lenS1 / 2;

        String a = s1.substring(n);
        String b = s1.substring(0, n);
        String c = s2.substring(n);
        String d = s2.substring(0, n);

        String ac = multiplyHelper(a, c);
        String bd = multiplyHelper(b, d);
        String abcd = multiplyHelper(add(a, b), add(c, d));

        return add(add("0".repeat(2 * n) + ac, bd), "0".repeat(n) + sub(abcd, add(ac, bd)));
    }

    public static String multiply(String s1, String s2) {
        String ans = multiplyHelper(new StringBuilder(s1).reverse().toString(),
                new StringBuilder(s2).reverse().toString());

        StringBuilder sb = new StringBuilder();
        int i = ans.length() - 1;

        while (ans.charAt(i) == '0' && i > 0) {
            --i;
        }

        for ( ; i >= 0; --i) {
            sb.append(ans.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("89758957957897589589758975897589", "8942892498489489489489428"));
    }
}