package utility;

public class BitToHex {

    public static String ParseBitToHex(int bit) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder("0x");

        while (bit > 0) {
            sb.append("1");
            bit -= 1;
        }

        while (sb.length() >= 4) {
            result.append("F");
            sb.delete(sb.length() - 4, sb.length());
        }

        while (sb.length() >= 3) {
            result.insert(2, "7");
            sb.delete(sb.length() - 3, sb.length());
        }

        while (sb.length() >= 2) {
            result.insert(2, "3");
            sb.delete(sb.length() - 2, sb.length());
        }

        while (sb.length() >= 1) {
            result.insert(2, "1");
            sb.delete(sb.length() - 1, sb.length());
        }

        return result.toString();
    }
}
