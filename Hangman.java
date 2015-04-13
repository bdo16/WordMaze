import java.util.*;
import java.io.File;
import java.io.IOException;

public class Hangman{
  Scanner input = new Scanner (System.in);
  private int lengthofword; // the length of the word the player is thinking of
  private int guessesleft; //the number of guesses left
  private int[] letterfrequency = new int[26]; //used to calculate letter frequency
  private boolean[] lettersguessed = new boolean[26]; //false if not guessed, true if guessed
  private ArrayList<String> wrongletters = new ArrayList<String>(); //a list of incorrect letters
  private String[] wordguess; //the parts of the word the computer has guessed
  private ArrayList<String> words = new ArrayList<String>(); //a list of all possible words
  
  public void start() {
    guessesleft = 9; //resets the number of guesses
    wrongletters.clear(); //clears the arraylist
    words.clear();
    Arrays.fill(letterfrequency, 0); //sets all the values of letterfrequency to 0
    Arrays.fill(lettersguessed, false); //sets all the values of letterfrequency to 0
    System.out.println("In order to pass, you must beat me in a game of Hangman.");
    System.out.println("How many letters is your word?");
    lengthofword = input.nextInt(); //gets the length of the word from the player
    wordguess = new String[lengthofword]; //makes wordguess have the correct number of spaces
    Arrays.fill(wordguess, ""); //fills all the spaces with blank strings
    WordPlay(); //loads all words in the dictionary into the words arraylist
    print();
    guess();
  }
  
  public void guess() { //uses recursion to continually guess letters
    if(check()) //checks to see if the computer has guessed the word
      endGame();
    else if(guessesleft > 0) {
      refreshWordList(); //updates the words arraylist with the new information
      refreshLetterFrequency(); //updates the letter frequency from the new list of words
      String chosenletter = letterToGuess(); //computer chooses the letter
      System.out.println("Is the letter '" + chosenletter + "' in your word?");
      String response = "";
      System.out.println("Type 'y' or 'n'");
      while(! (response.equals("y") || response.equals("n") )){ //will loop until valid response
        response = input.nextLine();
      }
      lettersguessed[letterToIndex(chosenletter)] = true; //notes that the computer guessed the letter
      if(response.equals("y")){ //if the computer guessed right
        System.out.println("What position is the letter in?");
        System.out.println("Type one number at a time, \"1\" for the first letter in the word.");
        System.out.println("Type \"0\" once finished.");
        int positionofletter = input.nextInt(); //stores the first position that has that letter
        while (positionofletter != 0){ //will loop until all positions have been entered
          wordguess[positionofletter-1] = chosenletter; //adds the letter to wordguess
          positionofletter = input.nextInt();//asks the player again
        }
      }
      else { //if the computer guessed wrong
        wrongletters.add(chosenletter); //adds the letter to the list of incorrect letters 
        guessesleft--; //lowers the number of guesses left
      }
      print();//prints the information
      guess();//guesses again
    }
    else //if there are no more guesses
      endGame();
  }
  
  public boolean check() { //checks if the computer has gotten the entire word
    boolean allfilled = true;
    for(int i = 0; i < wordguess.length; i++){
      if(wordguess[i].equals(""))
        allfilled = false;
    }
    return allfilled;
  } 
  
  public void print() { //prints the information
    System.out.println("Number of guesses left: " + guessesleft);
    for(int i = 0; i < wordguess.length; i++){ //shows what parts of the word the computer has guessed
      if(wordguess[i].equals(""))
        System.out.print(" _ "); //blank spot for places the computer has not guessed
      else
        System.out.print(" " + wordguess[i] + " ");
    }
    System.out.println("");
    System.out.print("Incorrect letters: ");
    for(int i = 0; i < wrongletters.size(); i++){ //prints out all the incorrect letters
      System.out.print(wrongletters.get(i) + " ");
    }
    System.out.println("");
  }
  
  public void refreshWordList() { //removes all the words that are no longer possible
    for (int i = words.size() - 1; i >= 0; i--){ //checks all the words
      if(hasincorrectletter(words.get(i))) // checks if the word has any incorrect letters
        words.remove(i);
      else if(lettersdonotmatch(words.get(i))) //checks if the word doesn't match wordguess
        words.remove(i);
    }
  }
  
  public boolean hasincorrectletter(String word){ //checks if the word has any incorrect letters
    for(int j = 0; j < wrongletters.size(); j++){ //goes through all the incorrect letters
      for(int k = 0; k < word.length(); k++){ //goes through each letter in the word
        if(word.substring(k,k+1).equals(wrongletters.get(j)))
          return true; //returns true if any letter in the word matches an incorrect letter
      }
    }
    return false; //returns false if the word has no incorrect letters
  }
  
