public class LightsOut {

    LightsOut (int cols, int  rows, long state, long mask) {
        state = BitOps.clear(state, (int) mask);
    }
}
