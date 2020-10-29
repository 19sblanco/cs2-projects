public class PatternBlock extends Pattern {
    private boolean data[][] = {
            {true, true},
            {true, true},
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
