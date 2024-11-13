package org.example;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals("02", Main.add("01", "01"));
        assertEquals("241", Main.add("57", "76"));
        assertEquals("682", Main.add("432", "25"));
        assertEquals("0001", Main.add("999", "1"));
        assertEquals("0", Main.add("0", "0"), "Adding 0 + 0 should equal 0");
        assertEquals("123", Main.add("123", "0"), "Adding 321 + 0 should equal 321");
        assertEquals("456", Main.add("0", "456"), "Adding 0 + 654 should equal 654");
        assertEquals("0111111111", Main.add("9876543210", "123456789"), "Adding large numbers in reverse order should be correct");
        assertEquals("0111", Main.add("555", "555"), "Adding 555 + 555 should equal 1110");
        assertEquals("061", Main.add("89", "26"), "Adding 98 + 62 should equal 160");
        assertEquals("21", Main.add("5", "7"), "Adding 5 + 7 should equal 12");
        assertEquals("01", Main.add("9", "1"), "Adding 9 + 1 should equal 10");
    }

    @org.junit.jupiter.api.Test
    void sub() {
        assertEquals("0", Main.sub("0", "0"), "Subtracting 0 - 0 should equal 0");
        assertEquals("5", Main.sub("23", "72"), "Subtracting 32 - 27 should equal 5");
        assertEquals("999", Main.sub("0001", "1"), "Subtracting 1000 - 1 should equal 999");
        assertEquals("11", Main.sub("12", "01"));
        assertEquals("57", Main.sub("001", "52"));
        assertEquals("778", Main.sub("0001", "321"));
        assertEquals("0", Main.sub("05", "05"));
        assertEquals("001", Main.sub("501", "5"));
        assertEquals("11121", Main.sub("54321", "432"));
        assertEquals("1", Main.sub("000001", "99999"));
    }

    void helperMultiply(String s1, String s2) {
        BigInteger a = new BigInteger(s1);
        BigInteger b = new BigInteger(s2);

        String actual = Main.multiply(s1, s2);
        String expected = a.multiply(b).toString();

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        helperMultiply("1818889289", "98982");
        helperMultiply("0", "0");
        helperMultiply("1717", "15288");
        helperMultiply("89758957957897589589758975897589", "8942892498489489489489428");
        helperMultiply("8888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888",
                "1789897297987897987198789179178978917981789178978978971897981789728728973987978178799829737178971878971981798179878");

        helperMultiply("3141592653589793238462643383279502884197169399375105820974944592", "2718281828459045235360287471352662497757247093699959574966967627");
        helperMultiply("151515", "151515");
    }
}