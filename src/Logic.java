//add something that asks if the player wants to try again or play again after they finish
//add game introduction
//can use Thread.sleep(1000); between print messages to delay prints; better game flow
import java.util.Scanner;

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

    Scanner scan = new Scanner(System.in);

    public Logic() {
        challenge = new Challenge();
        riddle = new Riddles();
        art = new TextArt();
    }

    public void printIntroduction() throws InterruptedException {
        System.out.println("===============================================================");
        System.out.println("            🦇 BATMAN vs THE RIDDLER: Mini-Boss Fight 🧩");
        System.out.println("===============================================================");
        Thread.sleep(1500);
        System.out.println();
        System.out.println("🎩 The Riddler has struck again! Gotham is on the brink of chaos.");
        System.out.println("He has planted explosives all over the city, and only YOU,");
        System.out.println("the world’s greatest detective, can stop him.");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("But beware! You’ll face a series of tricky riddles.");
        System.out.println("Answer correctly, and you edge closer to saving Gotham.");
        System.out.println("Fail... and the city will pay the ultimate price.");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("💥 **3 Correct Answers**: Gotham is saved!");
        System.out.println("💣 **3 Wrong Answers**: Face the final challenge... or watch Gotham fall.");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("💡 Can you outsmart The Riddler and save the city?");
        System.out.println("The clock is ticking...");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("                **Good luck, Detective.**");
        System.out.println("===============================================================");
        Thread.sleep(1500);
        System.out.println("Continue? (y/n): ");
        if (scan.nextLine().equals("n")) {
            System.out.println(ANSI_RED + "Too bad, Detective!" + ANSI_RESET);
        }
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

    public void start() throws InterruptedException {
        printIntroduction();
        Thread.sleep(3000);
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