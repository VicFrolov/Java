/**
 * MazeWalker is the object that is responsible for staking out a path down some
 * maze. Given a 2D array of maze cells and a starting location, it calculates
 * the next "legal" move such that the walker can eventually cover every square
 * in the maze that is reachable from that starting location.
 */
public class MazeWalker {
    /**
     * The possible states of the current "walk" through a maze.
     */
    public enum WalkerState {
        /**
         * Indicates that the maze walker has reached its assigned destination.
         */
        THERE_ALREADY,
        
        /**
         * Indicates that the maze walker has concluded that it is impossible to
         * reach its destination.
         */
        IMPOSSIBLE_TO_GET_THERE,
        
        /**
         * Indicates that the maze walker would like to move left.
         */
        MOVE_LEFT,
        
        /**
         * Indicates that the maze walker would like to move up.
         */
        MOVE_UP,
        
        /**
         * Indicates that the maze walker would like to move right.
         */
        MOVE_RIGHT,
        
        /**
         * Indicates that the maze walker would like to move down.
         */
        MOVE_DOWN
    }
    
    /**
     * Initializes the MazeWalker, providing it with the maze to use and the
     * walker's destination.
     */
    public MazeWalker(Maze maze, int destinationX, int destinationY) {
        this.maze = maze;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        
        // The path stack starts out empty.
        path = new WalkerState[this.maze.getMazeWidth() * this.maze.getMazeHeight()];
        pathIndex = -1;
        
        // The "been-there" array starts off completely clear.
        beenThere = new boolean[this.maze.getMazeHeight()][this.maze.getMazeWidth()];
        for (int row = 0; row < beenThere.length; row++) {
            for (int column = 0; column < beenThere[row].length; column++) {
                beenThere[row][column] = false;
            }
        }
    }

    /**
     * Takes a step toward reaching the given destination from the given current
     * location, and returns either the direction of the next step, whether or
     * not that destination has been reached, or whether that destination is
     * impossible to reach.
     */
    public WalkerState areWeThereYet(int currentX, int currentY) {
        beenThere[currentY][currentX] = true;
        WalkerState currentWalkerState = WalkerState.IMPOSSIBLE_TO_GET_THERE;

        if (currentX == destinationX && currentY == destinationY ) {
            return WalkerState.THERE_ALREADY;
        } else if (maze.getLocation(currentX , currentY).getRight().isOpen() && !beenThere[currentY][currentX +1] ){
            currentWalkerState = WalkerState.MOVE_RIGHT;
            pathIndex++;
            path[pathIndex] = WalkerState.MOVE_RIGHT;
        } else if (maze.getLocation(currentX, currentY).getBelow().isOpen() && !beenThere[currentY +1][currentX] ) {
            currentWalkerState =  WalkerState.MOVE_DOWN;
            pathIndex++;
            path[pathIndex] = WalkerState.MOVE_DOWN;            
        } else if (maze.getLocation(currentX, currentY).getLeft().isOpen() && !beenThere[currentY][currentX - 1] ) {
            currentWalkerState =  WalkerState.MOVE_LEFT;
            pathIndex++;
            path[pathIndex] = WalkerState.MOVE_LEFT;
        } else if (maze.getLocation(currentX, currentY).getAbove().isOpen() && !beenThere[currentY - 1][currentX] ) {
            currentWalkerState =  WalkerState.MOVE_UP;  
            pathIndex++;
            path[pathIndex] = WalkerState.MOVE_UP;              
        } else {
            currentWalkerState = backItUp();
        }
        return currentWalkerState;
    }

    public WalkerState backItUp() {
        WalkerState whereToBackUp = WalkerState.IMPOSSIBLE_TO_GET_THERE;


        if(pathIndex == -1) {
            whereToBackUp = WalkerState.IMPOSSIBLE_TO_GET_THERE;
        } else if (path[pathIndex].equals(WalkerState.MOVE_LEFT)) {
            pathIndex--;
            whereToBackUp = WalkerState.MOVE_RIGHT;
        } else if (path[pathIndex].equals(WalkerState.MOVE_RIGHT)) {
            pathIndex--;
            whereToBackUp = WalkerState.MOVE_LEFT;
        } else if (path[pathIndex].equals(WalkerState.MOVE_UP)) {
            pathIndex--;
            whereToBackUp = WalkerState.MOVE_DOWN;
        } else if (path[pathIndex].equals(WalkerState.MOVE_DOWN)) {
            pathIndex--;
            whereToBackUp = WalkerState.MOVE_UP;
        } 
        return whereToBackUp;
    }



    /**
     * Returns a representation of the locations which the walker has visited.
     * The 2D array's dimensions should correspond to those of the walker's
     * assigned maze.
     */
    public boolean[][] getBeenThere() {
        return beenThere;
    }

    /**
     * Returns the current path taken by the walker.
     */
    public WalkerState[] getCurrentPath() {
        WalkerState[] currentPath = new WalkerState[pathIndex + 1];
        for (int i = 0; i < pathIndex + 1; i++) {
            currentPath[i] = path[i];
        }
        return currentPath;
    }

    /**
     * The data structure for maintaining the current path.
     */
    private WalkerState[] path;
    
    /**
     * The index for the current node in the path.
     */
    private int pathIndex;

    /**
     * The data structure for keeping track of "passed" squares.
     */
    private boolean[][] beenThere;
    
    /**
     * The maze that is being walked.
     */
    private Maze maze;
    
    /**
     * The x-coordinate of the walker's destination.
     */
    private int destinationX;
    
    /**
     * The y-coordinate of the walker's destination.
     */
    private int destinationY;
}
