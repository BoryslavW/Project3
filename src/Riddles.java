// array list from: https://www.w3schools.com/java/java_arraylist.asp
// lists from: https://stackoverflow.com/questions/858572/how-to-make-a-new-list-in-java
/* riddles & answers from: https://gamerant.com/batman-riddler-best-riddles/
                           https://parade.com/947956/parade/riddles/
*/

import java.util.*;

public class Riddles {

    private int riddleNum = 0;
    Scanner scan = new Scanner(System.in);

    List<String> questions = Arrays.asList(
            "I feel your every move. I know your every thought. I'm with you from birth, and I'll see you when you rot. What am I?",
            "I can be cracked. I can be made. I can be told. I can be played. What am I?",
            "If you are justice, please do not lie. What is the price for your blind eye?",
            "What can you break, even if you never pick it up or touch it?",
            "The more of this there is, the less you see. What is it?",
            "What has 13 hearts, but no other organs?",
            "What tastes better than it smells?",
            "Without fingers I point, without arms I strike, without feet I run. What am I?",
            "What is always on its way here but never arrives?",
            "What has a thumb and four fingers, but is not a hand?",
            "If you’ve got me, you want to share me; if you share me, you haven’t kept me. What am I?",
            "What can’t talk but will reply when spoken to?"
    );
    List<String> answers = Arrays.asList(
            "Your reflection",
            "A joke", "Bribe",
            "A promise",
            "Darkness",
            "A deck of cards",
            "Your tongue",
            "A clock",
            "Tomorrow",
            "A glove",
            "A secret",
            "An echo"
    );
    ArrayList<Integer> previous = new ArrayList<>();

    public Riddles() {}

    public String giveRiddle() throws InterruptedException {
        riddleNum = (int) (Math.random() * 12);

        while (previous.contains(riddleNum)) {
            riddleNum = (int) (Math.random() * 12);
        }

        previous.add(riddleNum);
        String riddle = questions.get(riddleNum);

        for (int i = 0; i < riddle.length(); i++) {
            System.out.print(riddle.charAt(i));
            Thread.sleep(100);
        }

        return "";
    }

    private boolean isCorrectAnswer(String ans, String correctAnswer) {
        ans = ans.toLowerCase().trim();
        correctAnswer = correctAnswer.toLowerCase().trim();
        return correctAnswer.contains(ans) && ans.length() > 3;
    }

    public boolean checkANS() {
        System.out.print("Your answer: ");
        String ans = scan.nextLine();
        String correctAnswer = answers.get(riddleNum);
        return isCorrectAnswer(ans, correctAnswer);
    }

    public String getAnswer() {
        return answers.get(riddleNum);
    }
}