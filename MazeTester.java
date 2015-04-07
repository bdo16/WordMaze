import java.util.Scanner;

public class MazeTester{
   public static void main(String[] args)
  {
     Scanner in = new Scanner (System.in);
     Conway game = new Conway();
     Maze maze = new Maze();
     maze.setMap();
     maze.printMap();
     System.out.println("Instructions: You are @, and your goal is to get to the X.");
     System.out.println("Type one letter (wasd) and press enter to move.");
     System.out.println("w = up, a = left, s = down, d = right");
     System.out.println("You will KEEP ON MOVING straight until you hit 0");
     while(maze.level < 3) {
         System.out.println("Level: " + maze.level);
         System.out.println("Turn: " + maze.count);
         String action = in.nextLine();
         maze.move(action);
     }
     System.out.println("Congratulations, you have finished the maze.");
     System.out.println("This is Conway's Game of Life. Type \"stripes\" and press enter");
     String pattern = in.nextLine();
     game.start(pattern);
     while(!game.over) {
       String input = in.nextLine();
       game.action(input);
       System.out.println("Press enter to continue.");
     }
   }
}
                  