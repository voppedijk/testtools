package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitToHexTest {

    @Test
    public void canCreateHexWithMultipleOfFour() {
        assertEquals("0xF", BitToHex.ParseBitToHex(4));
        assertEquals("0xFF", BitToHex.ParseBitToHex(8));
        assertEquals("0xFFF", BitToHex.ParseBitToHex(12));
        assertEquals("0xFFFF", BitToHex.ParseBitToHex(16));
        assertEquals("0xFFFFF", BitToHex.ParseBitToHex(20));
        assertEquals("0xFFFFFF", BitToHex.ParseBitToHex(24));
        assertEquals("0xFFFFFFF", BitToHex.ParseBitToHex(28));
        assertEquals("0xFFFFFFFF", BitToHex.ParseBitToHex(32));
        assertEquals("0xFFFFFFFFF", BitToHex.ParseBitToHex(36));
        assertEquals("0xFFFFFFFFFFFFFFFF", BitToHex.ParseBitToHex(64));
    }

    @Test
    public void canCreateHex() {
        assertEquals("0x1", BitToHex.ParseBitToHex(1));
        assertEquals("0x3", BitToHex.ParseBitToHex(2));
        assertEquals("0x7", BitToHex.ParseBitToHex(3));
        assertEquals("0x1F", BitToHex.ParseBitToHex(5));
        assertEquals("0x3F", BitToHex.ParseBitToHex(6));
        assertEquals("0x7F", BitToHex.ParseBitToHex(7));
        assertEquals("0x1FF", BitToHex.ParseBitToHex(9));
        assertEquals("0x3FF", BitToHex.ParseBitToHex(10));
        assertEquals("0x7FF", BitToHex.ParseBitToHex(11));
        assertEquals("0x1FFF", BitToHex.ParseBitToHex(13));
        assertEquals("0x3FFF", BitToHex.ParseBitToHex(14));
        assertEquals("0x7FFF", BitToHex.ParseBitToHex(15));
    }

}