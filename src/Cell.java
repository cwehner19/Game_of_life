public class GameOfLife {
    public static void main(String[] args) {
        // Add a String variable to store the filename
        String inputFile = "initial_state.txt";

        // (Same as before)
        int numRows = 20;
        int numColumns = 20;
        int numGenerations = 10;
        System.out.println("Welcome to Conway's Game of Life!");

        // Initialize the game board
        Board board = new Board(numRows, numColumns);

        // Call the readFromFile method
        board.readFromFile(inputFile);

        // Print the initial state of the board
        System.out.println("Initial configuration: ");
        board.printBoard();

        // Create a Game instance and start the game with the specified number of generations
        Game game = new Game(board, numGenerations);
        game.startGame();
    }
}
