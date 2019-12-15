public class BitOps {
    public static long set (long bitSet, int bitIndex) {
        long mask = 1;
        for (int i = 0; i < bitIndex; i++) {
            mask <<= 1;
        }
        return (bitSet | mask);
    }

    public static boolean isSet (long bitSet, int bitIndex) {
        long mask = 1;
        for (int i = 0; i < bitIndex; i++) {
            mask <<= 1;
        }
        bitSet = bitSet & mask;
        if (bitSet == mask) {
            return true;
        } else {
            return false;
        }
    }

    public static long clear (long bitSet, int bitIndex) {
        return flip(-1, bitIndex) & bitSet;
    }

    public static long flip (long bitSet, int bitIndex) {
        long mask = 1;
        for (int i = 0; i < bitIndex; i++) {
            mask <<= 1;
        }
        return (bitSet ^ mask);
    }

    public ZahlenFolgenMerker solve() {
        return null;
    }
}
