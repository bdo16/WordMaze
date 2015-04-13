import java.util.Scanner;

public class MazeTester{
   public static void main(String[] args)
  {
     Scanner in = new Scanner (System.in);
     Maze maze = new Maze();
     Conway game = new Conway();
     maze.setMap(); //sets up the maze for the first time
     maze.printMap(); //prints the maze for the first time
     System.out.println("You are entering the Hangman Maze.");
     System.out.println("You are @, and your goal is to get to the X.");
     System.out.println("The 0 are rocks that you cannot pass through.");
     System.out.println("Type one letter (wasd) and press enter to move.");
     System.out.println("w = up, a = left, s = down, d = right");
     System.out.println("You will KEEP ON MOVING straight until you hit 0 or reach X.");
     while(maze.level <= maze.maxlevel) { //continues until the maze is finished
         System.out.println("Level: " + maze.level);
         System.out.println("Turn: " + maze.count);
         String action = in.nextLine();
         maze.move(action);
     }
     System.out.println("Congratulations, you have finished the maze.");
     System.out.println("This is Conway's Game of Life. Type \"stripes\" or \"lines\" and press enter");
     String pattern = in.nextLine();
     game.start(pattern); //starts Conway's Game of Life
     while(!game.over) {
       System.out.println("Press enter to continue or \"end\" to quit.");
       String input = in.nextLine();
       game.action(input);
     }
   }
}
                  