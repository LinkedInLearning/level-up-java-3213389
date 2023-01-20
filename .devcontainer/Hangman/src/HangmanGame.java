import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"apple", "banana", "cherry", "grape", "mango"};
    private static final int MAX_MISSES = 7;

    private String word;
    private StringBuilder wordSoFar;
    private int misses;

    public HangmanGame() {
        word = WORDS[(int) (Math.random() * WORDS.length)];
        wordSoFar = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            wordSoFar.append("_");
        }
        misses = 0;
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Word: " + wordSoFar);
            System.out.print("Guess a letter: ");
            String guess = in.next();
            if (guess.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }
            if (word.contains(guess)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess.charAt(0)) {
                        wordSoFar.setCharAt(i, guess.charAt(0));
                    }
                }
                if (word.equals(wordSoFar.toString())) {
                    System.out.println("Congratulations! You won!");
                    break;
                }
            } else {
                System.out.println("Sorry, that letter is not in the word.");
                misses++;
                if (misses == MAX_MISSES) {
                    System.out.println("You lose! The word was: " + word);
                    break;
                }
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.play();
    }
}