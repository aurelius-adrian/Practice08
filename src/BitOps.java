public class BitOps {
    public static long set (long bitSet, int bitIndex) {
        return (bitSet | bitIndex);
    }

    public static boolean isSet (long bitSet, int bitIndex) {
        bitSet = bitSet & bitIndex;
        if (bitSet == bitIndex) {
            return true;
        } else {
            return false;
        }
    }

    public static long clear (long bitSet, int bitIndex) {
        return flip(bitIndex, -1) & bitSet;
    }

    public static long flip (long bitSet, int bitIndex) {
        return (bitSet ^ bitIndex);
    }
}
