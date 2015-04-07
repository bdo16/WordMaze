import java.util.*;
import java.io.File;
import java.io.IOException;

public class Hangman{
  Scanner input = new Scanner (System.in);
  public boolean over = false;
  private int lengthofword = 0;
  private int guessesleft = 9;
  private int[] letterfrequency = new int[26];
  private boolean[] lettersguessed = new boolean[26]; //false if not guessed, true if guessed
  private ArrayList<String> wrongletters = new ArrayList<String>();
  private String[] wordguess;
  private ArrayList<String> words = new ArrayList<String>();
  private int counter = 0; // number of words in ArrayList words
  
  public void start() {
    guessesleft = 9;
    Arrays.fill(letterfrequency, 0); //sets all the values of letterfrequency to 0
    Arrays.fill(lettersguessed, false); //sets all the values of letterfrequency to 0
    System.out.println("In order to pass, you must beat me in a game of Hangman.");
    System.out.println("How many letters is your word?");
    lengthofword = input.nextInt();
    wordguess = new String[lengthofword];
    Arrays.fill(wordguess, "");
    WordPlay();
    print();
    guess();
  }
  
  public void guess() {
    if(check())
      endGame();
    else if(guessesleft > 0) {
      refreshWordList();
      refreshLetterFrequency();
      String chosenletter = letterToGuess();
      System.out.println("Is the letter '" + chosenletter + "' in your word?");
      String response = "";
      System.out.println("Type 'y' or 'n'");
      while(! (response.equals("y") || response.equals("n") )){
        response = input.nextLine();
      }
      lettersguessed[letterToIndex(chosenletter)] = true;
      if(response.equals("y")){
        System.out.println("What position is the letter in?");
        System.out.println("Type one number at a time, \"1\" for the first position. Type \"0\" once finished.");
        int positionofletter = input.nextInt();
        while (positionofletter != 0){
          wordguess[positionofletter-1] = chosenletter;
          positionofletter = input.nextInt();
        }
      }
      else {
        wrongletters.add(chosenletter);
        guessesleft--;
      }
      print();//prints the information
      guess();//guesses again
    }
    else
      endGame();
  }
  
  public boolean check() {
    boolean allfilled = true;
    for(int i = 0; i < wordguess.length; i++){
      if(wordguess[i].equals(""))
        allfilled = false;
    }
    return allfilled;
  } 
  
  public void print() {
    System.out.println("Number of guesses left: " + guessesleft);
    for(int i = 0; i < wordguess.length; i++){
      if(wordguess[i].equals(""))
        System.out.print(" _ ");
      else
        System.out.print(" " + wordguess[i] + " ");
    }
    System.out.println("");
    System.out.print("Incorrect letters: ");
    for(int i = 0; i < lettersguessed.length; i++){
      if(lettersguessed[i]){
        boolean notinword = true;
        for(int j = 0; j < wordguess.length; j++){
          if (indexToLetter(i).equals(wordguess[j]))
            notinword = false;
        }
        if(notinword)
          System.out.print(indexToLetter(i) + " ");
      }
    }
    System.out.println("");
  }
  
  public void refreshWordList() {
    for (int i = words.size() - 1; i >= 0; i--){
      if(hasincorrectletter(words.get(i)))
        words.remove(i);
      else if(lettersdonotmatch(words.get(i)))
        words.remove(i);
    }
  }
  
  public boolean hasincorrectletter(String word){
    for(int j = 0; j < wrongletters.size(); j++){
      for(int k = 0; k < word.length(); k++){ //letters
        if(word.substring(k,k+1).equals(wrongletters.get(j)))
          return true;
      }
    }
    return false;
  }
  
  public boolean lettersdonotmatch(String word){
    for(int i = 0; i < wordguess.length; i++){
      if(!wordguess[i].equals("")){
        if(!wordguess[i].equals(word.substring(i,i+1)))
          return true;
      }
    }
    return false;
  }
  
  public void refreshLetterFrequency() {
    Arrays.fill(letterfrequency, 0); //sets all the values of letterfrequency to 0
    for(String word: words){
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
  
  public String letterToGuess() {
    int highestindex = 0;
    while(lettersguessed[highestindex]) //checks to see if the starting letter has been guessed
      highestindex++; //so the for loop starts with an unguessed letter
    for(int i = highestindex + 1; i < letterfrequency.length; i++){
      if(!lettersguessed[i]){ //if the letter has not been guessed yet
        if(letterfrequency[i] > letterfrequency[highestindex])
          highestindex = i;
      }
    }
    return indexToLetter(highestindex);
  }
  
  public String indexToLetter(int i) {
    return String.valueOf((char)('a'+i));
  }
  
  public int letterToIndex(String s) {
    char temp = s.charAt(0);
    return temp - 'a';
  }
  
  public void endGame() {
    if(check()){
      System.out.println("I have guessed your word! Let's try playing again.");
      start();
    }
    else{
      System.out.println("You win! You can move on.");
      over = true;
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
        words.add(in.next());
        counter++;
        if(!(words.get(words.size()-1).length() == lengthofword)){
          words.remove(words.size()-1);
          counter--;
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

