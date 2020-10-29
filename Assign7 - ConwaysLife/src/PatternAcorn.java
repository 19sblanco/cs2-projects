public class PatternAcorn extends Pattern {
    private boolean data[][] = {
            {false, true, false, false, false, false, false},
            {false, false, false, true, false, false, false},
            {true, true, false, false, true, true, true}
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
