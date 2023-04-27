import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Board implements Update{
   private Cell[][] gameBoard; // 2D array of cells
   private int rows = 20; // number of rows in the board
   private int columns = 20; // number of columns in the board

   public Board(int rows, int columns) {
      this.rows = rows;
      this.columns = columns;
      this.gameBoard = new Cell[rows][columns];
      // Initialize the cell instances
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            gameBoard[i][j] = new Cell(false);
         }
      }
   }

   public int getNumRows() {
      return rows;
   }

   public int getNumColumns() {
      return columns;
   }
   public void setCell(int row, int column, boolean isAlive) {
      if(row >= 0 && row < rows && column >= 0 && column < columns){
         gameBoard[row][column].setAlive(isAlive);
      }
         else{
            throw new IllegalArgumentException("Invalid row or column index");
      }
      //gameBoard[row][column].setAlive(isAlive);
   }

   public Cell getCell(int row, int column) {
      return gameBoard[row][column];
   }

   public int countAliveNeighbors(int row, int column) {
      int count = 0;
      for (int i = row - 1; i <= row + 1; i++) {
         for (int j = column - 1; j <= column + 1; j++) {
            if (i >= 0 && i < rows && j >= 0 && j < columns && !(i == row && j == column)) {
               if (gameBoard[i][j].isAlive()) {
                  count++;
               }
            }
         }
      }
      return count;
   }
   public void readFromFile(String filename) {
     try {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        int row = 0;
        while ((line = br.readLine()) != null) {
           for (int column = 0; column < line.length(); column++) {
              setCell(row, column, line.charAt(column) == 'X');
           }
           row++;
        }
        br.close();
     } catch (IOException e) {
        e.printStackTrace();
     }
  }

   // Move the Update method outside the catch block
   @Override
   public void Update() {

   }
   public void printBoard() {
   }
}
