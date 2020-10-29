public class PatternBlinker extends Pattern {
    private boolean data[][] = {
            {false, true, false},
            {false, true, false},
            {false, true, false},
    };

    @Override
    public int getSizeX() {
        return data[0].length;
    }

    @Override
    public int getSizeY() {
        return data.length;
    }

    @Override
    public boolean getCell(int x, int y) {
        return data[y][x];
    }
}
