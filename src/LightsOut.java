public class LightsOut {

    public long state;
    public int rows, cols;

    public LightsOut(int cols, int rows, long state, long mask) {
        long stateTmp = (BitOps.clear(state, (int) mask)) << (64 - (rows * cols)) >>> (64 - (rows * cols));
        this.state = stateTmp;
        this.rows = rows;
        this.cols = cols;
    }

    public long getState() {
        return state;
    }

    public void toggle(int col, int row) {
        long changeMask = 0;
        int position = ((row - 1) * row) + (col - 1);
        for (int i = cols * rows; i > 0; i--) {
            if (i == position) {
                if (0 == (i - 1) % cols || 0 == i % cols) {
                    changeMask <<= 2;
                    changeMask |= 0b11;
                    i--;
                } else {
                    changeMask <<= 3;
                    changeMask |= 0b111;
                    i -= 2;
                }
            } else if (i == position - (col - 1) || i == position + (col - 1)) {
                changeMask <<= 1;
                changeMask |= 0b1;
            } else {
                changeMask <<= 1;
            }
        }
        this.state = BitOps.flip (state, (int) changeMask);
    }
}
