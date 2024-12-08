//add something that asks if the player wants to try again or play again after they finish
//add game introduction
//can use Thread.sleep(1000); between print messages to delay prints; better game flow

public class Logic {
    private Challenge challenge;
    private Riddles riddle;
    private TextArt art;

    private int success = 0;
    private int fails = 0;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public Logic() {
        challenge = new Challenge();
        riddle = new Riddles();
        art = new TextArt();
    }

    public void printRandomReply() {
        String[] replies = {
                "Well, well, well, the Detective lives up to his name.",
                "Lucky guess, or are you truly as sharp as they say?",
                "You think you're so clever, don't you? Let's see how long that lasts!",
                "A fluke, surely. Care to try your luck again?",
                "Oh, bravo, Batman! But don't let it go to your head.",
                "Even a dull blade can cut once in a while."
        };
        System.out.println(ANSI_RED + replies[(int)(Math.random() * replies.length)] + ANSI_RESET);
    }

    public void printWinMessage() {
        System.out.println(ANSI_GREEN + "You won, Gotham lives to see another night");
        System.out.println("The Riddler will be sent to Arkham and receive no psychiatric help" + ANSI_RESET);
    }

    public void printLoseMessage() {
        System.out.println(ANSI_PURPLE + "You lost, Gotham has been blown to smithereens");
        System.out.println(":(" + ANSI_RESET);
    }

    public void resetGame() {
        success = 0;
        fails = 0;
    }

    public void start() {
        System.out.println(art.batman());

        while (success < 3 && fails < 3) {
            //give the riddler image we want

            System.out.println(riddle.giveRiddle());
            boolean check = riddle.checkANS();
            if (check) {
                success++;
                printRandomReply();
            } else {
                fails++;
                System.out.println(ANSI_RED + "WRONG! The answer was: " + riddle.getAnswer() + ANSI_RESET);
            }
        }

        if (success == 3) {
            printWinMessage();
        } else if (fails == 3) {
            System.out.println(challenge.grapple());
            if (challenge.check()) {
                System.out.println(ANSI_RED + "Very well, Batman. I'll give you a second chance." + ANSI_RESET);
                System.out.println(riddle.giveRiddle());
                if (riddle.checkANS()) {
                    printWinMessage();
                } else {
                    printLoseMessage();
                }
            } else {
                printLoseMessage();
            }
        }
    }
}