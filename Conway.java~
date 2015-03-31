import java.util.Scanner;

public class Conway{
  Scanner in = new Scanner (System.in);
  private int counter = 1;
  public boolean over = false;
  public boolean[][] board = new boolean[10][20];
  public boolean[][] temp = new boolean[10][20];
  public void start(String pattern){
    for (int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        board[i][j] = false;
        temp[i][j] = false;
      }
    }
    if(pattern.equals("stripes")){
      boolean alternator = true;
      for (int i = 1; i < board.length - 1; i++) {
      for(int j = 1; j < board[0].length - 1; j++) {
        board[i][j] = alternator;
        temp[i][j] = alternator;
        alternator = !alternator;
      }
      alternator = !alternator;
    }
    }
     if(pattern.equals("lines")){
      boolean alternator = false;
      for (int i = 1; i < board.length - 1; i++) {
      for(int j = 1; j < board[0].length - 1; j++) {
        board[i][j] = alternator;
        temp[i][j] = alternator;
      }
      alternator = !alternator;
    }
    }
    printBoard();
  }
  
  public void action(String input) {
    if(input.equals("end")){
      over = true;
      return;
    }
    for (int i = 1; i < board.length - 1; i++) {
      for(int j = 1; j < board[0].length - 1; j++) {
          temp[i][j] = isAlive(i,j); //goes through a step in time
      }
    }
    over = true;
    for (int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        board[i][j] = temp[i][j];
        if(board[i][j])
          over = false;
      }
    }
  counter++;
  printBoard();
}

public boolean isAlive(int row, int col){
  int neighborsalive = 0;
  for(int i = row - 1; i < row + 2; i++){
    for(int j = col - 1; j < col + 2; j++) {
      if(board[i][j])
        neighborsalive++; //add one for each neighbor that is alive
    }
  }
  if(board[row][col]) {
    neighborsalive--; //subtract 1 as the nested for loop above counts the cell itself
    if (neighborsalive < 2)
      return false; //dies from underpopulation
    if (neighborsalive > 3)
      return false; //dies from overcrowding
    else
      return true; //lives if number of neighbors are 2 or 3
  }
  if (neighborsalive == 3) //reproduction
    return true; //lives if number of neighbors is exactly 3
  return false; //if not, stays dead
}

public void printBoard(){
  for (int i = 0; i < board.length; i++) {
    for(int j = 0; j < board[0].length; j++) {
      if(board[i][j])
        System.out.print("0");
      else
        System.out.print(" ");
    }
    System.out.println("");
  }
  System.out.println("Conway's Game of Life");
  System.out.println("Turn: " + counter);
}

}