  public boolean lettersdonotmatch(String word){ //checks if the word does not match wordguess
    for(int i = 0; i < wordguess.length; i++){ //goes through wordguess
      if(!wordguess[i].equals("")){ //if the computer has guessed that position
        if(!wordguess[i].equals(word.substring(i,i+1)))
          return true; //returns true if the word does not match wordguess
      } //for example "cane" does not match "_and"
    }
    return false; //returns false if the word matches wordguess
  }
  
  public void refreshLetterFrequency() {
    Arrays.fill(letterfrequency, 0); //sets all the values of letterfrequency to 0
    for(String word: words){ //goes through all the words
      if(word.indexOf("a") >= 0)
        letterfrequency[0]++;
      if(word.indexOf("b") >= 0)
        letterfrequency[1]++;
      if(word.indexOf("c") >= 0)
        letterfrequency[2]++;
      if(word.indexOf("d") >= 0)
        letterfrequency[3]++;
      if(word.indexOf("e") >= 0)
        letterfrequency[4]++;
      if(word.indexOf("f") >= 0)
        letterfrequency[5]++;
      if(word.indexOf("g") >= 0)
        letterfrequency[6]++;
      if(word.indexOf("h") >= 0)
        letterfrequency[7]++;
      if(word.indexOf("i") >= 0)
        letterfrequency[8]++;
      if(word.indexOf("j") >= 0)
        letterfrequency[9]++;
      if(word.indexOf("k") >= 0)
        letterfrequency[10]++;
      if(word.indexOf("l") >= 0)
        letterfrequency[11]++;
      if(word.indexOf("m") >= 0)
        letterfrequency[12]++;
      if(word.indexOf("n") >= 0)
        letterfrequency[13]++;
      if(word.indexOf("o") >= 0)
        letterfrequency[14]++;
      if(word.indexOf("p") >= 0)
        letterfrequency[15]++;
      if(word.indexOf("q") >= 0)
        letterfrequency[16]++;
      if(word.indexOf("r") >= 0)
        letterfrequency[17]++;
      if(word.indexOf("s") >= 0)
        letterfrequency[18]++;
      if(word.indexOf("t") >= 0)
        letterfrequency[19]++;
      if(word.indexOf("u") >= 0)
        letterfrequency[20]++;
      if(word.indexOf("v") >= 0)
        letterfrequency[21]++;
      if(word.indexOf("w") >= 0)
        letterfrequency[22]++;
      if(word.indexOf("x") >= 0)
        letterfrequency[23]++;
      if(word.indexOf("y") >= 0)
        letterfrequency[24]++;
      if(word.indexOf("z") >= 0)
        letterfrequency[25]++;
    }
  }
  
  public String letterToGuess() { //chooses the letter to guess
    int highestindex = 0; //the index that has the highest letter frequency
    while(lettersguessed[highestindex]) //checks to see if the starting letter has been guessed
      highestindex++; //so the for loop starts with an unguessed letter
    for(int i = highestindex + 1; i < letterfrequency.length; i++){
      if(!lettersguessed[i]){ //if the letter has not been guessed yet
        if(letterfrequency[i] > letterfrequency[highestindex]) //if the next letter has a higher frequency
          highestindex = i; //highestindex is now the next index
      }
    }
    return indexToLetter(highestindex); //will return the actual letter that the index represents
  }
  
  public String indexToLetter(int i) { //changes the index to a letter (from 0 to a)
    return String.valueOf((char)('a'+i));
  }
  
  public int letterToIndex(String s) { //changes the letter to an index (from a to 0)
    char temp = s.charAt(0);
    return temp - 'a';
  }
  
  public void endGame() {
    if(check()){ //if the computer guessed the word right
      System.out.println("I have guessed your word! Let's try playing again.");
      start();
    }
    else{ //if the computer guessed the word wrong
      System.out.println("You win! You can move on.");
    }
  }
  
  public void WordPlay()
  { // loads in contents of words into new ArrayList
    try
    {
      Scanner in = new Scanner(new File("words.txt"));
      //  Scanner in = new Scanner(new File("~/Documents/words.txt"));
      while(in.hasNext())
      { 
        words.add(in.next()); //adds the word from the file into the arraylist
        if(!(words.get(words.size()-1).length() == lengthofword)){
          words.remove(words.size()-1); //removes the word if it does not match the length of wordguess
        }
      }
    }
    catch(IOException i)
    {
      System.out.println("Error: " + i.getMessage());
    }
    //System.out.println(counter + " words loaded in.");
    //System.out.println("Size of ArrayList: " + words.size());
  }
  
  
  
}

