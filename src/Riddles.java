import java.util.*;

public class Riddles {

    private int riddleNum = 0;
    Scanner scan = new Scanner(System.in);

    List<String> questions = Arrays.asList("I feel your every move. I know your every thought. I'm with you from birth, and I'll see you when you rot. What am I?", "I can be cracked. I can be made. I can be told. I can be played. What am I?", "If you are justice, please do not lie. What is the price for your blind eye?", "What can you break, even if you never pick it up or touch it?", "The more of this there is, the less you see. What is it?", "What has 13 hearts, but no other organs?", "What tastes better than it smells?", "Without fingers I point, without arms I strike, without feet I run. What am I?", "What is always on its way here but never arrives?", "What has a thumb and four fingers, but is not a hand?", "If you’ve got me, you want to share me; if you share me, you haven’t kept me. What am I?", "What can’t talk but will reply when spoken to?");
    List<String> answers = Arrays.asList("Your reflection", "A joke", "Bribe", "A promise", "Darkness", "A deck of cards", "Your tongue", "A clock", "Tomorrow", "A glove", "A secret", "An echo");
    ArrayList<Integer> previous = new ArrayList<>();

    public Riddles() {}

    public String giveRiddle() {
        riddleNum = (int) (Math.random() * 12);

        while (previous.contains(riddleNum)) {
             riddleNum = (int) (Math.random() * 12);
        }

        previous.add(riddleNum);
        return questions.get(riddleNum);
    }

    public boolean checkANS() {
        String ans = scan.nextLine();
        String realANS = answers.get(riddleNum);
        ans = ans.toLowerCase();
        realANS = realANS.toLowerCase();

        if (ans.length() < 3) {
            return false;
        } else return realANS.contains(ans);
    }

    public String getAnswer() {
        return answers.get(riddleNum);
    }
}
