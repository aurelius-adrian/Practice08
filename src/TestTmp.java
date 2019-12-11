import java.util.Scanner;

public class TestTmp {

    //@Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter total number of Columns:");
        int cols = scanner.nextInt();
        System.out.println("Enter total number of Rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter State:");
        int state = scanner.nextInt();
        System.out.println("Enter Mask:");
        int mask = scanner.nextInt();

        LightsOut lightsOut = new LightsOut(cols, rows, state, mask);

        while (true) {
            System.out.println("Enter Column:");
            int col = scanner.nextInt();
            System.out.println("Enter Row:");
            int row = scanner.nextInt();

            lightsOut.toggle(col, row);
            String bitString = Long.toBinaryString(lightsOut.getState()), tmp = "";
            int tmpSL = bitString.length();

            for (int i = 0; i <= ((cols * rows) - tmpSL); i++) {
                bitString = "0" + bitString;
            }

            for (int i = (cols * rows) - 1; i >= 0; i--) {
                switch (bitString.charAt(i)) {
                    case '0':
                        tmp += "0 |";
                    case '1':
                        tmp += "1 |";
                    default:
                        if ((i + 1) % cols == 0) {
                            System.out.println(tmp);
                            System.out.println("\n");
                            tmp = "";
                        }
                }
            }
        }
    }
}