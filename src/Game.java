//manages the game state, and interacts with the board and cell classes
public class Game  implements Update {
    private Board board; // the game board
    private int numGenerations; // the number of generations to simulate

    public Game(Board board, int numGenerations) {
        this.board = board;
        this.numGenerations = numGenerations;
    }


    public void startGame() {
        printBoard();
        for (int i = 0; i < numGenerations; i++) {
            // Update the board for each generation
            Update();
            // Print the current state of the board
            System.out.println("Generation " + (i+1)+ ":");
            printBoard();
        }
    }

    public void Update() {
        Board newBoard = new Board(board.getNumRows(), board.getNumColumns());

        for (int i = 0; i < newBoard.getNumRows(); i++) {
            for (int j = 0; j < newBoard.getNumColumns(); j++) {
                Cell cell = newBoard.getCell(i, j);
                int numAliveNeighbors = board.countAliveNeighbors(i, j);
                boolean newState = applyRules(cell, numAliveNeighbors);
                newBoard.setCell(i, j, newState);
            }

        }
        board = newBoard;
    }


    private boolean applyRules(Cell cell, int numAliveNeighbors) {
        if (cell.isAlive()) {
            // An alive cell with 2 or 3 alive neighbors stays alive; otherwise, it dies.
            return numAliveNeighbors == 2 || numAliveNeighbors == 3;
        } else {
            // A dead cell with exactly 3 alive neighbors comes to life.
            return numAliveNeighbors == 3;
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.getNumRows(); i++) {
            for (int j = 0; j < board.getNumColumns(); j++) {
                System.out.print(board.getCell(i, j).isAlive() ? "X" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }

}
