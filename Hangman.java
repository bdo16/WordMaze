import java.util.*;
import java.io.*;

public class Hangman{
  Scanner input = new Scanner (System.in);
  public boolean over = false;
  private int lengthOfWord = 0;
  private int guessesleft = 6;
  private int[] letterfrequency = new int[26];
  private String wordGuess;
  private ArrayList<String> lettersGuessed = new ArrayList<String>();
  private ArrayList<String> words = new ArrayList<String>();
  public void start() {
    Arrays.fill(letterfrequency, 0); //sets all the values of letterfrequency to 0
    System.out.println("How many letters is your word?");
    lengthOfWord = input.nextInt();
    WordPlay(lengthOfWord);
  }
  
  public void WordPlay(int length)
  { // loads in contents of words into new ArrayList
    int counter = 0;
    try
    {
      Scanner in = new Scanner(new File("~/Documents/words.txt"));
      while(in.hasNext())
      { 
        if(in.next().length().equals(length)){
        words.add(in.next());
        counter++;
      }
      }
    }
    catch(IOException i)
    {
      System.out.println("Error: " + i.getMessage());
    }
    System.out.println(counter + " words loaded in.");
    System.out.println("Size of ArrayList: " + words.size());
  }
  
  
  
}

