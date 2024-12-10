// learned Thread.sleep() from: https://stackoverflow.com/questions/62725118/how-can-i-make-a-pause-between-two-print-functions
// learned colored text from: https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
// array from: https://www.freecodecamp.org/news/java-array-how-to-declare-and-initialize-an-array-in-java-example/#:~:text=In%20Java%2C%20you%20use%20an,your%20array%20should%20be%20strings.

//add something that asks if the player wants to try again or play again after they finish
//can use Thread.sleep(1000); between print messages to delay prints; better game flow
import java.util.Scanner;

public class Logic {
    private Challenge challenge;
    private Riddles riddle;
    private TextArt art;

    private int success = 0;
    private int fails = 0;
    private boolean previous;
    private String defuserCode;

    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String purple = "\u001B[35m";

    Scanner scan = new Scanner(System.in);

    public Logic() {
        challenge = new Challenge();
        riddle = new Riddles();
        art = new TextArt();
    }

    public void printIntroduction(String playerName) throws InterruptedException {
        System.out.println("Welcome, " + playerName + ", to Gotham's most dangerous challenge!");
        Thread.sleep(3000);
    }

    public void printIntroduction() throws InterruptedException {
        System.out.println("===============================================================");
        System.out.println("      🦇 BATMAN vs THE RIDDLER: The Riddler's Trials 🧩");
        System.out.println("===============================================================");
        //Thread.sleep(2500);
        System.out.println();
        System.out.println("🎩 The Riddler has struck again! Gotham is on the brink of chaos.");
        System.out.println("He has planted explosives all over the city, and only YOU,");
        System.out.println("the world’s greatest detective, can stop him.");
        //Thread.sleep(5000);
        System.out.println();
        System.out.println("But beware! You’ll face a series of tricky riddles.");
        System.out.println("Answer correctly, and you edge closer to saving Gotham.");
        System.out.println("Fail... and the city will pay the ultimate price.");
        //Thread.sleep(5000);
        System.out.println();
        System.out.println("💥 **3 Correct Answers**: Gotham is saved!");
        System.out.println("💣 **3 Wrong Answers**: Face the final challenge... or watch Gotham fall.");
        //Thread.sleep(5000);
        System.out.println();
        System.out.println("💡 Can you outsmart The Riddler and save the city?");
        System.out.println("The clock is ticking...");
        //Thread.sleep(5000);
        System.out.println();
        System.out.println("                **Good luck, Detective.**");
        System.out.println("===============================================================");
        //Thread.sleep(2500);

        while (true) {
            System.out.print("Do you want to continue? (yes/no): ");
            String x = scan.nextLine();

            if (x.equalsIgnoreCase("yes")) {
                System.out.println("Continuing the game...");
                break;
            } else if (x.equalsIgnoreCase("no")) {
                System.out.println(red + "\"Too bad, Detective!\"" + reset);
                System.out.println("Continuing the game...");
                break;
            } else {
                System.out.println("Invalid response, Detective. Please answer with a \"yes\" or a \"no\"");
            }
        }
    }

    public void printRandomReply() {
        String[] replies = {
                "\"Well, well, well, the Detective lives up to his name.\"",
                "\"Lucky guess, or are you truly as sharp as they say?\"",
                "\"You think you're so clever, don't you? Let's see how long that lasts!\"",
                "\"A fluke, surely. Care to try your luck again?\"",
                "\"Oh, bravo, Batman! But don't let it go to your head.\"",
                "\"Even a dull blade can cut once in a while.\""
        };
        System.out.println(red + replies[(int)(Math.random() * replies.length)] + reset);
    }

    public void printWinMessage() {
        System.out.println(green + "You won, Gotham lives to see another night");
        System.out.println("The Riddler will be sent to Arkham and receive no psychiatric help" + reset);
    }

    public void printLoseMessage() {
        System.out.println(purple + "You lost, Gotham has been blown to smithereens");
        System.out.println(":(" + reset);
    }

    public void resetGame() {
        success = 0;
        fails = 0;
    }

    public void start() throws InterruptedException {
        System.out.println("Who dares to step into the spotlight and face this formidable challenge?");
        System.out.print("State your name: ");
        printIntroduction(scan.nextLine());
        printIntroduction();
        Thread.sleep(3000);
        System.out.println(art.batLight());
        System.out.println("**You encounter the Riddler**");

        System.out.println(art.baseRiddler());
        while (success < 3 && fails < 3) {

            System.out.println(riddle.giveRiddle());
            boolean check = riddle.checkANS();

            if (check) {
                success++;
                printRandomReply();
                System.out.println();
            } else {
                fails++;
                System.out.println(red + "\"WRONG! The answer was: " + riddle.getAnswer() + "\"" + reset);
                System.out.println();
            }
        }

        if (success == 3) {
            printWinMessage();
        } else if (fails == 3) {

            System.out.println(art.madRiddler());
            challenge.mad(success);

            System.out.println(challenge.grapple());
            if (challenge.check()) {
                // now you have to check which bomb is the main bomb
                challenge.check(success);
                challenge.defusal();
                Thread.sleep(5000);
                System.out.println("Do you go for the bomb in: Gotham Library, Wayne Enterprises Building, or Gotham City Hall");

                System.out.println(art.device());

                // add something here thats like "WHATS THIS RIDDLER LEFT A POST IT BY ACCIDENT, it says something about how he couldn't
                // remember the defusal code since the scarecrow was always messing with him and getting him blasted so he wrote it down

                defuserCode = scan.nextLine();

                if (challenge.check(defuserCode)) {
                    printWinMessage();
                }
                else {
                    printLoseMessage();
                }

            } else {
                printLoseMessage();
            }

        }
    }
}