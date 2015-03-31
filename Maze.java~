public class Maze{

  public int level = 1;
  private int maxlevel = 2;
  public int count = 1;
  private int playerRow = 0;
  private int playerCol = 0;
  private int goalRow = 0;
  private int goalCol = 0;
  private String[][] map = new String[][]{{"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"},
    {"-","-","-","-","-","-","-","-","-","-"}};
  
  public void setMap() {
    if (level == 1) {
      playerRow = 0;
      playerCol = 5;
      goalRow = 8;
      goalCol = 5;
      starterMap();
    }
    if (level == 2) {
      playerRow = 9;
      playerCol = 5;
      goalRow = 8;
      goalCol = 8;
      if(isPrime(count))
        primeMap();
      else
        notPrimeMap();
  }
  }
  
    public void refreshMap() {
    if (level == 1) {
      starterMap();
    }
    if (level == 2) {
      if(count == 3 || count % 6 == 0) {
        System.out.println("***");
        System.out.println("Hint: The obstacles change in a pattern.");    
        System.out.println("***");
      }
      if(count % 8 == 0){
        System.out.println("***");
        System.out.println("Are you feeling at your...prime?");
        System.out.println("***");
      }
      if(isPrime(count))
        primeMap();
      else
        notPrimeMap();
  }
  }
  
   public void starterMap() {
    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map.length; col++) {
        map[row][col] = "-";
      }
    }
    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < 5; col++) {
        map[row][col] = "0";
      }
       for (int col = 6; col < map.length; col++) {
        map[row][col] = "0";
      }
    }
   }
  
  public void primeMap() {
    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map.length; col++) {
        map[row][col] = "-";
      }
    }
    map[0][0] = "0";
    map[1][8] = "0";
    map[3][3] = "0";
    map[4][9] = "0";
    map[6][2] = "0";
    map[7][7] = "0";
  }
  
  public void notPrimeMap() {
    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map.length; col++) {
        map[row][col] = "-";
      }
    }
    map[0][1] = "0";
    map[0][8] = "0";
    map[3][4] = "0";
    map[3][9] = "0";
    map[7][2] = "0";
    map[6][7] = "0";
  }
  
  public void printMap() {
    System.out.println("0 0 0 0 0 0 0 0 0 0 0 0");
    for (int row = 0; row < map.length; row++) {
      System.out.print("0 ");
      for (int col = 0; col < map.length; col++) {
        if(row == playerRow && col == playerCol)
          System.out.print("@ ");
        else if(row == goalRow && col == goalCol)
          System.out.print("X ");
        else
          System.out.print(map[row][col] + " ");
      }
      System.out.println("0");
    }
    System.out.println("0 0 0 0 0 0 0 0 0 0 0 0");
  }
  
  public boolean isPrime (int check){
    if(check < 2)
      return false;
    for (int i = 2; i < check; i++) {
      if(check%i==0)
        return false;
    }
    return true;
  }
  
  public void move(String action) {
    count++;
    if (action.equals("bobby"))
      level = 3;
    else if (action.equals("restart"))
      count = 1;
    else if (action.equals("w"))
      moveUp();
    else if (action.equals("a"))
      moveLeft();
    else if (action.equals("s"))
      moveDown();
    else if (action.equals("d"))
      moveRight();
    else
      System.out.println("Please type one letter (wasd).");
    refreshMap();
    printMap();
  }
  
  private void moveUp() {
    while(playerRow - 1 >= 0) {
      if (playerRow == goalRow && playerCol == goalCol){
        nextLevel();
        break;
      }
      if (map[playerRow - 1][playerCol].equals("-"))
        playerRow--;
      else
        break;
    }
  }
      
   private void moveDown() {
     while(playerRow + 1 < map.length) {
       if (playerRow == goalRow && playerCol == goalCol){
        nextLevel();
        break;
       }
      if (map[playerRow + 1][playerCol].equals("-"))
        playerRow++;
      else
        break;          
     }
   }
   
   private void moveLeft() {
     while(playerCol - 1 >= 0) {
      if (playerRow == goalRow && playerCol == goalCol) {
        nextLevel();
        break;
      }
      if (map[playerRow][playerCol - 1].equals("-"))
        playerCol--;
      else
        break;
     }
   }
   
   private void moveRight() {
     while(playerCol + 1 < map.length) {
       if (playerRow == goalRow && playerCol == goalCol) {
        nextLevel();
        break;
       }
      if (map[playerRow][playerCol + 1].equals("-"))
        playerCol++;
      else
        break;          
     }
   }
   
   private void nextLevel() {
     Hangman() hangman = new Hangman();
     while(!hangman.over)
       hangman.start();
     level++;
     count = 1;
     setMap();
     System.out.println("***");
     if(level <= maxlevel)
       System.out.println("Moving on to the next level.");
     if(level == 2)
       System.out.println("Are you at your...prime?");
     System.out.println("***");
   }
}