public class Logic {
    private int success = 0;
    private int fails = 0;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public Logic() {

    }

    public void start() {
        Challenge challenge = new Challenge();
        Riddles riddle = new Riddles();
        TextArt art = new TextArt();

        System.out.println(art.batman());

        while (success < 3 || fails < 3) {
            //give the riddler image we want

            System.out.println(riddle.giveRiddle());
            boolean check = riddle.checkANS();
            if (check) {
                success++;
                int reply = (int) (Math.random() * 6 + 1);
                if (reply == 1) {
                    System.out.println(ANSI_RED + "Well, well, well, the Detective lives up to his name." + ANSI_RESET);
                } else if (reply == 2) {
                    System.out.println(ANSI_RED + "Lucky guess, or are you truly as sharp as they say?" + ANSI_RESET);
                } else if (reply == 3) {
                    System.out.println(ANSI_RED + "You think you're so clever, don't you? Let's see how long that lasts!" + ANSI_RESET);
                } else if (reply == 4) {
                    System.out.println(ANSI_RED + "A fluke, surely. Care to try your luck again?" + ANSI_RESET);
                } else if (reply == 5) {
                    System.out.println(ANSI_RED + "Oh, bravo, Batman! But don't let it go to your head." + ANSI_RESET);
                } else if (reply == 6) {
                    System.out.println(ANSI_RED + "Even a dull blade can cut once in a while." + ANSI_RESET);
                }
            } else {
                fails++;
                System.out.println(ANSI_RED + "WRONG! The answer was: " + riddle.getAnswer() + ANSI_RESET);
            }

            if (success == 3 || fails == 3) {
                break;
            }
        }

        if (success == 3) {
            //show game win image
            System.out.println(ANSI_GREEN + "You won, Gotham lives to see another night");
            System.out.println("The Riddler will be sent to Arkham and receive no psychiatric help" + ANSI_RESET);
        }

        if (fails == 3) {
            //put grapple image here
            System.out.println(challenge.grapple());
            //boolean checkChallenge = challenge.check();

            if (challenge.check()) {
                System.out.println(riddle.giveRiddle());
                if (riddle.checkANS()) {
                    //show game win image
                    System.out.println(ANSI_GREEN + "You won, Gotham lives to see another night");
                    System.out.println("The Riddler will be sent to Arkham and receive no psychiatric help" + ANSI_RESET);
                } else {
                    // show the game over lose image
                    System.out.println(ANSI_PURPLE + "You lost, Gotham has been blown to smithereens");
                    System.out.println(":(" + ANSI_RESET);
                }
            }
            else {
                // show the game over lose image
                System.out.println(ANSI_PURPLE + "You lost, Gotham has been blown to smithereens");
                System.out.println(":(" + ANSI_RESET);
            }
        }
        else {
            //show game win image
            System.out.println(ANSI_GREEN + "You won, Gotham lives to see another night");
            System.out.println("The Riddler will be sent to Arkham and receive no psychiatric help" + ANSI_RESET);
        }
    }
}