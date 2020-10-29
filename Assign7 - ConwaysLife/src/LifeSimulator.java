public class LifeSimulator {
    private int sizeX;
    private int sizeY;
    boolean[][] grid;


    public LifeSimulator(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.grid = new boolean[sizeY][sizeX];
    }

    public int getSizeX() { return this.sizeX; }
    public int getSizeY() { return this.sizeY; }
    public boolean getCell(int x, int y) { return grid[y][x]; }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        for (int gridX = 0; gridX < this.getSizeX(); gridX++) {
            for (int gridY = 0; gridY < this.getSizeY(); gridY++) {

                for (int patternX = 0; patternX < pattern.getSizeX(); patternX++) {
                    for (int yCoordinate = 0; yCoordinate < pattern.getSizeY(); yCoordinate++) {

                        grid[yCoordinate + startY][patternX + startX] = pattern.getCell(patternX, yCoordinate);
                    }
                }
            }
        }
    }
    /*
    Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    Any live cell with two or three live neighbours lives on to the next generation.
    Any live cell with more than three live neighbours dies, as if by overpopulation.
    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     */

    public void update() {
        boolean[][] updated = new boolean[this.sizeY][this.sizeX];
        // loop through every cell
        for (int row = 0; row < sizeX - 1; row++) {
            for (int col = 0; col < sizeY - 1; col++) {

                int aliveNeighbors = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if ((col + i >= 0) && (col + i < this.grid[0].length) && (row + j >= 0) && (row + j < this.grid.length)) {
                            if ((this.grid[col + i][row + j]) && (i != 0 || j != 0)) {
                                aliveNeighbors++;
                            }
                        }
                    }
                }
                if ((grid[col][row]) && (aliveNeighbors < 2)) {
                    updated[col][row] = false;
                }
                else if ((grid[col][row]) && (aliveNeighbors > 3)) {
                    updated[col][row] = false;
                }
                else if ((!grid[col][row]) && (aliveNeighbors == 3)) {
                    updated[col][row] = true;
                }
                else {
                    updated[col][row] = this.grid[col][row];
                }
            }
        }
        this.grid = updated;
    }
}