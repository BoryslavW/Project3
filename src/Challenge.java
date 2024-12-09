// learned decimal format from: https://www.geeksforgeeks.org/java-program-to-round-a-number-to-n-decimal-places/

/*
    ok so, the basic idea of the final challenge is, because riddler is a lunatic and quite frankly demented
    all of his bombs are interconnected to one bomb, where if you defuse that bomb then you are able to defuse all of them

    we can turn this into two smaller mini-games, one where you pick which bomb out of four, and another where you defuse it

    the picking bombs can be a riddle in itself but like a stupid one like why who was scared of seven (it was 6, cuz 789)

    for defusing bombs, it can be a color riddle where the answer is like red or something idk, the text art will be a post it you find next to the bomb,
    like the first text art is the bomb, then you type "search", then you find the post it

    also im writing this at like 1 aclock so im too stupid to do it rn but we should do that same thing we did with the riddles so they dont repeat
    but for the responses the Riddler gives

    also Kevin if i dont tell you TMRW, i should be saying i am truly sorry for this, I have been unresponsive and forced work onto you because of my laziness and disrespect
    i have apologized in the past but that has changed nothing and i am genuinely a bad person for not doing my part, if you trust me then tell me to finish the project on my
    own because i will just continue to be an asshole and not lift my weight for project work
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Challenge {
    Scanner scan = new Scanner(System.in);
    DecimalFormat df_tenths = new DecimalFormat("#.#");
    private double distance = 0;

    public Challenge() {}

    public String grapple() {
        int x = (int) (Math.random() * 4 + 1);
        int y = (int) (Math.random() * 4 + 1);
        double sqred = Math.sqrt((x * x) + (y * y));

        if (sqred == (int) sqred) {
            return "Calculate the hypotenuse of a right triangle with leg lengths of " + x + " and " + y;
        } else {
            distance = Double.parseDouble(df_tenths.format(sqred));
            return "Calculate the hypotenuse of a right triangle with leg lengths of " + x + " and " + y + " (to the tenths place)";
        }
    }

    public boolean check() {
        double ans = scan.nextDouble();
        double realANS = distance;

        return realANS == ans;
    }

    public void mad(int solves) {
        System.out.println("WHAT KIND OF DETECTIVE ARE YOU!?  I put so much effort into these projects and you only solve " + solves + " RIDDLES!?");
    }

}
