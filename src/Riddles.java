/**
 * This class holds and gives the riddles for the game, serving as the majority of the gameplay
 *
 * @author Kevin Yeung & Boryslav Winiewski
 */
import java.util.*;

public class Riddles {

    /** The index of riddles and will later be used to see which have been done already */
    private int riddleNum = 0;

    Scanner scan = new Scanner(System.in);

    /** The list of riddles */
    List<String> questions = Arrays.asList("I feel your every move. I know your every thought. I'm with you from birth, and I'll see you when you rot. What am I?", "I can be cracked. I can be made. I can be told. I can be played. What am I?", "If you are justice, please do not lie. What is the price for your blind eye?", "What can you break, even if you never pick it up or touch it?", "The more of this there is, the less you see. What is it?", "What has 13 hearts, but no other organs?", "What tastes better than it smells?", "Without fingers I point, without arms I strike, without feet I run. What am I?", "What is always on its way here but never arrives?", "What has a thumb and four fingers, but is not a hand?", "If you’ve got me, you want to share me; if you share me, you haven’t kept me. What am I?", "What can’t talk but will reply when spoken to?");

    /** The list of answers to the riddles with corresponding indices */
    List<String> answers = Arrays.asList("Your reflection", "A joke", "Bribe", "A promise", "Darkness", "A deck of cards", "Your tongue", "A clock", "Tomorrow", "A glove", "A secret", "An echo");

    /** An empty array which will later contain the indexes of used questions */
    ArrayList<Integer> previous = new ArrayList<>();

    /** Instantiates a Riddles object with no parameters */
    public Riddles() {}


    /** Returns a riddle from the
     * previous array, which hasnt been used before
     *
     * @return a random riddle from the list of riddles
     */
    public String Riddles() {

        riddleNum = (int) ((Math.random() * 12) + 1);

        while (previous.contains(riddleNum)) {
            riddleNum = (int) ((Math.random() * 12) + 1);
        }

        previous.add(riddleNum);
        return questions.get(riddleNum);

    }


    /** Returns a true or false on whether the answer given by the player corresponds
     * to the correct answer in the answers array
     * uses toLowerCase to make sure there aren't any punctuation problems
     *
     * @return if player got answer correct
     */
    public boolean checkANS() {
        String ans = scan.nextLine();

        String realANS = answers.get(riddleNum);

        ans = ans.toLowerCase();
        realANS = realANS.toLowerCase();

        if (realANS.contains(ans)) {
            return true;
        }
        else {
            return false;
        }

    }
}
